import gui_fields.GUI_Chance;

import java.awt.*; //Import af farverne

public class RunChanceKort{
    public static boolean[] getOutOfJail;

    //Oprettet 2 metoder til når en bil skal rykke sig på felterne. Første metode fjerner den gamle bil og den næste metode tilføjer en ny.
    private static void removeCar() {
        Main.gui.getFields()[Main.location[Main.currentPlayer]].setCar(Main.player[Main.currentPlayer], false);          //Fjerner den tidligere bil
    }
    private static void addCar() {
        Main.gui.getFields()[Main.location[Main.currentPlayer]].setCar(Main.player[Main.currentPlayer], true);       //Viser bilens nye position
    }


    public static void kort1() { //Giv skibet til bilen
        new GUI_Chance("Title", "subText", "description", Color.white, Color.black);
        System.out.println("Du fik chancekort 1");
    }
    public static void kort2() {
        new GUI_Chance("Title", "subText", "description", Color.white, Color.black);
        System.out.println("Du fik chancekort 2");
        removeCar();
        Main.location[Main.currentPlayer] = 0;
        Main.player[Main.currentPlayer].setBalance(Main.player[Main.currentPlayer].getBalance()+2);
        addCar();
    }
    public static void kort3() {
        new GUI_Chance("Title", "subText", "description", Color.white, Color.black);
        System.out.println("Du fik chancekort 3");
        String chosenElement = Main.gui.getUserSelection(
                "Vælg hvor mange felter du ønsker at rykke",
                "1", "2", "3", "4", "5"
        );
        removeCar();
        Main.location[Main.currentPlayer] = Main.location[Main.currentPlayer] + Integer.parseInt(chosenElement);
        addCar();
    }
    public static void kort4() {
        new GUI_Chance("Title", "subText", "description", Color.white, Color.black);
        System.out.println("Du fik chancekort 4");
        String chosenElement = Main.gui.getUserSelection(
                "Hvilket felt ønsker du at rykke frem til?",
                "4", "5"
        );
        removeCar();
        Main.location[Main.currentPlayer] = Integer.parseInt(chosenElement);
        addCar();
    }
    public static void kort5() {
        new GUI_Chance("Title", "subText", "description", Color.white, Color.black);
        System.out.println("Du fik chancekort 5");
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
    public static void kort6() { //Giv dette kort til skibet
        new GUI_Chance("Title", "subText", "description", Color.white, Color.black);
        System.out.println("Du fik chancekort 6");

    }
    public static void kort7() {
        new GUI_Chance("Title", "subText", "description", Color.white, Color.black);
        System.out.println("Du fik chancekort 7");
        Main.player[Main.currentPlayer].setBalance(Main.player[Main.currentPlayer].getBalance()-2);
    }
    public static void kort8() {
        GUI_Chance kort8 = new GUI_Chance("Title", "subText", "Dette er chancekort 8 yeeehaaaw", Color.white, Color.black);
        Main.gui.displayChanceCard(kort8.getDescription());
        System.out.println("Du fik chancekort 8");
        String chosenElement = Main.gui.getUserSelection(
                "Vælg hvilket fælt du ønsker at rykke frem til?",
                "4", "5", "7", "8"
        );
        removeCar();
        Main.location[Main.currentPlayer] = Integer.parseInt(chosenElement);
        addCar();
    }
    public static void kort9() {
        new GUI_Chance("Title", "subText", "description", Color.white, Color.black);
        System.out.println("Du fik chancekort 9");
        String chosenElement = Main.gui.getUserSelection(
                "Vælg hvilket fælt du ønsker at rykke frem til?",
                "16", "17"
        );
        removeCar();
        Main.location[Main.currentPlayer] = Integer.parseInt(chosenElement);
        addCar();
        
    }
    public static void kort10() {
        new GUI_Chance("Title", "subText", "description", Color.white, Color.black);
        System.out.println("Du fik chancekort 10");
        getOutOfJail = new boolean[Main.currentPlayer];
        getOutOfJail[Main.currentPlayer] = true;


    }
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

    }


}
