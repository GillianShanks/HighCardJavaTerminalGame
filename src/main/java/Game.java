import java.util.ArrayList;

public class Game {

    private ArrayList<Player> players;
    private Deck deck;
    private Player winner;
    private boolean draw;

    public Game(ArrayList<Player> players) {
        this.players = players;
//        players.add(player1);
//        players.add(player2);

        this.deck = new Deck();

        this.winner = null;
        this.draw = true;
    }

    public Deck getDeck() {
        return deck;
    }

    public boolean isDraw() {
        return draw;
    }

    public Player getWinner(){
        return this.winner;
    }

    public int playersCount() {
        return this.players.size();
    }

    public void deal() {
        //populate deck
        //shuffle deck
        //for every player in players
        //remove first card
        // and give to player's hand

        this.deck.populate();
        this.deck.shuffle();
        for (Player player : this.players){
            Card card = this.deck.dealCard();
            player.takeCard(card);
        }
    }

    public void sortPlayersByHand(){

        for (int i = 0; i < this.players.size() - 1; i++) {
            int thisCard = players.get(i).getPlayerHand().getRank().getValue();

            int nextCard = players.get(i+1).getPlayerHand().getRank().getValue();

            if (thisCard > nextCard){
                Player tempPlayer = this.players.get(i+1);
                this.players.set(i+1, this.players.get(i));
                this.players.set(i, tempPlayer);
            }
        }
    }

    public void checkForWinner(){
        this.sortPlayersByHand();
        this.sortPlayersByHand();
//        for(Player players : this.players){
//            System.out.println(players.getName());
//        }

        int lastIndex = this.players.size()-1;
        int secondLastIndex = this.players.size()-2;

        if (this.players.get(lastIndex).getPlayerHand().getRank().getValue() == this.players.get(secondLastIndex).getPlayerHand().getRank().getValue()){
            this.draw = true;
        } else {
            this.draw = false;
            this.winner = this.players.get(lastIndex);
        }
    }

//    public void checkForWinner() {
        //set the highestCard as the first player's card value
        //for each player get the value of their hand

//        int highestCard = this.players.get(0).getPlayerHand().getRank().getValue();
//        Player winner = this.players.get(0);
//        boolean draw = true;

//        for (Player player : this.players) {
//            //TODO: add functionality for a draw
//
//            if(player.getPlayerHand().getRank().getValue() == highestCard){
//                draw = true;
//            } else if (player.getPlayerHand().getRank().getValue() > highestCard){
//                draw = false;
//                highestCard = player.getPlayerHand().getRank().getValue();
//                winner = player;
//            } else if (this.players.size() == 2){
//                draw = false;
//            }
//
//        }

//        this.draw = draw;
//        this.winner = winner;


//    }
}
