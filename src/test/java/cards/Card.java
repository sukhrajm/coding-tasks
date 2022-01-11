package cards;

public class Card {

    private final CardRank rank;
    private final String suit;

    public Card(CardRank rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public CardRank getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }
}
