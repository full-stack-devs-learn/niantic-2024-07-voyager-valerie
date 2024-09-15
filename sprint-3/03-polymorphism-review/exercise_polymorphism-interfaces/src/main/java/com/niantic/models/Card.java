package com.niantic.models;

import java.util.HashMap;
import java.util.Map;

public class Card implements Comparable<Card>
{
    private String suit;
    private String faceValue;

    public Card(String suit, String faceValue)
    {
        this.suit = suit;
        this.faceValue = faceValue;
    }

    public String getSuit()
    {
        return suit;
    }

    public String getFaceValue()
    {
        return faceValue;
    }

    public int getPointValue()
    {
        return cardValues.get(faceValue);
    }

    public String getColor()
    {
        switch (suit.toLowerCase())
        {
            case "hearts":
            case "diamonds":
                return "Red";
            default:
                return "Black";
        }
    }

    // lookup map, value of the cards in the game
    private static final Map<String, Integer> cardValues = new HashMap<>()
    {{
        put("A", 11);
        put("K", 10);
        put("Q", 10);
        put("J", 10);
        put("10", 10);
        put("9", 9);
        put("8", 8);
        put("7", 7);
        put("6", 6);
        put("5", 5);
        put("4", 4);
        put("3", 3);
        put("2", 2);
    }};

    // how to prioritize the suits
    private static final Map<String, Integer> suitValues = new HashMap<>() {{
        put("spades", 1);
        put("hearts", 2);
        put("diamonds", 3);
        put("clubs", 4);
    }};

    // how to prioritize the cards within a suit (ie. k, q, j, 10 all share the same card value, but k >q > j > 10)
    public static final Map<String, Integer> faceOrder = new HashMap<>() {{
        put("A", 1);
        put("K", 2);
        put("Q", 3);
        put("J", 4);
        put("10", 5);
        put("9", 6);
        put("8", 7);
        put("7", 8);
        put("6", 9);
        put("5", 10);
        put("4", 11);
        put("3", 12);
        put("2", 13);
    }};

    @Override
    public int compareTo(Card o)
    {
        String currentCardSuit = this.suit.toLowerCase();
        String otherCardSuit = o.suit.toLowerCase();

        // compares suits
        int suitComparison = Integer.compare(
                suitValues.get(currentCardSuit),
                suitValues.get(otherCardSuit)
        );

        // when the suit is the same, compare the face values
        if(suitComparison == 0)
        {
            return compareFaceCardValues(this.faceValue, o.faceValue);
        }

        return suitComparison;
    }

    // ensures k > q > j > 10
    private int compareFaceCardValues(String currentCard, String otherCard)
    {
        int currentCardValue = faceOrder.get(currentCard);
        int otherCardValue  = faceOrder.get(otherCard);

        return Integer.compare(otherCardValue, currentCardValue);
    }
}
