import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DeckTest {

    Deck deck1;
    Deck deck2;

    @Before
    public void before(){
        deck1 = new Deck();
        deck2 = new Deck();
    }

    @Test
    public void deckStartEmpty(){
        assertEquals(0, deck1.fullDeckSize());
    }

    @Test
    public void canPopulateDeck(){
        //Given there is a deck
        assertNotNull(deck1);
        //When I populate the deck
        deck1.populate();
        //Then the deck has 52 cards
        assertEquals(52, deck1.fullDeckSize());
    }

    @Test
    public void canShuffleDeck(){
        //Given there are 2 decks
        assertNotNull(deck1);
        //AND both are populated
        deck1.populate();
        deck2.populate();
        //When I shuffle the first deck
        deck1.shuffle();
        //Then the shuffled deck is not the same as non-shuffled deck
        assertNotEquals(deck1.getFullDeck(), deck2.getFullDeck());
    }
}
