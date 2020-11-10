//Dice koden er taget fra CDIO1 opgaven.

public class dice
{
    private final int MAX = Logik.terningStr; //Maximum værdi

    private int faceValue; //nuværende værdi

    //Konstruktør
    public dice()
    {
        faceValue = 1;
    }
    //kaster terning
    public int roll()
    {
        faceValue =(int)(Math.random()*MAX)+1;

        return faceValue;
    }

    //mutator
    public void setFaceValue(int value)
    {
        faceValue = value;
    }

    //hent værdi
    public int getFaceValue()
    {
        return faceValue;
    }
}
