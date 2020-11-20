import gui_fields.GUI_Ownable;
import gui_fields.GUI_Player;
import gui_main.GUI;
import gui_fields.*;


public class Logik extends Main {

    public static String findTaber(GUI_Player[] player){
        int nr = 0;
        outer: for (int i = 0; i < player.length; i++) {
            if (player[i].getBalance()<=0){
                nr=i;
                break outer;
            }
        }
        return player[nr].getName();
    }

    public static String findVinner(GUI_Player[] player) {
        int max = 0;
        int nr = 0;
        for (int i = 0; i < player.length; i++) {
            if (player[i].getBalance() > max) {
                max = player[i].getBalance();
            }
        }
        for (int i = 0; i < player.length; i++) {
            if (player[i].getBalance() == max)
                nr = i;
        }

        return player[nr].getName();
    }

    public static int spillerBalance(){
        int balance=0;
        if (antalSpillere==2){
            balance = 20;
        }
        if (antalSpillere==3){
            balance = 18;
        }
        if (antalSpillere==4){
            balance = 16;
        }

        return 10;
    }


    public static void p2pBetaling(int i, GUI_Player[] player, GUI gui, int feltPris, GUI_Ownable ownable){
        player[i].setBalance(player[i].getBalance()-feltPris);  //trækker penge fra spillere
        player[FeltLogik.ownerNumber(player, ownable.getOwnerName())]   //Tilføjer penge til ejeren af feltet
                .setBalance(player[FeltLogik.ownerNumber(player, ownable.getOwnerName() )].getBalance()+feltPris);
    }

    public static void buyFelt(int i, GUI_Street street, GUI_Ownable ownable, int feltpris){
        street.setHouses(1);
        ownable.setOwnerName(Spiller.spillerNavne[i]);
        ownable.setBorder(player[i].getPrimaryColor());
        player[i].setBalance(player[i].getBalance() - feltpris);
    }



}
