package cards;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Poker {

    //all suits are the same, no order
    private final String FLUSH = "flush";

    //all suits are the same, order
    private final String STRAIGHT_FLUSH = "straight flush";

    //all suits are the same, and these specific cards //A, K, Q, J, 10
    private final String ROYAL_FLUSH = "royal flush";

    //All four cards of the same rank e.g. 4 5s, 4 queens
    private final String FOUR_OF_A_KIND = "four of a kind";

    //All three cards of the same rank e.g. 3 5s, 3 queens
    private final String THREE_OF_A_KIND = "three of a kind";

    //2 cards with same rank
    private final String ONE_PAIR = "one pair";

    //2 pairs (cards with same rank)
    private final String TWO_PAIR = "two pair";

    //three of a kind with a pair.
    private final String FULL_HOUSE = "full house";

    //high card
    private final String HIGH_CARD = "high card";

    public String findHighestHand(List<Card> cards) {

        if (areSuitsTheSame(cards)) {

            Card highestCard = getHighestCard(cards);
            if (highestCard.getRank() == CardRank.ACE) {
                return ROYAL_FLUSH;
            }
            if (areCardsInOrder(cards)) {
                return STRAIGHT_FLUSH;
            }

            return FLUSH;
        }

        if (isThreeOfAKind(cards)) {
            return THREE_OF_A_KIND;
        }

        if (isFourOfAKind(cards)) {
            return FOUR_OF_A_KIND;
        }

        if (hasOnePair(cards)) {
            return ONE_PAIR;
        }

        if (hasTwoPairs(cards)) {
            return TWO_PAIR;
        }

        if (isThreeOfAKind(cards) && hasOnePair(cards)) {
            return FULL_HOUSE;
        }

        if (isHighCard(cards)) {
            return HIGH_CARD;
        }

        return null;
    }

    private boolean areSuitsTheSame(List<Card> cards) {
        //if we get 1 back, then all suits were equal
        return cards.stream().map(s -> s.getSuit()).distinct().count() <= 1;
    }

    private boolean areCardsInOrder(List<Card> cards) {
        Comparator<Card> cardNumberComparator = Comparator.comparing(c -> c.getRank().getValue());
        //worst time and space complexity, sort the list first
        List<Card> sorted = cards.stream().sorted(cardNumberComparator).collect(Collectors.toList());
        return isInSequence(sorted);


    }

    private boolean isInSequence(List<Card> cards) {
        Integer prev = null;
        boolean sequence = false;
        List<Integer> ranks = cards.stream().map(card -> card.getRank().getValue()).collect(toList());

        for(Integer rank : ranks) {
            if (prev != null && prev + 1 == rank) {
                sequence = true;
            } else {

                if (prev != null) {
                    sequence = false;
                    break;
                }
            }
            prev = rank;
        }
        return sequence;
    }


    private Card getHighestCard(List<Card> cards) {
        Comparator<Card> cardNumberComparator = Comparator.comparing(c -> c.getRank().getValue());
        return cards.stream().sorted(cardNumberComparator).collect(toList()).get(4);
    }

    private boolean isFourOfAKind(List<Card> cards) {
//        long distinctNumbers = cards.stream().map(c -> c.getRank().getValue()).distinct().count();
//        return distinctNumbers == 2;

        Map<Integer, Long> frequencyPerRank = cards.stream()
            .map(c -> c.getRank().getValue())
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        if (frequencyPerRank.size() >= 2 ) {
            return frequencyPerRank.values().stream().anyMatch(count -> count == 4);
        }

        return false;
    }

    private boolean isThreeOfAKind(List<Card> cards){
        //only 2 different numbers must exist in this set for it to be 3 of a kind
//        long distinctNumbers = cards.stream().map(c -> c.getRank().getValue()).distinct().count();
//        return distinctNumbers == 3;

        Map<Integer, Long> frequencyPerRank = cards.stream()
            .map(c -> c.getRank().getValue())
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        if (frequencyPerRank.size() >= 3 ) {
            return frequencyPerRank.values().stream().anyMatch(count -> count == 3);
        }

        return false;
    }

    private boolean hasOnePair(List<Card> cards){
        long distinctNumbers = cards.stream().map(c -> c.getRank().getValue()).distinct().count();
        return distinctNumbers == 4;
    }

    private boolean hasTwoPairs(List<Card> cards) {
        Map<Integer, Long> frequencyPerRank = cards.stream()
            .map(c -> c.getRank().getValue())
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        if (frequencyPerRank.size() >= 2) {
            int numberOfTimeTwoOccurs = Collections.frequency(frequencyPerRank.values(), 2L);
            return numberOfTimeTwoOccurs == 2;
        }

        return false;
    }

    private List<Card> sortByRank(List<Card> cards) {
        Comparator<Card> cardNumberComparator = Comparator.comparing(c -> c.getRank().getValue());
        return cards.stream().sorted(cardNumberComparator).collect(toList());
    }

    private boolean isHighCard(List<Card> cards) {
        long distinctNumbers = cards.stream().map(c -> c.getRank().getValue()).distinct().count();
        return distinctNumbers == 5;
    }
}
