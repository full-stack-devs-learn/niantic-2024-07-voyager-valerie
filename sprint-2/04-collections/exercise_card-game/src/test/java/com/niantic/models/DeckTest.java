package com.niantic.models;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DeckTest
{
    private long countNumberedCards(List<Card> cards, String color)
    {
        // finds how many cards of each color were created
        return cards.stream()
                .filter(card -> card.getColor().equals(color) && card.getValue() >= 0)
                .count();
    }

    private long countSpecialCards(List<Card> cards, String color)
    {
        return cards.stream()
                .filter(card -> card instanceof SpecialCard && card.getColor().equals(color))
                .count();
    }

    private long countWildCards(List<Card> cards)
    {
        return cards.stream()
                .filter(card -> card instanceof SpecialCard && "Wild".equals(((SpecialCard) card).getType()))
                .count();
    }

    private long countDrawFour(List<Card> cards)
    {
        return cards.stream()
                .filter(card -> card instanceof SpecialCard && "Draw Four".equals(((SpecialCard) card).getType()))
                .count();
    }

    @Test
    public void getCards_shouldReturn_entireDeck()
    {
        // arrange
        Deck deck = new Deck();
        List<Card> cards = deck.getCards();

        int expectedNumberedCardsByColor = 4 * (2 * 9 + 1);       // 4 colors * (2 * 9 + 1)
        int expectedSpecialCardsByColor = 4* (2 * 3);     // 4 colors * ( 2 * 3)
        int expectedWild = 4;
        int expectedDrawFour = 4;

        int expectedDeckSize = expectedNumberedCardsByColor + expectedSpecialCardsByColor + expectedWild + expectedDrawFour;

        // act
        // assert
        assertEquals(expectedDeckSize, cards.size(), "The total number of cards in the deck should be 108.");

    }

    @Test
    public void getCards_shouldReturn_allNumberedCards()
    {
        Deck deck = new Deck();

        List<Card> cards = deck.getCards();

        // arrange
        int expectedNumberedCardsByColor = 4 * (2 * 9 + 1);

        // act
        int actualRedNumberedCards = (int) countNumberedCards(cards, "Red");
        int actualBlueNumberedCards = (int) countNumberedCards(cards, "Blue");
        int actualYellowNumberedCards = (int) countNumberedCards(cards, "Yellow");
        int actualGreenNumberedCards = (int) countNumberedCards(cards, "Green");

        int actualNumberedCardsByColor = actualRedNumberedCards + actualBlueNumberedCards + actualYellowNumberedCards + actualGreenNumberedCards;

        // assert
        assertEquals(expectedNumberedCardsByColor, actualNumberedCardsByColor, "There should be 76 numbered cards.");
    }

    @Test
    public void getCards_shouldReturn_allSpecialCardsExcludingWildCards()
    {
        Deck deck = new Deck();

        List<Card> cards = deck.getCards();

        // arrange
        int expectedSpecialCards = 4 * (2 * 3);    // 4 color * (2 copies * 3 unique types)

        // act
        long redSpecialCards = countSpecialCards(cards, "Red");
        long blueSpecialCards = countSpecialCards(cards, "Blue");
        long yellowSpecialCards = countSpecialCards(cards, "Yellow");
        long greenSpecialCards = countSpecialCards(cards, "Green");

        long actualSpecialCards = redSpecialCards + blueSpecialCards + yellowSpecialCards + greenSpecialCards;

        // assert
        assertEquals(expectedSpecialCards, actualSpecialCards, "There should be 24 total special cards.");
    }

    @Test
    public void getCards_shouldReturn_allWildCards()
    {
        // arrange
        int expectedWildCards = 4;
        int expectedDrawFour = 4;

        int expectedTotalWildCards = expectedDrawFour + expectedWildCards;

        // act
        Deck deck = new Deck();
        List<Card> cards = deck.getCards();

        long actualWildCards = countWildCards(cards);
        long actualDrawFour = countDrawFour(cards);

        long actualTotalWildCards = actualWildCards + actualDrawFour;

        // assert
        assertEquals(expectedTotalWildCards, actualTotalWildCards, "There should be 8 total wild cards");
    }

    @Test
    public void startGame_shouldReturn_SevenCardsPerPlayer()
    {
        // arrange
        int expectedHandPerPlayer = 7;

        Deck deck = new Deck();
        Queue<Player> players = new LinkedList<>();

        players.add(new Player("Eren"));
        players.add(new Player("Mikasa"));
        players.add(new Player("Armin"));
        players.add(new Player("Jean"));

        // act
        deck.startGame(players);

        // assert
        for (Player player: players)
        {
            assertEquals(expectedHandPerPlayer, player.getHand().getCardCount(),
                    "Each player should have 7 cards in their hand.");
        }
    }

    @Test
    public void startGame_shouldReturn_RemainingCardsLeftToPlay()
    {
        // arrange
        Deck deck = new Deck();
        Queue<Player> players = new LinkedList<>();

        int expectedCardsPerPlayer = 7;
        int totalCardsInDeck = 108;

        players.add(new Player("Eren"));
        players.add(new Player("Mikasa"));
        players.add(new Player("Armin"));
        players.add(new Player("Jean"));

        // act
        deck.startGame(players);
        int expectedCardsDealt = expectedCardsPerPlayer * players.size();
        int expectedCardsLeft = totalCardsInDeck - expectedCardsDealt;

        // assert
        int actualCardsLeft = deck.getCardCount();

        assertEquals(expectedCardsLeft, actualCardsLeft, "There should be " + actualCardsLeft + " cards remaining in the deck.");

    }
}