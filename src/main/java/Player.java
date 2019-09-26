public class Player {

    private String name;
    private Card playerHand;

    public Player(String name) {

        this.name = name;
        this.playerHand = null;
    }

    public String getName() {
        return name;
    }

    public Card getPlayerHand() {
        return playerHand;
    }

    public void takeCard(Card card) {
        this.playerHand = card;
    }
}
