package com.niantic.models;

import java.util.ArrayList;
import java.util.Collections;

import static java.util.Collections.sort;

public class Hand
{
    private ArrayList<Card> cards = new ArrayList<>();

    public ArrayList<Card> getCards()
    {
        return cards;
    }

    public int getPointValue()
    {
        // return sum of all card points
        int sum = cards.stream()
                        .map(card -> card.getPointValue())
                        .reduce(0, (temp, value) -> temp + value);

        return sum;
    }

    public void Sort()
    {
        Collections.sort(cards);
    }

    public int getCardCount()
    {
        return cards.size();
    }


    public void dealTo(Card card)
    {
        cards.add(card);

        // sort after new card is added
        Sort();
    }
}
