import gui_fields.GUI_Player;

public class FeltLogik {
    //Tjekker hvorvidt feltet er en vej (købbar)
    public static boolean isStreet(int a){
        if ((Felter.gameBoard[a].getSubText().equals("1"))  ||
                (Felter.gameBoard[a].getSubText().equals("2")) ||
                (Felter.gameBoard[a].getSubText().equals("3")) ||
                (Felter.gameBoard[a].getSubText().equals("4"))){
            return true;
        }
        else return false;
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
}
