import gui_codebehind.GUI_BoardController;
import gui_fields.GUI_Player;
import gui_main.GUI;
import gui_fields.*;

import java.awt.*;
import java.util.Random;

public class Main {
    private static int antalSpillere;
    private static GUI_Car UFO;
    GUI_Player[] player;
    GUI_Ownable ownable;


    public static void main(String[] args) {
        String kastButton = "";
        //boolean falit = false;
        //int[] spillerLocation;
        int dice = 0;
        int feltPris;

        GUI gui = new GUI(Felter.gameBoard, Color.WHITE);   //Opretter selve GUI vinduet

         boolean falit = false;



        //Felter.startGame();
        //Spørger brugeren om hvor mange spillere der er
        Spiller.antalSpillere(gui);{
            antalSpillere = Spiller.antalSpillere;
        }

        //Spørger om spillernes navne og sætter dem i et array spillerNavne[]
        Spiller.setNames(gui);
        //RunChanceKort.kort1(gui);


        // Opretter array af spillerobjeckter svarende til antal spillere
        GUI_Player[] player = new GUI_Player[antalSpillere];



        // Tilføjer navn og balance til spillerobjecterne og viser dem visuelt på pladen.
        for (int i = 0; i < antalSpillere; i++) {
            player[i] = new GUI_Player(Spiller.spillerNavne[i], 20);
            gui.addPlayer(player[i]);
            GUI_Field field = gui.getFields()[0];
            field.setCar(player[i], true);
        }

        int[] location = new int[antalSpillere];            //Opretter array til spillernes lokation


        //---------------------------------------------------------------------------------------
        //Loop som spillet køres i
        //---------------------------------------------------------------------------------------

        outer : while (!falit) {
            for (int i = 0; i < player.length; i++) {   //Tjekker om der er en spiller der er gået falit
                if (player[i].getBalance() <= 0) {
                    falit = true;
                    break outer;    //Hopper ud af while loopet
                }
            }

            for (int i = 0; i < player.length; i++) {       //Skifter mellem spillernes tur
                if (kastButton != "kast terning!") {
                    kastButton = gui.getUserButtonPressed(    //Knap til kast af terning
                            " ",
                            "Kast terningen!"
                    );
                    kastButton = "";


                    System.out.println(player[i].getName());
                    //---------------------------------------------------------------------------------------
                    //Kaster terningen og rykker bilerne rundt på pladen
                    //---------------------------------------------------------------------------------------
                    gui.getFields()[location[i]].setCar(player[i], false);          //Fjerner den tidligere bil

                    dice = ((int)(Math.random() * 6) + 1);  // Finder en værdi mellem 1-6
                    gui.setDie(dice);                       // Viser én terning
                    location[i] = location[i] + dice;       //Spillerens lokation + terningens værdi
                    System.out.println(location[i]);


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


                    //Felter.gameBoard.setHouses(1);




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
                        feltPris = Integer.parseInt(Felter.gameBoard[location[i]].getSubText());//Finder prisen for feltet og laver det om til int



                        if (ownable.getOwnerName() == player[i].getName()) {    // Tjekker om vejen er købt af spilleren selv.
                            System.out.println("Du ejer dette felt");
                        }
                        else if(FeltLogik.isOwned(player,ownable.getOwnerName())){  //Tjekker om vejen er købt af andre spillere
                            System.out.println("Dette felt er allerede købt! Betal penge!");
                            player[i].setBalance(player[i].getBalance()-feltPris);  //trækker penge fra spillere
                            player[FeltLogik.ownerNumber(player, ownable.getOwnerName())]
                                    .setBalance(player[FeltLogik.ownerNumber(player, ownable.getOwnerName() )].getBalance()+feltPris);
                        }

                        else {
                            System.out.println("Køb feltet");
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
                    //Fængsel
                    //---------------------------------------------------------------------------------------
                    if(FeltLogik.feltType(location[i]).equals("goToJail")){
                        System.out.println("Du blev rykket til fængslet!");
                        gui.getFields()[location[i]].setCar(player[i], false);
                        location[i] = 6;
                        gui.getFields()[location[i]].setCar(player[i], true);

                    }


                    System.out.println("\n");


                }


            }
        }
        //Når en spiller går falit
        if(falit){
            gui.showMessage("Spillet er slut! Spiller " + Logik.findTaber(player) + " er gået falit!" + "\n" +
                    "Spiller " + Logik.findVinner(player) + " havde flest points");
        }
    }
}