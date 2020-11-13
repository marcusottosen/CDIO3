import gui_fields.*;

import java.awt.*;

public class Felter {
    private String OrangeFri = "";


    static GUI_Field[] gameBoard = {
            new GUI_Start("START", "Få 2 penge", "Du passerer nu start", Color.white, Color.black),

            new GUI_Street("Burgerbaren", "1", "en bar", "1", Color.orange, Color.BLACK),
            new GUI_Street("Pizzariaet", "1", "en bar", "1", Color.orange, Color.BLACK),
            new GUI_Chance(),
            new GUI_Street("Slikbutikken", "1", "en bar", "1", Color.blue, Color.BLACK),
            new GUI_Street("Iskiosken", "1", "en bar", "1", Color.blue, Color.BLACK),

            new GUI_Shipping(),

            new GUI_Street("Nysset", "1", "en bar", "1", Color.gray, Color.BLACK),
            new GUI_Street("Biblikoteket", "1", "en bar", "1", Color.gray, Color.BLACK),
            new GUI_Chance(),
            new GUI_Street("Skaterparken", "1", "en bar", "1", Color.gray, Color.BLACK),
            new GUI_Street("Swimmingpoolen", "1", "en bar", "1", Color.gray, Color.BLACK),

            new GUI_Shipping(),

            new GUI_Street("Spillehallen", "1", "en bar", "1", Color.gray, Color.BLACK),
            new GUI_Street("Biografen", "1", "en bar", "1", Color.gray, Color.BLACK),
            new GUI_Chance(),
            new GUI_Street("Legetøjsbutikken", "1", "en bar", "1", Color.gray, Color.BLACK),
            new GUI_Street("Dyrehandlen", "1", "en bar", "1", Color.gray, Color.BLACK),

            new GUI_Jail(),

            new GUI_Street("Bowlinghallen", "1", "en bar", "1", Color.gray, Color.BLACK),
            new GUI_Street("Zoo", "1", "en bar", "1", Color.gray, Color.BLACK),
            new GUI_Chance(),
            new GUI_Street("Vandlandet", "1", "en bar", "1", Color.gray, Color.BLACK),
            new GUI_Street("Strandpromenaden", "1", "en bar", "1", Color.gray, Color.BLACK),
    };
}
