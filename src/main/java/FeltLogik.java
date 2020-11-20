import gui_fields.GUI_Player;

public class FeltLogik {


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
        else if (Felter.gameBoard[a].getSubText().equals("Gratis parkering")){
            feltType="parkering";
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

}
