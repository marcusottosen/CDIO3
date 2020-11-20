import gui_fields.GUI_Player;
import gui_main.GUI;


public class FeltLogik extends Main{



    //Finder vejens type vha. feltets subText
    public static String feltType(int a){
        String feltType ="";
        if ((Felter.gameBoard[a].getSubText().equals("1"))  ||
                (Felter.gameBoard[a].getSubText().equals("2")) ||
                (Felter.gameBoard[a].getSubText().equals("3")) ||
                (Felter.gameBoard[a].getSubText().equals("4"))){
            feltType="street";
        }
        else if (Felter.gameBoard[a].getSubText().equals("Fængsel")){
            feltType="jail";
        }
        else if (Felter.gameBoard[a].getSubText().equals("Parkering")){
            feltType="parkering";
        }
        else if (Felter.gameBoard[a].getTitle().equals("?")){
            feltType="chancekort";
        }
        else if (Felter.gameBoard[a].getSubText().equals("Gå i fængsel")){
            feltType="goToJail";
        } else{
            System.out.println("error - System kunne ikke finde feltets type!");
        }
        return feltType;
    }

    //Tjekker om vejen allerede er ejet af en anden spiller eller ej
    // hvis vej er ejet retuner true.
    public static boolean isOwned(GUI_Player[] player, String ownerName){
        boolean owned = false;
        outer: for (int j = 0; j < player.length; j++) {
               if (ownerName == player[j].getName()) {
                owned = true;
                break outer;
            } else if (ownerName != player[j].getName()) {
                owned = false;
            }
            else {
                System.out.println("Error - System kunne ikke finde ejeren af feltet!");
            }
        }
        if (owned)
            return true;
        else
            return false;
    }

    public static int ownerNumber(GUI_Player[] player, String ownerName){
        int nr=0;
        outer: for (int i = 0; i < player.length; i++) {
            if (player[i].getName().equals(ownerName)){
                nr = player[i].getNumber();
                break outer;
            }
        }
        return nr;
    }


    //Flytter spilleren på boarded og giver 2 penge over start
    public static void movePlayer(int i, int[] location, GUI_Player[] player, GUI gui) {
        gui.getFields()[location[i]].setCar(player[i], false);               //Fjerner den tidligere bil
        location[i] = location[i] + Main.dice;                                           //Spillerens lokation + terningens værdi

        if (location[i] <= 23) {}                                                   // Gør det muligt for bilen at køre pladen rundt
        else if (location[i]==23){
            location[i]=0;
            player[i].setBalance(player[i].getBalance()+2);                         //Giver 2 penge over start
        }
        else{
            location[i] = location[i]-24;
            player[i].setBalance(player[i].getBalance()+2);                         //Giver 2 penge over start
        }
        gui.getFields()[location[i]].setCar(player[i], true);               //Viser bilens nye position
    }

    public static void jail(GUI gui, int[] locations, GUI_Player[] player, int i){
        gui.showMessage("Du er blevet rykket til fængslet! Åhh nej!" + "\n" +
                "Så bliver du nødt til at vente en hel tur... Ved mindre du har det rette chancekort");

        gui.getFields()[location[i]].setCar(player[i], false);
        location[i] = 6;
        gui.getFields()[location[i]].setCar(player[i], true);

        isJailed[i]=true;

    }


}
