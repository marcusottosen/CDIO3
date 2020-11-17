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
}
