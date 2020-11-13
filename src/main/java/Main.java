import gui_codebehind.GUI_BoardController;
import gui_fields.GUI_Player;
import gui_main.GUI;
import gui_fields.*;

import java.awt.*;
import java.util.Random;

public class Main {
    private static int antalSpillere;



    public static void main(String[] args) {
        String kastButton = "";
        boolean falit = false;
        int[] spillerLocation;
        int dice = 0;

        GUI gui = new GUI(Felter.gameBoard, Color.WHITE);   //Opretter selve GUI vinduet

        //Spørger brugeren om hvor mange spillere der er
        Spiller.antalSpillere(gui);{
            antalSpillere = Spiller.antalSpillere;
        }

        //Spørger om spillernes navne og sætter dem i et array spillerNavne[]
        Spiller.setNames(gui);


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


                    //---------------------------------------------------------------------------------------
                    //Kaster terningen og rykker bilerne rundt på pladen
                    //---------------------------------------------------------------------------------------
                    gui.getFields()[location[i]].setCar(player[i], false);          //Fjerner den tidligere bil

                    dice = ((int)(Math.random() * 6) + 1);  // Finder en værdi mellem 1-6
                    gui.setDie(dice);                       // Viser én terning
                    location[i] = location[i] + dice;       //Spillerens lokation + terningens værdi

                    if (location[i] <= 24) {}   //Tjekker hvis bilen har været pladen rundt
                    else{
                        location[i] = location[i]-24;
                    }
                        //Rykker bilerne
                        gui.getFields()[location[i]].setCar(player[i], true);       //Viser bilens nye position





                    player[i].setBalance(player[i].getBalance() + 1);

                }
            }
        }



    }
}


//GUI_Field field = gui.getFields()[0]; //sætter start placering





