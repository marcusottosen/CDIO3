import gui_codebehind.GUI_BoardController;
import gui_fields.GUI_Player;
import gui_main.GUI;
import gui_fields.*;

import java.awt.*;
import java.util.Random;

public class Main {
    public static int antalSpillere;
    private static GUI_Car UFO;

    GUI_Ownable ownable;

    public static int currentPlayer;
    public static GUI gui = new GUI(Felter.gameBoard, Color.WHITE);   //Opretter selve GUI vinduet
    public static int[] location;       // Opretter array til spillernes lokation
    public static GUI_Player[] player;  // Opretter array af spillerobjeckter svarende til antal spillere
    public static boolean[] isJailed;   // Opretter array til tjek om den enkelte spiller er i fængsel





    public static void main(String[] args) {
        String kastButton = "";
        //boolean falit = false;
        //int[] spillerLocation;
        int dice = 0;
        int feltPris;
        boolean falit = false;


        //Spørger brugeren om hvor mange spillere der er
        Spiller.antalSpillere(gui);{
            antalSpillere = Spiller.antalSpillere;
        }

        //Spørger om spillernes navne og sætter dem i et array spillerNavne[]
        Spiller.setNames(gui);

        // Opretter array af spillerobjeckter svarende til antal spillere
        player = new GUI_Player[antalSpillere];


        // Tilføjer navn og balance til spillerobjecterne og viser dem visuelt på pladen.
        for (int i = 0; i < antalSpillere; i++) {
            player[i] = new GUI_Player(Spiller.spillerNavne[i], 20);
            gui.addPlayer(player[i]);
            GUI_Field field = gui.getFields()[0];
            field.setCar(player[i], true);
        }

        location = new int[antalSpillere];            //Opretter array til spillernes lokation
        isJailed = new boolean[antalSpillere];        //Opretter array til at holde styr på hvem der er i fængsel


        //---------------------------------------------------------------------------------------
        //Loop som spillet køres i
        //---------------------------------------------------------------------------------------

        outer : while (!falit) {
            for (int i = 0; i < player.length; i++) {   //Tjekker om der er en spiller der er gået falit
                if (player[i].getBalance() <= 0) {
                    falit = true;
                    break outer;    //Hopper ud af while loopet hvis en spiller er gået falit
                }
            }

            inner : for (int i = 0; i < player.length; i++) {       //Skifter mellem spillernes tur
                if (kastButton != "kast terning!") {
                    kastButton = gui.getUserButtonPressed(          //Knap til kast af terning
                            player[i].getName() + " kaster",
                            "Kast terningen!"
                    );
                    currentPlayer = i;
                    kastButton = "";

                    //---------------------------------------------------------------------------------------
                    //Kaster terningen
                    //---------------------------------------------------------------------------------------
                    dice = Dice.roll();  // Finder en værdi mellem 1-6
                    gui.setDie(dice);                       // Viser én terning



                    //---------------------------------------------------------------------------------------
                    //Tjekker om spilleren er blevet sat i fængsel
                    //---------------------------------------------------------------------------------------
                    if (isJailed[i]){
                        if (RunChanceKort.getOutOfJail[i]) {    //Hvis spilleren har "get out of jail" chancekortet, tages han ud af fængslet
                            isJailed[i] = false;
                            RunChanceKort.getOutOfJail[i] = false;
                        }
                        else{
                            isJailed[i] = false;
                            dice = 0;    //Skipper spillerens tur ved ikke at lade spilleren rykke sig
                            gui.showMessage("Fordi du er i fængsel gælder dit kast ikke!");
                        }
                    }


                    //---------------------------------------------------------------------------------------
                    //Rykker bilerne rundt på pladen
                    //---------------------------------------------------------------------------------------
                    gui.getFields()[location[i]].setCar(player[i], false);          //Fjerner den tidligere bil
                    location[i] = location[i] + dice;       //Spillerens lokation + terningens værdi

                    if (location[i] <= 23) {}   // Gør det muligt for bilen at køre pladen rundt
                    else if (location[i]==23){
                        location[i]=0;
                        player[i].setBalance(player[i].getBalance()+2);     //Giver 2 penge over start
                    }
                    else{
                        location[i] = location[i]-24;
                        player[i].setBalance(player[i].getBalance()+2);     //Giver 2 penge over start
                    }

                    gui.getFields()[location[i]].setCar(player[i], true);       //Viser bilens nye position



                    //---------------------------------------------------------------------------------------
                    //Når en spiller lander på et chancekort
                    //---------------------------------------------------------------------------------------
                    if(     location[i] == 3 ||
                            location[i] == 9 ||
                            location[i] == 15||
                            location[i] == 21
                    ){
                        // Der findes et chancekort


                        new GUI_Chance("Title", "subText", "description", Color.red, Color.black);
                        gui.setChanceCard("hello");
                        gui.displayChanceCard();

                    }

                    //---------------------------------------------------------------------------------------
                    // Køb af vej samt betaling til andre spillere
                    //---------------------------------------------------------------------------------------

                    GUI_Field field = gui.getFields()[location[i]];
                    if (FeltLogik.feltType(location[i]).equals("street")) {                       //Tjekker om feltet er en vej
                        System.out.println("Dette er en vej");
                        GUI_Ownable ownable = (GUI_Ownable) field;
                        GUI_Street street = (GUI_Street) field;
                        feltPris = Integer.parseInt(Felter.gameBoard[location[i]].getSubText()); //Finder prisen for feltet og laver det om til int



                        if (ownable.getOwnerName() == player[i].getName()) {    // Tjekker om vejen er købt af spilleren selv.
                            System.out.println("Du ejer dette felt");
                        }
                        else if(FeltLogik.isOwned(player,ownable.getOwnerName())){  //Tjekker om vejen er købt af andre spillere
                            System.out.println("Dette felt er allerede købt! Betal penge!");
                            player[i].setBalance(player[i].getBalance()-feltPris);  //trækker penge fra spillere
                            player[FeltLogik.ownerNumber(player, ownable.getOwnerName())]   //Tilføjer penge til ejeren af feltet
                                    .setBalance(player[FeltLogik.ownerNumber(player, ownable.getOwnerName() )].getBalance()+feltPris);
                        }

                        else {  //Feltet købes af spilleren
                            street.setHouses(1);
                            ownable.setOwnerName(Spiller.spillerNavne[i]);
                            ownable.setBorder(player[i].getPrimaryColor());
                            player[i].setBalance(player[i].getBalance() - feltPris);
                        }
                    }
                    else{
                        System.out.println("dette er ikke en vej");
                    }


                    //---------------------------------------------------------------------------------------
                    // Fængsel
                    //---------------------------------------------------------------------------------------
                    if(FeltLogik.feltType(location[i]).equals("goToJail")){
                        System.out.println("Du blev rykket til fængslet!");

                        gui.getFields()[location[i]].setCar(player[i], false);
                        location[i] = 6;
                        gui.getFields()[location[i]].setCar(player[i], true);

                        isJailed[i]=true;

                    }
                    System.out.println("\n");

                }
            }
        }
        //Når en spiller går falit
        if(falit){
            gui.showMessage("Spillet er slut! " + Logik.findTaber(player) + " er gået falit!" + "\n" +
                    Logik.findVinner(player) + " havde flest points!");
        }
    }
}