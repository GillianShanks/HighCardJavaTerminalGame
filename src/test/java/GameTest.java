import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class GameTest {

    Player player1;
    Player player2;
    Player player3;
    Player player4;



    Game game;

    @Before
    public void before(){
        player1 = new Player("Ally");
        player2 = new Player("Lindsey");

        ArrayList<Player> players = new ArrayList<Player>();
        players.add(player1);
        players.add(player2);

        game = new Game (players);
    }

    @Test
    public void gameHasTwoPlayers(){
        assertEquals(2, game.playersCount());
    }

    @Test
    public void gameDealsCardToPlayers(){
        //Given there is a game
        assertNotNull(game);
        //When the game deals
        game.deal();
        //Then the deck has only 50 cards
        assertEquals(50, game.getDeck().fullDeckSize());
        //AND player1 has 1 card
        assertNotNull(player1.getPlayerHand());
        //AND player2 has 1 card
        assertNotNull(player2.getPlayerHand());

    }

    @Test
    public void gameChoosesWinner__ifWinner(){
        //Given there is a game
        assertNotNull(game);
        //AND the game is dealt
        game.deal();
        //When I check cards
        game.checkForWinner();
        //Then the winner is chosen
        assertNotNull(game.getWinner());
    }

    @Test
    public void gameChoosesWinner_ifMultiplePeople(){
        //Given there is a game
        player3 = new Player("Kyle");
        player4 = new Player("Gillian");

        ArrayList<Player> players = new ArrayList<Player>();
        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);


        Game multiplayerGame = new Game (players);
        //AND
    }

}
