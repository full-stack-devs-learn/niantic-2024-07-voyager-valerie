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

    // lookup map
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

    private static final Map<String, Integer> suitValues = new HashMap<>() {{
        put("spades", 1);
        put("hearts", 2);
        put("diamonds", 3);
        put("clubs", 4);
    }};

    @Override
    public int compareTo(Card o)
    {
        String currentCardSuit = this.suit.toLowerCase();
        String otherCardSuit = o.suit.toLowerCase();

        // prioritizes higher numbers (spade -> heart -> diamond -> club)
        int suitComparison = Integer.compare(
                suitValues.get(currentCardSuit),
                suitValues.get(otherCardSuit)
        );

        // compare card value when suit is the same
        if(suitComparison == 0)
        {
            int currentValue = this.getPointValue();
            int otherValue = o.getPointValue();

            return Integer.compare(currentValue, otherValue);
        }
        // todo: Exercise 1: implement Comparable<Card>
        return suitComparison;
    }


    // not working. 10, j, q ,k evaluated the same rn
    private int compareFaceCardValues(String currentFaceCardValue, String otherFaceCardValue) {
        final String[] faceOrder = {"10", "j", "q", "k", "a"};

        int prioritized = java.util.Arrays.asList(faceOrder).indexOf(currentFaceCardValue);
        int deprioritized = java.util.Arrays.asList(faceOrder).indexOf(otherFaceCardValue);

        // sorts in descending order
        return Integer.compare(deprioritized, prioritized);
    }
}
