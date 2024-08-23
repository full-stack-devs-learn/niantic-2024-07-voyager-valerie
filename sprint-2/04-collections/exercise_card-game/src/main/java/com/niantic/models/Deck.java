package com.niantic.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck
{
    private ArrayList<Card> cards;

    public Deck()
    {
        // build the deck of cards
        cards = new ArrayList<>();

        int[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};   // 1 zero, 2 of 1-9 per color
        String[] colors = {"Red", "Blue", "Green", "Yellow"};
        String[] specialCards = {"Reverse", "Skip", "Draw Two"};

        for(String color : colors) {
            cards.add(new Card(color, 0));          // every color has '0'
            for (int number : numbers)
            {
                if (number > 0) {
                    cards.add(new Card(color, number));         // every color has 2 of each '1-9'
                    cards.add(new Card(color, number));
                }
            }

            for (String specialCard : specialCards)
            {
                cards.add(new SpecialCard(color, specialCard));     // each color has 2 of each (Reverse, Skip, Draw 2)
                cards.add(new SpecialCard(color, specialCard));
            }
            cards.add(new SpecialCard("Wild", "Wild"));
            cards.add(new SpecialCard("Wild", "Draw Four"));
        }
    }

    public List<Card> getCards() {
        return cards;
    }

    public int getCardCount()
    {
        return cards.size();
    }

    public Card takeCard()
    {
        Card card = cards.removeFirst();
        return card;
    }

    public void shuffle()
    {
        Collections.shuffle(cards);
    }

    public void startGame(List<Player> players) {
        shuffle();

        for (Player player : players) {
            for (int i = 0; i < 7; i++) {
                if (!cards.isEmpty()) {
                    player.dealTo(takeCard()); // Deal one card to the player
                }
            }
        }
    }
}
