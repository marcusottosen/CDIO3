import gui_fields.GUI_Ownable;
import gui_fields.GUI_Player;
import gui_fields.GUI_Street;


public class Logik extends Main {

    /**
     * Finder ud af hvem der har tabt spillet, ved at tjekke alle spillerne om de har mindre end eller lig med 0 på sin balance.
     * @param player    Array af player. Bruges her til at finde den enkelte spillers balance.
     * @return          Returnerer den tabende spillers navn i en String.
     */
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

    /**
     * Finder ud af hvem der har fleste penge, ved at tjekke alle spillerne om deres balance er højere end de andres.
     * @param player    Array af player. Bruges her til at finde den enkelte spillers balance.
     * @return          Returnere den vindende spillers navn i en String.
     */
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

    /**
     * Sørger for betaling mellem spillerne ved at trækkke en som fra en spiller og tilføjer samme antal penge til ejeren af feltet spilleren er landet på.
     * @param i         i henviser til den enkelte spiller i player arrayet.
     * @param player    Array af player. Bruges her til at sætte spillerens balance.
     * @param feltPris  Prisen på feltet angivet som int.
     * @param ownable   Bruges igennem gui_fields.GUI_Ownable for at finde navnet på feltets ejer.
     */
    public static void p2pBetaling(int i, GUI_Player[] player, int feltPris, GUI_Ownable ownable){
        player[i].setBalance(player[i].getBalance()-feltPris);  //trækker penge fra spillere
        player[FeltLogik.ownerNumber(player, ownable.getOwnerName())]   //Tilføjer penge til ejeren af feltet
                .setBalance(player[FeltLogik.ownerNumber(player, ownable.getOwnerName() )].getBalance()+feltPris);
    }

    /**
     * Sørger for køb af det enkelte felt når en spiller lander på et frit felt.
     * @param i         i henviser til den enkelte spiller i player arrayet.
     * @param street    Brugt igennem import af gui_fields.GUI_Street. Bruges til at sætte et visuelt hus på feltet.
     * @param ownable   Bruges igennem gui_fields.GUI_Ownable for at sætte feltets ejer til køberens navn.
     * @param feltpris  Oprettet inde i Main og angivet i Felter. Svarer til prisen på feltet.
     */
    public static void buyFelt(int i, GUI_Street street, GUI_Ownable ownable, int feltpris){
        street.setHouses(1);
        ownable.setOwnerName(Spiller.spillerNavne[i]);
        ownable.setBorder(player[i].getPrimaryColor());
        player[i].setBalance(player[i].getBalance() - feltpris);
    }
}