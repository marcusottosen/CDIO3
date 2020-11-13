import gui_fields.*;

import java.awt.*;

public class Felter {
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
}
