/*
 * PC ID: 110202
 * UVa ID: 10315
 * Name: Poker Hands
 */

/**
 * @author Prabu
 * Date: 10-Apr-2011
 */

import java.io.*;
import java.util.*;
//import java.util.EnumMap.*;

public class PC110202_PokerHands {
    @SuppressWarnings("CallToThreadDumpStack")
    public static void main(String[] args) {
        try {
            PC110202_PokerHands solver = new PC110202_PokerHands();
            solver.openIO();
            solver.solve();
            solver.closeIO();
        }
        catch(Exception e) {
            System.out.println("Failed: " + e);
            e.printStackTrace();
        }
    }

    final static String FILENAME = "PC110202_PokerHands";
    private static Scanner sc;
    private static PrintWriter out;

    void openIO() throws IOException {
        String inFileName = "IO/Input/" + FILENAME + ".IN";
        String outFileName = "IO/Output/" + FILENAME + ".OUT";

        sc = new Scanner(new File(inFileName));
        out = new PrintWriter(new File(outFileName));
    }

    void closeIO() throws IOException {
        out.close();
        sc.close();
    }

/******************************************************************************/
    void solve() throws IOException {
        while(sc.hasNextLine()) {
            String[] cards = sc.nextLine().split(" ");
            PokerHand black = new PokerHand(cards, 0);
            PokerHand white = new PokerHand(cards, 5);

            int compare = black.compareTo(white);
            if(compare > 0)
                out.println("Black wins.");
            else if(compare < 0)
                out.println("White wins.");
            else
                out.println("Tie.");
            //System.out.println("\n\n");
        }
    }
/******************************************************************************/
}

class PokerHand implements Comparable<PokerHand> {
    public static final int CAT_HIGH_CARD = 1;
    public static final int CAT_PAIR = 2;
    public static final int CAT_TWO_PAIRS = 3;
    public static final int CAT_THREE_OF_A_KIND = 4;
    public static final int CAT_STRAIGHT = 5;
    public static final int CAT_FLUSH = 6;
    public static final int CAT_FULL_HOUSE = 7;
    public static final int CAT_FOUR_OF_A_KIND = 8;
    public static final int CAT_STRAIGHT_FLUSH = 9;

    private static final int CARD_COUNT = 5;

    private Card[] cards = new Card[CARD_COUNT];
    private int category;
    private int rank;
    private boolean isSameSuit = false;
    private boolean isConsecutive = false;
    private TreeMap<Integer, Integer> cardsCount;

    public PokerHand(String[] cardslist, int startIdx) {
        cardsCount = new TreeMap<Integer, Integer>();
        for(int i = startIdx + CARD_COUNT - 1, j = 0; i >= startIdx; i--, j++) {
            cards[j] = new Card(cardslist[i]);

            Integer count = cardsCount.get(cards[j].getIntValue());
            if(count == null) {
                cardsCount.put(cards[j].getIntValue(), 1);
            }
            else {
                cardsCount.put(cards[j].getIntValue(), count + 1);
            }
            //System.out.println(cardsCount);
            //System.out.print(cards[j].toString() + " " + cards[j].getIntValue() + " " + cards[j].getCardRank() + "  ");
        }
        //System.out.println();

        Arrays.sort(cards);
        //System.out.println("card: " + Arrays.toString(cards));
        defineCategoryAndRank();
    }

    public PokerHand(String[] cardslist) {
        this(cardslist, 0);
    }

    public int getCategory() {
        return category;
    }

    public int getRank() {
        return rank;
    }

    public int compareTo(PokerHand o) {
        //System.out.println("Blact - " + this.category + "," + this.rank);
        //System.out.println("white - " + o.category + "," + o.rank);
        if(this.category != o.category)
            return this.category - o.category;
        if(this.rank != o.rank)
            return this.rank - o.rank;

        // if category is same
        switch(this.category) {
            case CAT_STRAIGHT_FLUSH:
            case CAT_FOUR_OF_A_KIND:
            case CAT_FULL_HOUSE:
            case CAT_STRAIGHT:
            case CAT_THREE_OF_A_KIND:
                return 0;
            case CAT_FLUSH:
            case CAT_HIGH_CARD:
                for(int i = CARD_COUNT - 1; i >= 0; i--) {
                    if(this.cards[i].getIntValue() != o.cards[i].getIntValue())
                        return this.cards[i].getIntValue() - o.cards[i].getIntValue();
                }
                return 0; //If all equals (tie)
            case CAT_TWO_PAIRS:
                if(this.rank != o.rank)
                    return this.rank - o.rank;
                else {
                    int rank1=0, rank2=0, rank3=0, rank4=0;
                    for(Map.Entry<Integer, Integer> entry: this.cardsCount.entrySet()) {
                        if(entry.getValue() == 2 && entry.getKey() != this.rank) {
                            rank1 = entry.getKey();
                        }
                        if(entry.getValue() == 1) {
                            rank3 = entry.getKey();
                        }
                    }
                    for(Map.Entry<Integer, Integer> entry: o.cardsCount.entrySet()) {
                        if(entry.getValue() == 2 && entry.getKey() != o.rank) {
                            rank2 = entry.getKey();
                        }
                        if(entry.getValue() == 1) {
                            rank4 = entry.getKey();
                        }
                    }

                    if(rank1 != rank2)
                        return rank1 - rank2;
                    return rank3 - rank4;
                }
            case CAT_PAIR:
                if(this.rank != o.rank)
                    return this.rank - o.rank;

                for(int i = CARD_COUNT - 1, j = CARD_COUNT - 1; i >= 0; i--, j--) {
                    if(this.cards[i].getIntValue() == this.rank) {
                        i--;j++;
                        continue;
                    }
                    if(this.cards[j].getIntValue() == o.rank) {
                        j--;i++;
                        continue;
                    }

                    if(this.cards[i].getIntValue() != o.cards[j].getIntValue())
                        return this.cards[i].getIntValue() - o.cards[j].getIntValue();
                }
                return 0; //If all equals (tie)
        }

        return 0;
    }

