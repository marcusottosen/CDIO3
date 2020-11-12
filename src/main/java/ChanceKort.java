public class ChanceKort {
    private final int MAX = 24; //Maksimum antal kort.

    private int pickedChanceKort; //Det valgte chancekort


    public ChanceKort() {
        pickedChanceKort = 1;
        }

    public int randomChanceKort(){
        pickedChanceKort = (int)(Math.random()*MAX)+1;

        return pickedChanceKort;
    }

        //Her opretter vi en switch statement for at gå igennem alle 24 kort.
    //Vi får samtidig variablen "pickedChanceKort" til at give et tilfældigt tal
    public void pickChanceKort() {
        switch (pickedChanceKort) {
            case 1:
                RunChanceKort.kort1();
                break;
            case 2:
                RunChanceKort.kort2();
                break;
            case 3:
                RunChanceKort.kort3();
                break;
            case 4:
                RunChanceKort.kort4();
                break;
            case 5:
                RunChanceKort.kort5();
                break;
            case 6:
                RunChanceKort.kort6();
                break;
            case 7:
                RunChanceKort.kort7();
                break;
            case 8:
                RunChanceKort.kort8();
                break;
            case 9:
                RunChanceKort.kort9();
                break;
            case 10:
                RunChanceKort.kort10();
                break;
            case 11:
                RunChanceKort.kort11();
                break;
            case 12:
                RunChanceKort.kort12();
                break;
            case 13:
                RunChanceKort.kort13();
                break;
            case 14:
                RunChanceKort.kort14();
                break;
            case 15:
                RunChanceKort.kort15();
                break;
            case 16:
                RunChanceKort.kort16();
                break;
            case 17:
                RunChanceKort.kort17();
                break;
            case 18:
                RunChanceKort.kort18();
                break;
            case 19:
                RunChanceKort.kort19();
                break;
            case 20:
                RunChanceKort.kort20();
                break;
            case 21:
                RunChanceKort.kort21();
                break;
            case 22:
                RunChanceKort.kort22();
                break;
            case 23:
                RunChanceKort.kort23();
                break;
            case 24:
                RunChanceKort.kort24();
                break;

            default:
                System.out.println("Chancekortet eksiterer ikke");
                break;
        }
    }
}
