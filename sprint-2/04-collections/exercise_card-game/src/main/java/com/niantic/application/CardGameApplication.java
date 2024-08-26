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
    private Card currentCard;

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
        currentCard = deck.takeCard();
        System.out.println(currentCard + " was drawn.");      // pull the first card to begin the game

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

    private Card getCurrentCard()
    {
        return currentCard;
    }

    private void setCurrentCard(Card card)
    {
        this.currentCard = card;
    }

    public void playerTurn(Player player) {
        Scanner scanner = new Scanner(System.in);
        boolean validPlay = false;              // represents if the player played a card, which will end their turn when "True"

        while (!validPlay) {
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

            switch (playOrDraw) {
                case 1:         // play card
                    System.out.println();
                    System.out.println("Choose a card you want to play by index (ie. the leftmost card is '0').");
                    System.out.println();

                    for (int i = 0; i < player.getHandCount(); i++) {
                        System.out.println(i + ": " + player.getHand().getCards().get(i));
                    }

                    int chosenIndex = Integer.parseInt(scanner.nextLine());

                    // checking if the user inputted an index where a card actually exists
                    if (chosenIndex >= 0 && chosenIndex < player.getHandCount()) {
                        Card chosenCard = player.getHand().getCards().get(chosenIndex);

                        // first check if the card is a special card
                        if (chosenCard instanceof SpecialCard) {
                            SpecialCard specialCard = (SpecialCard) chosenCard;

                            // if it's a reverse, reverse the player order
                            if (specialCard.getType().equals("Reverse") && specialCard.getColor().equals(currentCard.getColor())) {
                                reversePlayerOrder(players);
                                System.out.println("UNO Reverse! Reverse player order.");

                                player.getHand().getCards().remove(chosenIndex);

                                setCurrentCard(chosenCard);         // new card to be compared to

                                System.out.println();
                                System.out.println(chosenCard + " was played.");

                                validPlay = true;
                                break;
                            }

                            // skip the next player's turn
                            if (specialCard.getType().equals("Skip") &&
                                    specialCard.getColor().equals(currentCard.getColor())) {
                                player.getHand().getCards().remove(chosenIndex);            // remove the Skip card from the player's hand

                                Player skippedPlayer = players.poll();             // remove person who just played from queue
                                players.offer(skippedPlayer);               // add the player back into the queue (at the back), ready for their next turn

                                currentPlayer = players.peek();

                                System.out.println("UNO Skip! " + currentPlayer.getName() + "'s turn was skipped.");
                                setCurrentCard(chosenCard);

                                System.out.println();
                                System.out.println(chosenCard + "was played.");

                                validPlay = true;
                                break;
                            }

                            // accept user input about the next color assignment
                            if (specialCard.getType().equals("Wild") || specialCard.getType().equals("Draw Four"))
                            {
                                System.out.println("You played a Wild Card! Choose any color: red, blue, green, or yellow.");
                                String newColor = scanner.nextLine().trim().toLowerCase();

                                if (newColor.equals("red") ||
                                    newColor.equals("blue") ||
                                    newColor.equals("green") ||
                                    newColor.equals("yellow"))

                                    //
                                    if(!newColor.equals(currentCard.getColor())) {
                                        {
                                            currentCard.setColor(newColor);
                                            player.getHand().getCards().remove(chosenIndex);
                                            setCurrentCard(chosenCard);

                                            System.out.println();
                                            System.out.println("You played a Wild Card! The color has successfully been changed to " + newColor + ".");
                                            validPlay = true;
                                        }
                                    }
                                    else
                                    {
                                        System.out.println();
                                        System.out.println("Invalid color choice! The color must be different from " + currentCard + ".");
                                    }
                            }
                            else
                            {
                                System.out.println();
                                System.out.println("Invalid color choice. Choose red, blue, green, or yellow.");
                            }
                        }

                        // does the card match the color of the card that was just played? what about the number?
                        // if either match, the play is valid, and the player's turn can end
                        if (chosenCard.getColor().equals(getCurrentCard().getColor()) ||
                                chosenCard.getValue() == getCurrentCard().getValue()) {

                            // because the player used the card, it was discarded from their hand
                            player.getHand().getCards().remove(chosenIndex);
                            setCurrentCard(chosenCard);

                            System.out.println("You played: " + chosenCard);
                            validPlay = true;
                            break;
                        } else {
                            System.out.println();
                            System.out.println("Illegal play. The color or number must match the card that was just played.");
                            // not valid play, so should loop back to start
                        }
                    } else {
                        System.out.println();
                        System.out.println("A card does not exist at " + chosenIndex + ". Please choose a valid index.");
                        // invalid play, so loop back to start
                    }
                    break;

                case 2:         // draw card
                    while (true) {
                        Card drawnCard = deck.takeCard();

                        player.dealTo(drawnCard);               // pull card and put into hand
                        System.out.println("You drew " + drawnCard);

                        System.out.println();
                        System.out.println("Here's your updated hand: ");
                        for (int i = 0; i < player.getHandCount(); i++) {
                            System.out.println(i + ": " + player.getHand().getCards().get(i));
                        }

                        System.out.println();
                        System.out.println("This is the card that was just played: " + getCurrentCard());
                        System.out.println("Do you want to play " + drawnCard + "? (y/n)");

                        String playCard = scanner.nextLine().trim().toLowerCase();      // removes whitespace and ensures that user input returns in lowercase

                        if (playCard.equals("y")) {
                            player.getHand().getCards().remove(drawnCard);              // removes the card the player decided to play from their hand
                            setCurrentCard(drawnCard);

                            System.out.println("You played: " + drawnCard);
                            System.out.println();

                            validPlay = true;
                            break;          // end player turn
                        }
                        else if (playCard.equals("n")) {
                            System.out.println();
                            System.out.println("Drawing another card:");
                        }
                        else {
                            System.out.println("Invalid input. Enter 'y' or 'n' to continue playing.");
                            System.out.println();
                            // loop back to start
                        }
                    }
                    break;

                default:
                    System.out.println();
                    System.out.println("Invalid selection. Please choose 1 or 2.");
                    break;
            }
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
