
public class Spiller {
    private int konto;

    //Konstruktør
    public spiller() {
        konto = Logik.startKonto;
    }

    public int getkonto() {
        return konto;
    }

    public void setKonto(int a) {
        if (konto + a < 0)
            konto = 0;
        else
            konto = konto + a;
    }
}