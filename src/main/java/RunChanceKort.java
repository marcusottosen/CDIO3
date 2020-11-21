import gui_fields.GUI_Chance;

import java.awt.*; //Import af farverne

public class RunChanceKort{
    public static boolean[] getOutOfJail = new boolean[Main.antalSpillere];

    //Oprettet 2 metoder til når en bil skal rykke sig på felterne. Første metode fjerner den gamle bil og den næste metode tilføjer en ny.
    private static void removeCar() {
        //Fjerne bilen (Gør man før man rykker bilen)
        Main.gui.getFields()[Main.location[Main.currentPlayer]].setCar(Main.player[Main.currentPlayer], false);          //Fjerner den tidligere bil
    }
    private static void addCar() {
        //Tilføjet bilen igen, efter ny position er givet.
        Main.gui.getFields()[Main.location[Main.currentPlayer]].setCar(Main.player[Main.currentPlayer], true);       //Viser bilens nye position
    }

    //Alle spillere giver 1 penge til spilleren der trak kortet
    public static void kort1() {
        GUI_Chance kort1 = new GUI_Chance("CHANCE", "kort 14", "Det er din fødselsdag! Alle giver dig M1. TILLYKKE MED FØDSELSDAGEN", Color.white, Color.black);
        Main.gui.displayChanceCard(kort1.getDescription());
        System.out.println("Du fik chancekort 1")
        //Giv 1 penge til spillere for hver spiller i spillet.
        Main.player[Main.currentPlayer].setBalance(Main.player[Main.currentPlayer].getBalance() + Main.antalSpillere);
        //Træk 1 penge fra alle spillere. Inklusiv den spiller der fik kortet, da han har fået 1 penge ekstra.
        for (int i = 0; i < Main.antalSpillere; i++) {
            Main.player[Main.currentPlayer].setBalance(Main.player[Main.currentPlayer].getBalance() - 1);
        }
    }

    //Ryk spilleren frem til start og giv ham M2
    public static void kort2() {
        GUI_Chance kort2 = new GUI_Chance("CHANCE", "kort 2", "Ryk frem til START. Modtag M2", Color.white, Color.black);
        Main.gui.displayChanceCard(kort2.getDescription());
        System.out.println("Du fik chancekort 2");
        removeCar();
        Main.location[Main.currentPlayer] = 0;
        Main.player[Main.currentPlayer].setBalance(Main.player[Main.currentPlayer].getBalance()+2);
        addCar();
    }

