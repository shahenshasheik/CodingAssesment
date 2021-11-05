import java.util.Random;

public class CardDeck {
    private Random r;
    private int lowerBound = 1;
    private int upperBound = 52;
    CardDeck(){
    }
    void Shuffle(){
        r = new Random();
    }
    public int GetCard(){
        //int result = r.nextInt(upperBound-lowerBound) + lowerBound;
        return r.nextInt(upperBound-lowerBound) + lowerBound;
    }
}