    private void defineCategoryAndRank() {
        int i;

        // Check if all cards are same suit
        isSameSuit = true;
        Card prevCard = cards[0];
        for(i = 1; i < cards.length; i++) {
            if(prevCard.getSuit() != cards[i].getSuit()) {
                isSameSuit = false;
                break;
            }
            prevCard = cards[i];
        }
        //System.out.println("isSameSuit: " + isSameSuit);

        isConsecutive = true;
        prevCard = cards[0];
        for(i = 1; i < cards.length; i++) {
            if(prevCard.getIntValue() + 1 != cards[i].getIntValue()) {
                isConsecutive = false;
                break;
            }
            prevCard = cards[i];
        }
        //System.out.println("isConsecutive: " + isConsecutive);

        // Check if a straight flush
        if(isSameSuit == true && isConsecutive == true) {
            category = CAT_STRAIGHT_FLUSH;
            rank = cards[cards.length - 1].getIntValue(); //get highest card value
            return;
        }

        // Check if a four of a kind
        //System.out.println(cardsCount.entrySet());
        for(Map.Entry<Integer, Integer> entry: cardsCount.entrySet()) {
            if(entry.getValue() == 4) {
                category = CAT_FOUR_OF_A_KIND;
                rank = entry.getKey();
                return;
            }
        }

        // Check if a Full house
        if(cardsCount.size() == 2) {
            for(Map.Entry<Integer, Integer> entry: cardsCount.entrySet()) {
                if(entry.getValue() == 3) {
                    category = CAT_FULL_HOUSE;
                    rank = entry.getKey();
                    return;
                }
            }
        }

        // Check if a flush
        if(isSameSuit == true) {
            category = CAT_FLUSH;
            rank = cards[cards.length - 1].getIntValue(); //get highest card value
            return;
        }

        // Check if a straight
        if(isConsecutive == true) {
            category = CAT_STRAIGHT;
            rank = cards[cards.length - 1].getIntValue(); //get highest card value
            return;
        }

        // Check if a Three of a Kind
        for(Map.Entry<Integer, Integer> entry: cardsCount.entrySet()) {
            if(entry.getValue() == 3) {
                category = CAT_THREE_OF_A_KIND;
                rank = entry.getKey();
                return;
            }
        }

        // Check if a Two pairs
        if(cardsCount.size() == 3) {
            rank = 0;
            category = CAT_TWO_PAIRS;
            for(Map.Entry<Integer, Integer> entry: cardsCount.entrySet()) {
                if(entry.getValue() == 2 && rank < entry.getKey()) {
                    rank = entry.getKey();
                }
            }
            return;
        }

        // Check if a Pair
        if(cardsCount.size() == 4) {
            for(Map.Entry<Integer, Integer> entry: cardsCount.entrySet()) {
                if(entry.getValue() == 2) {
                    category = CAT_PAIR;
                    rank = entry.getKey();
                    return;
                }
            }
        }

        category = CAT_HIGH_CARD;
        rank = cards[cards.length - 1].getIntValue(); //get highest card value
    }
}

class Card implements Comparable<Card> {
    private static final String values = "23456789TJQKA";
    private static final String suits = "CDHS";
    public static final int NUMBER_OF_CARDS = 52;
    public static final int NUMBER_OF_SUITS = 4;
    public static final int NUMBER_OF_CARDS_IN_SUITS = (NUMBER_OF_CARDS / NUMBER_OF_SUITS);
    
    private char value;
    private char suit;

    public Card(String card) {
        if(card.length() != 2)
            throw new IllegalArgumentException("Card should be two character representation.");
        value = card.charAt(0);
        suit = card.charAt(1);
        //System.out.println(value + "" + suit);
    }

    public char getValue() {
        return value;
    }

    public char getSuit() {
        return suit;
    }

    public int getIntValue() {
        return values.indexOf(value);
    }

    public int compareTo(Card o) {
        // only compare value (we can ignore suits)
        return this.getIntValue() - o.getIntValue();
    }

    @Override
    public String toString() {
        return value + "" + suit;
    }

    int getCardRank() {
        return getCardRank(this.value, this.suit);
    }

    // Static methods
    public static int getCardRank(char value, char suit) {
        for(int i = 0; i < NUMBER_OF_CARDS_IN_SUITS; i++) {
            if(value == values.charAt(i)) {
                for(int j = 0; j < NUMBER_OF_SUITS; j++) {
                    if(suit == suits.charAt(j))
                        return (i * NUMBER_OF_SUITS + j);
                }
            }
        }

        return -1; // for invalid cards
    }

    public static char getSuit(int cardrank) {
        return suits.charAt(cardrank % NUMBER_OF_SUITS);
    }

    public static char getValue(int cardrank) {
        return values.charAt(cardrank / NUMBER_OF_SUITS);
    }
}