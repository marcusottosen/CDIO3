import gui_fields.GUI_Player;

public class Logik extends Main {

    public static int startKonto;

    public static void boardLoop(GUI_Player[] player, int[] location, int i){
        if (location[i] <= 23) {}   // Gør det muligt for bilen at køre pladen rundt
        else if (location[i]==23){
            location[i]=0;
            player[i].setBalance(player[i].getBalance()+2);     //Giver 2 penge over start
        }
        else{
            location[i] = location[i]-24;
            player[i].setBalance(player[i].getBalance()+2);     //Giver 2 penge over start
        }

        //gui.getFields()[location[i]].setCar(player[i], true);       //Viser bilens nye position

    }


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
}