    //Ryk op til 5 felter frem
    public static void kort3() {
        GUI_Chance kort3 = new GUI_Chance("CHANCE", "kort 3", "Ryk op til 5 felter frem", Color.white, Color.black);
        Main.gui.displayChanceCard(kort3.getDescription());
        System.out.println("Du fik chancekort 3");
        //Vælg hvor mange felter man ønsker at gå frem.
        String chosenElement = Main.gui.getUserSelection(
                "Vælg hvor mange felter du ønsker at rykke",
                "1", "2", "3", "4", "5"
        );
        removeCar();
        //Tilføj bil på ny lokation.
        Main.location[Main.currentPlayer] = Main.location[Main.currentPlayer] + Integer.parseInt(chosenElement);
        addCar();
    }
    //Ryk frem til et valgfrit orange felt
    public static void kort4() {
        GUI_Chance kort4 = new GUI_Chance("CHANCE", "kort 4", "Ryk frem til et orange felt.", Color.white, Color.black);
        Main.gui.displayChanceCard(kort4.getDescription());
        System.out.println("Du fik chancekort 4");
        //Vælg hvilket felt du ønsker at rykke frem til.
        String chosenElement = Main.gui.getUserSelection(
                "Hvilket felt ønsker du at rykke frem til?",
                "4", "5"
        );
        removeCar();
        //Tilføj bil til ny lokation.
        Main.location[Main.currentPlayer] = Integer.parseInt(chosenElement);
        addCar();
    }
    public static void kort5() {
        GUI_Chance kort6 = new GUI_Chance("CHANCE", "kort 5", "Ryk 1 felt frem, eller tag et chancekort mere", Color.white, Color.black);
        Main.gui.displayChanceCard(kort6.getDescription());
        System.out.println("Du fik chancekort 5");
        //Vælg mellem at rykke 1 felt frem, eller at tage et nyt chancekort
        String chosenElement = Main.gui.getUserSelection(
                "Ryk 1 felt frem eller tag et chancekort mere",
                "Ryk frem", "tag nyt chancekort"
        );
        if (chosenElement == "Ryk frem") {
            removeCar();Main.location[Main.currentPlayer]++;addCar();
        } else {
            ChanceKort.pickChanceKort();
        }
    }
    public static void kort6() {
        GUI_Chance kort6 = new GUI_Chance("CHANCE", "kort 11", "Ryk frem til Strandpromenaden.", Color.white, Color.black);
        Main.gui.displayChanceCard(kort6.getDescription());
        System.out.println("Du fik chancekort 6");
        //Ryk frem til Strandpromenaden
        removeCar();
        Main.location[Main.currentPlayer] = 23;
        addCar();
    }
    public static void kort7() {
        GUI_Chance kort7 = new GUI_Chance("CHANCE", "kort 7", "Du har spist for meget slik. BETAL M2 til banken", Color.white, Color.black);
        Main.gui.displayChanceCard(kort7.getDescription());
        System.out.println("Du fik chancekort 7");
        //Træk M2 fra spilleren
        Main.player[Main.currentPlayer].setBalance(Main.player[Main.currentPlayer].getBalance()-2);
    }
    public static void kort8() {
        GUI_Chance kort8 = new GUI_Chance("CHANCE", "kort 8", "Ryk frem til et orange eller grønt felt.", Color.white, Color.black);
        Main.gui.displayChanceCard(kort8.getDescription());
        System.out.println("Du fik chancekort 8");
        //Vælg hvilket felt du ønsker at rykke frem til
        String chosenElement = Main.gui.getUserSelection(
                "Vælg hvilket fælt du ønsker at rykke frem til?",
                "4", "5", "7", "8"
        );
        //Ryk bilen
        removeCar();
        Main.location[Main.currentPlayer] = Integer.parseInt(chosenElement);
        addCar();
    }
    public static void kort9() {
        GUI_Chance kort9 = new GUI_Chance("CHANCE", "kort 9", "Ryk frem til et lyseblåt felt.", Color.white, Color.black);
        Main.gui.displayChanceCard(kort9.getDescription());
        System.out.println("Du fik chancekort 9");
        //Vælg hvilket felt du ønsker at rykke frem til
        String chosenElement = Main.gui.getUserSelection(
                "Vælg hvilket fælt du ønsker at rykke frem til?",
                "16", "17"
        );
        //Ryk bilen
        removeCar();
        Main.location[Main.currentPlayer] = Integer.parseInt(chosenElement);
        addCar();
        
    }
    //Get out of jail free kort
    public static void kort10() {
        GUI_Chance kort10 = new GUI_Chance("CHANCE", "kort 10", "Du løslades uden omkostninger. Behold dette kort, indtil du får brug for det.", Color.white, Color.black);
        Main.gui.displayChanceCard(kort10.getDescription());
        System.out.println("Du fik chancekort 10");
        //Giv spilleren kortet, ved at sætte getOutOfJail til true. Det bruges så når en spiller kommer i fængsel.
        getOutOfJail[Main.currentPlayer] = true;
    }
    /*
    public static void kort11() {
        new GUI_Chance("Title", "subText", "description", Color.white, Color.black);
        System.out.println("Du fik chancekort 11");

    }
    public static void kort12() { //Giv dette kort til katten
        new GUI_Chance("Title", "subText", "description", Color.white, Color.black);
        System.out.println("Du fik chancekort 12");

    }
    public static void kort13() { //Giv dette kort til hunden
        new GUI_Chance("Title", "subText", "description", Color.white, Color.black);
        System.out.println("Du fik chancekort 13");

    }
    public static void kort14() {
        new GUI_Chance("Title", "subText", "description", Color.white, Color.black);
        System.out.println("Du fik chancekort 14");

    }
    public static void kort15() {
        new GUI_Chance("Title", "subText", "description", Color.white, Color.black);
        System.out.println("Du fik chancekort 15");

    }
    public static void kort16() {
        new GUI_Chance("Title", "subText", "description", Color.white, Color.black);
        System.out.println("Du fik chancekort 16");

    }
    public static void kort17() {
        new GUI_Chance("Title", "subText", "description", Color.white, Color.black);
        System.out.println("Du fik chancekort 17");

    }
    public static void kort18() {
        new GUI_Chance("Title", "subText", "description", Color.white, Color.black);
        System.out.println("Du fik chancekort 18");

    }
    public static void kort19() {
        new GUI_Chance("Title", "subText", "description", Color.white, Color.black);
        System.out.println("Du fik chancekort 19");

    }
    public static void kort20() {
        new GUI_Chance("Title", "subText", "description", Color.white, Color.black);
        System.out.println("Du fik chancekort 20");

    }
    public static void kort21() {
        new GUI_Chance("Title", "subText", "description", Color.white, Color.black);
        System.out.println("Du fik chancekort 21");

    }
    public static void kort22() {
        new GUI_Chance("Title", "subText", "description", Color.white, Color.black);
        System.out.println("Du fik chancekort 22");

    }
    public static void kort23() {
        new GUI_Chance("Title", "subText", "description", Color.white, Color.black);
        System.out.println("Du fik chancekort 23");

    }
    public static void kort24() {
        new GUI_Chance("Title", "subText", "description", Color.white, Color.black);
        System.out.println("Du fik chancekort 24");

    }*/


}
