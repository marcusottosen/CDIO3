import gui_fields.GUI_Player;
import gui_main.GUI;
import gui_fields.*;

import java.awt.*;
import java.util.Random;

public class Main {
    static GUI_Field[] gameBoard = {
            new GUI_Start("START", "Få 2 penge", "Du passerer nu start", Color.white, Color.black),
            new GUI_Street("Burgerbar", "1", "en bar", "1", Color.orange, Color.BLACK),
            new GUI_Street("pizzaria", "1", "en bar", "1", Color.orange, Color.BLACK),
            new GUI_Chance(),
            new GUI_Street("Slikbutikken", "1", "en bar", "1", Color.blue, Color.BLACK),
            new GUI_Street("Iskiosken", "1", "en bar", "1", Color.blue, Color.BLACK),

            new GUI_Shipping(),

            new GUI_Street(),
            new GUI_Street(),
            new GUI_Chance(),
            new GUI_Street(),
            new GUI_Street(),

            new GUI_Shipping(),

            new GUI_Street(),
            new GUI_Street(),
            new GUI_Chance(),
            new GUI_Street(),
            new GUI_Street(),

            new GUI_Jail(),

            new GUI_Street(),
            new GUI_Street(),
            new GUI_Chance(),
            new GUI_Street(),
            new GUI_Street(),
    };

    public static void main(String[] args) {
        GUI gui = new GUI(gameBoard, Color.WHITE);
        //GUI_Field field = gui.getFields()[0]; //sætter start placering

        //String p1Input = gui.getUserString("Skriv dit navn");
        //String p2Input = gui.getUserString("Skriv dit navn");

        String antalSpillerInput = gui.getUserString("Skriv dit navn");
        int antalSpillere = Integer.parseInt(antalSpillerInput);    // Laver string input om til int
        GUI_Player player[] = new GUI_Player[antalSpillere];        // Opretter array svarende til antal spillere

        for (int i = 0; i < antalSpillere; i++) {
            player[i] = new GUI_Player("Stephen"+i, 20);
            player[i].setName("hello");
            player[i].setBalance(20);
            gui.addPlayer(player[i]);
            GUI_Field field = gui.getFields()[0];
            field.setCar(player[i], true);
        }





        String chosenButton = "";
        while(player[0].getBalance()<30) {
            if (chosenButton != "kast terning!") {
                chosenButton = gui.getUserButtonPressed(
                        " ",
                        "Kast terningen!"
                );
                chosenButton = "";

                player[0].setBalance(player[0].getBalance()+1);
                gui.setDie((int)(Math.random()*6)+1); // Viser én terning med værdien 6



            }
        }


   }
}



