import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private ArrayList<Card> fullDeck;

    public Deck(){
        fullDeck = new ArrayList<Card>();
    }

    public int fullDeckSize() {
        return fullDeck.size();
    }

    public void populate() {
        SuitType[] allSuits = SuitType.values();
        RankType[] allRanks = RankType.values();

        for (SuitType suit : allSuits){
            for (RankType rank : allRanks){
                Card newCard = new Card(suit, rank);
                fullDeck.add(newCard);
            }
        }

    }

    public ArrayList<Card> getFullDeck() {
        return fullDeck;
    }


    public void shuffle() {
        Collections.shuffle(this.fullDeck);
    }

    public Card dealCard() {
        return this.fullDeck.remove(0);
    }
}
