package com.niantic.models;

import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Player
{
    private String name;
    private Hand hand;

    public Player(String name)
    {
        this.name = name;
        hand = new Hand();
    }

    public String getName()
    {
        return name;
    }

    public void dealTo(Card card)
    {
        hand.dealTo(card);
    }

    public int getHandCount()
    {
        return hand.getCardCount();
    }

    public Hand getHand()
    {
        return hand;
    }

    public void playerTurn(Deck deck, Queue<String> players)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println(name + ", it's your turn.");
        System.out.println("1. Play a card");
        System.out.println("2. Draw a card");
        int playOrDraw = scanner.nextInt();

        switch(playOrDraw)
        {
            case 1:         // play card
                System.out.println("Choose a card you want to play by index (ie. the leftmost card is '0').");

                // display all cards in hand with their indexes to make selection easy for player
                for (int i = 0; i < getHandCount(); i++) {
                    System.out.println(i + ": " + getHand().getCards().get(i));
                }

                int chosenIndex = scanner.nextInt();

                // checking if the user inputted an index where a card actually exists. if they did, let them play the card
                if(chosenIndex >= 0 && chosenIndex < getHandCount()) {
                    Card chosenCard = getHand().getCards().get(chosenIndex);
                    System.out.println("You played: " + chosenCard);

                    if(chosenCard instanceof SpecialCard) {
                        SpecialCard specialCard = (SpecialCard) chosenCard;

                        if(specialCard.getType().equals("Reverse"))
                        {
                            reversePlayerOrder(players);
                            System.out.println("UNO Reverse! Reverse player order.");
                        }
                    // because the player used the card, it was discarded from their hand
                    hand.getCards().remove(chosenIndex);
                    }
                }
                else
                {
                    System.out.println("You don't have a card in " + chosenIndex + " index. Please choose an existing card in your hand.");
                }
                break;

            case 2:         // draw card
                Card drawnCard = deck.takeCard();
                if(drawnCard != null)
                {
                    hand.dealTo(drawnCard);
                    System.out.println("You drew " + drawnCard);
                }
                else
                {
                    System.out.println("The deck is empty");
                }

            default:
                System.out.println("Invalid selection. Please choose 1 or 2.");
                break;

        }
    }

    public void reversePlayerOrder(Queue<String> players)
    {
        Stack<String> newPlayerOrder = new Stack<>();

        while(!players.isEmpty())
        {
            newPlayerOrder.push(players.poll());
        }

        while(!newPlayerOrder.isEmpty())
        {
            players.offer(newPlayerOrder.pop());
        }
    }
}
