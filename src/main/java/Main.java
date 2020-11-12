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
        GUI gui = new GUI(gameBoard);
        String p1Input = gui.getUserString("Skriv dit navn");
        String p2Input = gui.getUserString("Skriv dit navn");

        GUI_Player player1 = new GUI_Player(p1Input, 20);
        GUI_Player player2 = new GUI_Player(p2Input, 20);


        gui.addPlayer(player1);
        gui.addPlayer(player2);


        GUI_Field field = gui.getFields()[4];
        field.setCar(player1, true);

// Sætter spillerens bil på felt 5 og 6
        gui.getFields()[4].setCar(player1, true);
        gui.getFields()[5].setCar(player1, true);
// Forkert: Nu vises spillerns bil på begge felter!

        gui.getFields()[4].setCar(player1, false);
// Sådan, nu er bilen fjernet fra felt 5

        gui.setDie((int)(Math.random()*6)+1); // Viser én terning med værdien 6



   }
}



