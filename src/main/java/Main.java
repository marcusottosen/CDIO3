import gui_fields.GUI_Field;
import gui_fields.GUI_Ownable;
import gui_fields.GUI_Player;
import gui_fields.GUI_Street;
import gui_main.GUI;
import java.awt.Color;
import gui_codebehind.*;
import gui_fields.*;
import java.awt.Color; //Import af farverne


public class Main {
    public static int antalSpillere;
    public static int currentPlayer;
    public static GUI gui = new GUI(Felter.gameBoard, Color.WHITE);   //Opretter selve GUI vinduet.
    public static int[] location;       // Opretter array til spillernes lokation.
    public static GUI_Player[] player;  // Opretter array af spillerobjeckter svarende til antal spillere.
    public static boolean[] isJailed;   // Opretter array til tjek om den enkelte spiller er i fængsel.
    public static int dice = 0;


    public static void main(String[] args) {
        String kastButton = "";

        int feltPris;
        boolean falit = false;


        //Spørger brugeren om hvor mange spillere der er
        Spiller.antalSpillere(gui);
        {
            antalSpillere = Spiller.antalSpillere;
        }

        //Spørger om spillernes navne og sætter dem i et array spillerNavne[]
        Spiller.setNames(gui);

        // Opretter array af spillerobjeckter svarende til antal spillere
        player = new GUI_Player[antalSpillere];

        // Tilføjer navn og balance til spillerobjecterne og viser dem visuelt på pladen.
        for (int i = 0; i < antalSpillere; i++) {
            player[i] = new GUI_Player(Spiller.spillerNavne[i], Spiller.spillerBalance());
            gui.addPlayer(player[i]);
            GUI_Field field = gui.getFields()[0];
            field.setCar(player[i], true);
        }

        location = new int[antalSpillere];            //Opretter array til spillernes lokation
        isJailed = new boolean[antalSpillere];        //Opretter array til at holde styr på hvem der er i fængsel


        //---------------------------------------------------------------------------------------
        //Loop som spillet køres i
        //---------------------------------------------------------------------------------------

        outer:
        while (!falit) {
            for (GUI_Player gui_player : player) {   //Tjekker om der er en spiller der er gået falit
                if (gui_player.getBalance() <= 0) {
                    falit = true;
                    break outer;    //Hopper ud af while loopet hvis en spiller er gået falit
                }
            }

            for (int i = 0; i < player.length; i++) {       //Skifter mellem spillernes tur
                if (kastButton != "kast terning!") {
                    kastButton = gui.getUserButtonPressed(          //Knap til kast af terning
                            "Det er spiller " + player[i].getName() + "'s tur!" + "\n" + "Kast din terning for at fortsætte spillet",
                            "Kast terning"
                    );
                    currentPlayer = i;
                    kastButton = "";

                    //---------------------------------------------------------------------------------------
                    //Kaster terningen
                    //---------------------------------------------------------------------------------------
                    dice = Dice.roll();  // Finder en værdi mellem 1-6
                    gui.setDie(dice);    // Viser én terning

                    //---------------------------------------------------------------------------------------
                    //Tjekker om spilleren er blevet sat i fængsel
                    //---------------------------------------------------------------------------------------
                    if (isJailed[i]) {
                        if (RunChanceKort.getOutOfJail[i]) {    //Hvis spilleren har "get out of jail" chancekortet, tages han ud af fængslet
                            isJailed[i] = false;
                            RunChanceKort.getOutOfJail[i] = false;
                        } else {
                            isJailed[i] = false;
                            dice = 0;    //Skipper spillerens tur ved ikke at lade spilleren rykke sig
                            gui.showMessage("Fordi du er i fængsel, gælder dette kast ikke! ...øv");
                        }
                    }

                    //Rykker bilerne rundt på pladen
                    FeltLogik.movePlayer(i, location, player, gui);


                    //---------------------------------------------------------------------------------------
                    //Når en spiller lander på et chancekort
                    //---------------------------------------------------------------------------------------
                    if (location[i] == 3 ||
                            location[i] == 9 ||
                            location[i] == 15 ||
                            location[i] == 21
                    ) {
                        // Der findes et chancekort
                        ChanceKort.pickChanceKort();
                    }


                    //---------------------------------------------------------------------------------------
                    // Køb af vej samt betaling til andre spillere
                    //---------------------------------------------------------------------------------------
                    GUI_Field field = gui.getFields()[location[i]];
                    if (FeltLogik.feltType(location[i]).equals("street")) {                      //Tjekker om feltet er en vej
                        GUI_Ownable ownable = (GUI_Ownable) field;
                        GUI_Street street = (GUI_Street) field;
                        feltPris = Integer.parseInt(Felter.gameBoard[location[i]].getSubText()); //Finder prisen for feltet og laver det om til int


                        if (ownable.getOwnerName() == player[i].getName()) {                     // Tjekker om vejen er købt af spilleren selv.
                            // Spilleren ejer selv dette felt. Gør intet
                        } else if (FeltLogik.isOwned(player, ownable.getOwnerName())) {          //Tjekker om vejen er købt af andre spillere
                            Logik.p2pBetaling(i, player, feltPris, ownable);
                        } else {  //Feltet købes af spilleren
                            Logik.buyFelt(i, street, ownable, feltPris);
                        }
                    } else {
                        System.out.println("dette er ikke en vej");
                    }


                    //---------------------------------------------------------------------------------------
                    // Fængsel
                    //---------------------------------------------------------------------------------------
                    if (FeltLogik.feltType(location[i]).equals("goToJail")) {
                        FeltLogik.jail(gui, player, i);

                    }
                }
            }
        }
        //Når en spiller går falit slutter spillet og hhv. vinder og taber findes
        if (falit) {
            gui.showMessage("Spillet er slut! " + Logik.findTaber(player) + " er gået falit!" + "\n" +
                    Logik.findVinner(player) + " havde flest points!");
        }
    }
}