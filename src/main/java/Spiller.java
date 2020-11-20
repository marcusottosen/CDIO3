import gui_main.GUI;



public class Spiller {

    public static String[] spillerNavne;                       //Array af spillernes navne
    public static int antalSpillere;


    //Finder antal spillere
    public static int antalSpillere(GUI gui) {
        String antalSpillerInput = gui.getUserSelection(
                "Vælg antal spillere",
                "2", "3", "4"
        );
        antalSpillere = Integer.parseInt(antalSpillerInput);      // Laver string input om til int
        return antalSpillere;
    }

    //Finder spillernes navne og sætter dem ind i arrayet spillerNavne.
    //Tjekker også om nogle af navnene er de samme og om der er kommet et indput
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

