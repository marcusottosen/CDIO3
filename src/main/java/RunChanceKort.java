import gui_fields.GUI_Chance;

import java.awt.*; //Import af farverne

public class RunChanceKort{

    //private static int[] location = Main.location;
    //private static GUI_Player[] player = Main.player;
    //private static int currentPlayer = Main.currentPlayer;

    private static void removeCar() {
        Main.gui.getFields()[Main.location[Main.currentPlayer]].setCar(Main.player[Main.currentPlayer], false);          //Fjerner den tidligere bil
    }
    private static void addCar() {
        Main.gui.getFields()[Main.location[Main.currentPlayer]].setCar(Main.player[Main.currentPlayer], true);       //Viser bilens nye position
    }


    public static void kort1() {
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
    }
    public static void kort4() {
        new GUI_Chance("Title", "subText", "description", Color.white, Color.black);
        System.out.println("Du fik chancekort 4");

    }
    public static void kort5() {
        new GUI_Chance("Title", "subText", "description", Color.white, Color.black);
        System.out.println("Du fik chancekort 5");

    }
    public static void kort6() {
        new GUI_Chance("Title", "subText", "description", Color.white, Color.black);
        System.out.println("Du fik chancekort 6");

    }
    public static void kort7() {
        new GUI_Chance("Title", "subText", "description", Color.white, Color.black);
        System.out.println("Du fik chancekort 7");

    }
    public static void kort8() {
        new GUI_Chance("Title", "subText", "description", Color.white, Color.black);
        System.out.println("Du fik chancekort 8");

    }
    public static void kort9() {
        new GUI_Chance("Title", "subText", "description", Color.white, Color.black);
        System.out.println("Du fik chancekort 9");

    }
    public static void kort10() {
        new GUI_Chance("Title", "subText", "description", Color.white, Color.black);
        System.out.println("Du fik chancekort 10");

    }
    public static void kort11() {
        new GUI_Chance("Title", "subText", "description", Color.white, Color.black);
        System.out.println("Du fik chancekort 11");

    }
    public static void kort12() {
        new GUI_Chance("Title", "subText", "description", Color.white, Color.black);
        System.out.println("Du fik chancekort 12");

    }
    public static void kort13() {
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
