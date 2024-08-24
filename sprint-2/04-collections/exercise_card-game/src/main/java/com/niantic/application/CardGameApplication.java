package com.niantic.application;

import com.niantic.models.*;
import com.niantic.ui.UserInterface;

import java.util.*;

public class CardGameApplication
{
    private Deck deck;
    private Queue<Player> players;
    private Player currentPlayer;
    private boolean playingGame;

    public CardGameApplication() {
        deck = new Deck();
        players = new LinkedList<>();
        playingGame = true;
    }
    
    public void run()
    {
        addPlayers();

        // shuffling the deck is built into start game
        deck.startGame(players);
        UserInterface.displayAllPlayersCards(players);

        System.out.println("GAME START!");
        System.out.println();
        System.out.println("A " + deck.takeCard() + " was drawn.");      // pull the first card to begin the game

        currentPlayer = players.peek();           // player who starts the game, pull from the top of stack

        while (playingGame) {
            playerTurn(currentPlayer);

            if(isWinner())              // if someone empties their hand, they win the round
            {
                playingGame = false;
                System.out.println(currentPlayer.getName() + " wins!");
                continue;                       // game ends
            }
            currentPlayer = players.poll();             // remove person who just played from queue
            players.offer(currentPlayer);               // add the player back into the queue (at the back), ready for their next turn


            currentPlayer = players.peek();             // now currentPlayer represents the next player
        }
    }

    private void addPlayers()
    {
        players.add(new Player("Oliver"));
        players.add(new Player("Mary"));
    }

    public void playerTurn(Player player)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println();

        // display all cards in hand with their indexes to make selection easy for player
        for (int i = 0; i < player.getHandCount(); i++) {
            System.out.println(i + ": " + player.getHand().getCards().get(i));
        }

        System.out.println();
        System.out.println("The above are the cards in your hand. " + player.getName() + ", what would you like to do?");
        System.out.println();

        System.out.println("1. Play a card");
        System.out.println("2. Draw a card");
        int playOrDraw = Integer.parseInt(scanner.nextLine());

        switch(playOrDraw)
        {
            case 1:         // play card
                System.out.println();
                System.out.println("Choose a card you want to play by index (ie. the leftmost card is '0').");
                System.out.println();

                for (int i = 0; i < player.getHandCount(); i++) {
                    System.out.println(i + ": " + player.getHand().getCards().get(i));
                }

                int chosenIndex = Integer.parseInt(scanner.nextLine());

                // checking if the user inputted an index where a card actually exists. if they did, let them play the card
                if(chosenIndex >= 0 && chosenIndex < player.getHandCount()) {
                    Card chosenCard = player.getHand().getCards().get(chosenIndex);
                    System.out.println("You played: " + chosenCard);

                    if(chosenCard instanceof SpecialCard) {
                        SpecialCard specialCard = (SpecialCard) chosenCard;

                        if(specialCard.getType().equals("Reverse"))
                        {
                            reversePlayerOrder(players);
                            System.out.println("UNO Reverse! Reverse player order.");
                        }
                    }
                    // because the player used the card, it was discarded from their hand
                    player.getHand().getCards().remove(chosenIndex);
                    break;
                }

            case 2:         // draw card
                Card drawnCard = deck.takeCard();
                player.dealTo(drawnCard);
                System.out.println("You drew " + drawnCard);
                break;

            default:
                System.out.println("Invalid selection. Please choose 1 or 2.");
        }
    }

    public void reversePlayerOrder(Queue<Player> players)
    {
        Stack<Player> newPlayerOrder = new Stack<>();

        while(!players.isEmpty())
        {
            newPlayerOrder.push(players.poll());
        }

        while(!newPlayerOrder.isEmpty())
        {
            players.offer(newPlayerOrder.pop());
        }
    }

    private boolean isWinner()
    {
        for (Player player : players)
        {
            if(player.getHandCount() == 0)
            {
                currentPlayer = player;
                return true;
            }
        }
        return false;
    }
}
