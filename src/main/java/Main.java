import gui_codebehind.GUI_BoardController;
import gui_fields.GUI_Player;
import gui_main.GUI;
import gui_fields.*;

import java.awt.*;
import java.util.Random;

public class Main {
    private static int antalSpillere;

    public static void main(String[] args) {
        GUI gui = new GUI(Felter.gameBoard, Color.WHITE);

        //Spørger brugeren om hvor mange spillere der er
        Spiller.antalSpillere(gui);{
            antalSpillere = Spiller.antalSpillere;
        }

        //Spørger om spillernes navne og sætter dem i et array spillerNavne[]
        Spiller.setNames(gui);


        // Opretter array af spillerobjeckter svarende til antal spillere
        GUI_Player[] player = new GUI_Player[antalSpillere];

        for (int i = 0; i < antalSpillere; i++) {
            player[i] = new GUI_Player(Spiller.spillerNavne[i], 20);
            gui.addPlayer(player[i]);
            GUI_Field field = gui.getFields()[0];
            field.setCar(player[i], true);
        }


        String chosenButton = "";
        while (player[0].getBalance() < 30) {
            if (chosenButton != "kast terning!") {
                chosenButton = gui.getUserButtonPressed(
                        " ",
                        "Kast terningen!"
                );
                chosenButton = "";

                player[0].setBalance(player[0].getBalance() + 1);
                gui.setDie((int) (Math.random() * 6) + 1); // Viser én terning med værdien 6


            }
        }


    }
}


//GUI_Field field = gui.getFields()[0]; //sætter start placering

//String p1Input = gui.getUserString("Skriv dit navn");
//String p2Input = gui.getUserString("Skriv dit navn");




