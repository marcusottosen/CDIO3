import gui_main.GUI;
import gui_fields.*;
import gui_fields.GUI_Player;

import java.awt.*;


public class Spiller {

    public static String[] spillerNavne;                       //Array af spillernes navne
    private int konto;
    public static int antalSpillere;


    //Konstruktør
    public Spiller() {
        konto = Logik.startKonto;
    }


    public int getkonto() {
        return konto;
    }

    public void setKonto(int a) {
        if (konto + a < 0)
            konto = 0;
        else
            konto = konto + a;
    }


    public static int antalSpillere(GUI gui) {                   //Finder antal spillere
        String antalSpillerInput = gui.getUserSelection(
                "Vælg antal spillere",
                "2", "3", "4"
        );
        antalSpillere = Integer.parseInt(antalSpillerInput);      // Laver string input om til int
        return antalSpillere;
    }

    public static String[] setNames(GUI gui) {                  //Finder spillernes navne og sætter dem ind i arrayet
        spillerNavne = new String[antalSpillere];               //Sætter arrayet til antallet af spillere
        for (int i = 0; i < antalSpillere; i++) {
            String navnInput = gui.getUserString("Indtast navn på spiller " + (i + 2));
            spillerNavne[i] = navnInput;

        }
        return spillerNavne;
    }
}

