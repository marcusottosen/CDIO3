import gui_main.GUI;


public class Spiller {
    public static String[] spillerNavne; //Array af spillernes navne
    public static int antalSpillere;

    /**
     * Spørger spillerne om hvis mange spillere de har tænkt sig at være. Mellem 2 og 4.
     * @param gui   Importeret igennem gui_main.GUI. Bruges til at fremvise en dropdown menu i GUIen.
     * @return      returnerer en int svarende til den String som brugeren valgte.
     */
    public static int antalSpillere(GUI gui) {
        String antalSpillerInput = gui.getUserSelection(
                "Vælg antal spillere",
                "2", "3", "4"
        );
        antalSpillere = Integer.parseInt(antalSpillerInput);      // Laver string input om til int
        return antalSpillere;
    }

    /**
     * Bruges til at finde spilleren startbalance da spillerne skal have forskellige startbalance alt efter hvor mange de er.
     * @return  returnerer spillernes startbalance i form at en int.
     */
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
        return balance;
    }

    /**
     * Finder spillernes navne og sætter dem ind i arrayet spillerNavne.
     * Tjekker også om nogle af navnene er de samme og om der er kommet et indput
     * @param gui   Importeret igennem gui_main.GUI. Bruges til at få et tekst-input fra brugeren igennem GUIen.
     * @return      returnerer et array af alle spillernes navne. Arrayets index svarer til arrayet af Player i Main.
     */
    public static String[] setNames(GUI gui) {
        spillerNavne = new String[antalSpillere];      //Sætter arrayet til antallet af spillere

        //Hvis dette for loop ikke var her, ville der komme errors ved tjek om navnene er ens
        for (int i = 0; i < antalSpillere; i++) {
            spillerNavne[i]="";
        }
        String navnInput="";

        for (int i = 0; i < antalSpillere; i++) {
            navnInput = gui.getUserString("Indtast navnet på spiller " + (i + 1));
            for (int j = 0; j < antalSpillere; j++) {

                if(navnInput.equals("")){
                    navnInput = gui.getUserString("Indtast venligst et navn");
                }

                //Tjekker om to navne er ens
                else if (spillerNavne[j].equals(navnInput)){
                    navnInput = gui.getUserString("Du kan ikke have det samme navn som en anden spiller!" + "\"+" +
                            "Indtast et nyt navn");
                }
            }
            spillerNavne[i] = navnInput;
        }
        return spillerNavne;
    }
}

