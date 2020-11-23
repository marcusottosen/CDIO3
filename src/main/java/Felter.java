import gui_fields.GUI_Chance;
import gui_fields.GUI_Field;
import gui_fields.GUI_Start;
import gui_fields.GUI_Street;
import gui_fields.GUI_Jail;
import gui_fields.GUI_Refuge;
import java.awt.Color;
import javax.swing.ImageIcon;


public final class Felter {
    private final static Color red = Color.decode("#ff7875");
    private final static Color orange = Color.decode("#ff9c6e");
    private final static Color yellow = Color.decode("#fff566");
    private final static Color green = Color.decode("#95de64");
    private final static Color blue = Color.decode("#69c0ff");
    private final static Color cyan = Color.decode("#5cdbd3");
    private final static Color lightOrange = Color.decode("#ffc069");
    private final static Color magenta = Color.decode("#ff85c0");

    static ImageIcon icon = new ImageIcon("GUI_Field.Image.Cones");

    static GUI_Field[] gameBoard = {
            new GUI_Start("START", "Få 2 penge", "Du passerer nu start", Color.white, Color.black),

            new GUI_Street("Burgerbaren", "1", "en bar", "1", red, Color.BLACK),
            new GUI_Street("Pizzariaet", "1", "en bar", "1", red, Color.BLACK),
            new GUI_Chance("?", "Prøv lykken!", "Træk et kort og håb på det bedste", Color.white, Color.BLACK),
            new GUI_Street("Slikbutikken", "1", "en bar", "1", orange, Color.BLACK),
            new GUI_Street("Iskiosken", "1", "en bar", "1", orange, Color.BLACK),

            //GUI_Field.Image.Jail
            new GUI_Jail("GUI_Field.Image.Jail", "Fængsel", "Fængsel", "Tag på besøg i fængslet!", Color.white, Color.BLACK),

            new GUI_Street("Museet", "2", "en bar", "1", green, Color.BLACK),
            new GUI_Street("Biblikoteket", "2", "en bar", "1", green, Color.BLACK),
            new GUI_Chance("?", "Prøv lykken!", "Træk et kort og håb på det bedste", Color.white, Color.BLACK),
            new GUI_Street("Skaterparken", "2", "en bar", "1", blue, Color.BLACK),
            new GUI_Street("Swimmingpoolen", "2", "en bar", "1", blue, Color.BLACK),

            new GUI_Refuge("GUI_Field.Image.Ferry4", "Parkering", "Parkering", "Du får lov til at holde her helt gratis!", Color.white, Color.BLACK),

            new GUI_Street("Spillehallen", "3", "en bar", "1", lightOrange, Color.BLACK),
            new GUI_Street("Biografen", "3", "en bar", "1", lightOrange, Color.BLACK),
            new GUI_Chance("?", "Prøv lykken!", "Træk et kort og håb på det bedste", Color.white, Color.BLACK),
            new GUI_Street("Legetøjsbutikken", "3", "en bar", "1", cyan, Color.BLACK),
            new GUI_Street("Dyrehandlen", "3", "en bar", "1", cyan, Color.BLACK),

            //GUI_Field.Image.GoToJail
            new GUI_Jail("GoToJail.jpg", "Gå i fængsel", "Gå i fængsel",
                    "Du bliver sat i fængsel i 1 runde vedmindre du har et kort til at komme ud!", Color.white, Color.BLACK),

            new GUI_Street("Bowlinghallen", "4", "en bar", "1", magenta, Color.BLACK),
            new GUI_Street("Zoo", "4", "en bar", "1", magenta, Color.BLACK),
            new GUI_Chance("?", "Prøv lykken!", "Træk et kort og håb på det bedste", Color.white, Color.BLACK),
            new GUI_Street("Vandlandet", "4", "en bar", "1", yellow, Color.BLACK),
            new GUI_Street("Strandpromenaden", "4", "en bar", "1", yellow, Color.BLACK),
    };
}