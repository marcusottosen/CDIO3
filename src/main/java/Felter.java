import gui_fields.*;
import java.awt.*;

public class Felter {
    static GUI_Field[] gameBoard = {
            new GUI_Start("START", "Få 2 penge", "Du passerer nu start", Color.white, Color.black),

            new GUI_Street("Burgerbaren", "1", "en bar", "1", Color.orange, Color.BLACK),
            new GUI_Street("Pizzariaet", "1", "en bar", "1", Color.orange, Color.BLACK),
            new GUI_Chance("?", "Prøv lykken!", "Træk et kort og håb på det bedste", Color.white, Color.BLACK),
            new GUI_Street("Slikbutikken", "1", "en bar", "1", Color.blue, Color.BLACK),
            new GUI_Street("Iskiosken", "1", "en bar", "1", Color.blue, Color.BLACK),

            new GUI_Shipping(),

            new GUI_Street("Nysset", "2", "en bar", "1", Color.gray, Color.BLACK),
            new GUI_Street("Biblikoteket", "2", "en bar", "1", Color.gray, Color.BLACK),
            new GUI_Chance("?", "Prøv lykken!", "Træk et kort og håb på det bedste", Color.white, Color.BLACK),
            new GUI_Street("Skaterparken", "2", "en bar", "1", Color.gray, Color.BLACK),
            new GUI_Street("Swimmingpoolen", "2", "en bar", "1", Color.gray, Color.BLACK),

            new GUI_Shipping(),

            new GUI_Street("Spillehallen", "3", "en bar", "1", Color.gray, Color.BLACK),
            new GUI_Street("Biografen", "3", "en bar", "1", Color.gray, Color.BLACK),
            new GUI_Chance("?", "Prøv lykken!", "Træk et kort og håb på det bedste", Color.white, Color.BLACK),
            new GUI_Street("Legetøjsbutikken", "3", "en bar", "1", Color.gray, Color.BLACK),
            new GUI_Street("Dyrehandlen", "3", "en bar", "1", Color.gray, Color.BLACK),

            new GUI_Jail(),

            new GUI_Street("Bowlinghallen", "4", "en bar", "1", Color.gray, Color.BLACK),
            new GUI_Street("Zoo", "4", "en bar", "1", Color.gray, Color.BLACK),
            new GUI_Chance("?", "Prøv lykken!", "Træk et kort og håb på det bedste", Color.white, Color.BLACK),
            new GUI_Street("Vandlandet", "4", "en bar", "1", Color.gray, Color.BLACK),
            new GUI_Street("Strandpromenaden", "4", "en bar", "1", Color.gray, Color.BLACK),
    };
}
