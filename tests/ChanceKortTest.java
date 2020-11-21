import static org.junit.jupiter.api.Assertions.*;

public class ChanceKortTest {

    @org.junit.Test
    public void ChanceKortIsRandom() {
        int kort;
        int kortCounter = 0;

        ChanceKort kortTest = new ChanceKort();

        for (int i = 0; i < 1000000; i++) {
            kort = kortTest.randomChanceKort();

            //Det antages at ud af 24 kort er chancen for at trække kort 1. = 1/24
            //
            // Hvis vi trækker et kort 1.000.000 gange, bør vi få kort 1.
            // ca. 41.666 gange.
            if (kort == 1) {
                kortCounter++;
            }
        }
        System.out.println(kortCounter);
        //Nu tester vi om vi har trukket kort 1 det forventede antal gange
        //Vi tager hensyn til afvigelser, så vi tester med 1% afvigelse fra det forventede antal
        if (kortCounter < 41250 || kortCounter > 42082){
            fail("Du trak ikke kort 1. det forventede antal gange. Metoden er altså ikke tilfældig");
        }
    }





}