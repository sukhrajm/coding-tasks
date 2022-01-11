package cards;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Produce a system that accepts a set of cards and identifies the highest ranked poker hand it can make
 * The set will be 5 cards
 * The cards are valued in the order:
 * 2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King, Ace.
 * Jack 11
 * Queen 12
 * King 13
 * Ace 14
 */
public class RankTest {

    Poker poker = new Poker();

    @Test
    public void testIsFlush() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(CardRank.FIVE, "heart"));
        cards.add(new Card(CardRank.NINE, "heart"));
        cards.add(new Card(CardRank.KING, "heart"));
        cards.add(new Card(CardRank.SIX, "heart"));
        cards.add(new Card(CardRank.TWO, "heart"));

        String result = poker.findHighestHand(cards);
        assertEquals("flush", result);
    }

    @Test
    public void testIsStraightFlush() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(CardRank.SIX, "heart"));
        cards.add(new Card(CardRank.FIVE, "heart"));
        cards.add(new Card(CardRank.SEVEN, "heart"));
        cards.add(new Card(CardRank.NINE, "heart"));
        cards.add(new Card(CardRank.EIGHT, "heart"));

        String result = poker.findHighestHand(cards);
        assertEquals("straight flush", result);
    }

    @Test
    public void testRoyalFlush() {
        //A, K, Q, J, 10
        List<Card> cards = new ArrayList<>();

        cards.add(new Card(CardRank.TEN, "heart"));
        cards.add(new Card(CardRank.KING, "heart"));
        cards.add(new Card(CardRank.JACK, "heart"));
        cards.add(new Card(CardRank.ACE, "heart"));
        cards.add(new Card(CardRank.QUEEN, "heart"));

        String result = poker.findHighestHand(cards);
        assertEquals("royal flush", result);
    }

    @Test
    public void testFourOfAKind() {
        //A, K, Q, J, 10
        List<Card> cards = new ArrayList<>();

        cards.add(new Card(CardRank.TEN, "heart"));
        cards.add(new Card(CardRank.TEN, "diamonds"));
        cards.add(new Card(CardRank.TEN, "clubs"));
        cards.add(new Card(CardRank.TEN, "spades"));
        cards.add(new Card(CardRank.TWO, "heart"));

        String result = poker.findHighestHand(cards);
        assertEquals("four of a kind", result);
    }

    @Test
    public void testThreeOfAKind() {
        //A, K, Q, J, 10
        List<Card> cards = new ArrayList<>();

        cards.add(new Card(CardRank.TEN, "heart"));
        cards.add(new Card(CardRank.TEN, "diamonds"));
        cards.add(new Card(CardRank.TEN, "clubs"));
        cards.add(new Card(CardRank.SEVEN, "spades"));
        cards.add(new Card(CardRank.TWO, "heart"));

        String result = poker.findHighestHand(cards);
        assertEquals("three of a kind", result);
    }

    @Test
    public void testIsOnePair() {
        //A, K, Q, J, 10
        List<Card> cards = new ArrayList<>();

        cards.add(new Card(CardRank.TEN, "heart"));
        cards.add(new Card(CardRank.TEN, "diamonds"));
        cards.add(new Card(CardRank.THREE, "heart"));
        cards.add(new Card(CardRank.SEVEN, "spades"));
        cards.add(new Card(CardRank.TWO, "heart"));

        String result = poker.findHighestHand(cards);
        assertEquals("one pair", result);
    }

    @Test
    public void testIsTwoPairs() {
        List<Card> cards = new ArrayList<>();

        cards.add(new Card(CardRank.TEN, "heart"));
        cards.add(new Card(CardRank.TEN, "diamonds"));
        cards.add(new Card(CardRank.NINE, "heart"));
        cards.add(new Card(CardRank.NINE, "spades"));
        cards.add(new Card(CardRank.TWO, "heart"));

        String result = poker.findHighestHand(cards);
        assertEquals("two pair", result);
    }

    @Test
    public void testFullHouse() {
        //Three of a kind with a pair.
        List<Card> cards = new ArrayList<>();

        cards.add(new Card(CardRank.TEN, "heart"));
        cards.add(new Card(CardRank.TEN, "diamonds"));
        cards.add(new Card(CardRank.NINE, "heart"));
        cards.add(new Card(CardRank.NINE, "spades"));
        cards.add(new Card(CardRank.NINE, "heart"));

        String result = poker.findHighestHand(cards);
        assertEquals("full house", result);

    }

    @Test
    public void testStraight() {
        //sequenced numbers
        List<Card> cards = new ArrayList<>();

        cards.add(new Card(CardRank.FIVE, "heart"));
        cards.add(new Card(CardRank.SIX, "diamonds"));
        cards.add(new Card(CardRank.SEVEN, "spades"));
        cards.add(new Card(CardRank.EIGHT, "clubs"));
        cards.add(new Card(CardRank.NINE, "heart"));

        String result = poker.findHighestHand(cards);
        assertEquals("straight", result);
    }

    @Test
    public void testIsHighCard() {
        List<Card> cards = new ArrayList<>();

        cards.add(new Card(CardRank.TEN, "heart"));
        cards.add(new Card(CardRank.TWO, "diamonds"));
        cards.add(new Card(CardRank.EIGHT, "spades"));
        cards.add(new Card(CardRank.FIVE, "spades"));
        cards.add(new Card(CardRank.JACK, "clubs"));

        String result = poker.findHighestHand(cards);
        assertEquals("high card", result);
    }

}


