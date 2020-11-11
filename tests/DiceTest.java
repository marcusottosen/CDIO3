import static org.junit.jupiter.api.Assertions.*;

public class DiceTest {
    public static void main(String[] args) {

    }

    /** Test af JUnit for at teste at det er sat korrekt op.
     * Her testes der blot om der er en konstruktør i Dice klassen */
    @org.junit.Test
    public void constructorExists() {
        Dice d1 = new Dice();
        assertEquals(Dice.class, d1.getClass());
    }

    @org.junit.Test
    public void diceIsRandom() {
        int diceRoll;
        int diceCount = 0;

        Dice d1 = new Dice();

        for (int i = 0; i < 100000; i++) {
            diceRoll = d1.roll();
            //Det antages at med 1 terning vil vi ca. få hvert slag 16.666 gange ud af
            //de 100.000 slag.
            if(diceRoll == 1) {
                diceCount++;
            }
        }

        //Vi tester om terningen slår 1. 16.666 gange, med 1% afvigelse
        if (diceCount < 16500 || diceCount > 16832) {
            fail("Terningen er ikke tilfældig, da den slog 1. færre eller flere gange end forventet");
        }
    }
}