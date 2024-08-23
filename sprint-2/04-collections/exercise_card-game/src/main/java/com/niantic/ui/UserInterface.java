package com.niantic.ui;

import com.niantic.models.Card;
import com.niantic.models.Player;

import java.util.ArrayList;

public class UserInterface
{
    public static void displayAllPlayersCards(ArrayList<Player> players)
    {
        System.out.println("All Players");
        System.out.println("-".repeat(30));
        for (Player player : players)
        {
            System.out.println(player.getName());
            System.out.println("Cards in Hand" + ": " + player.getHandCount());

            System.out.println();
            for (Card card : player.getHand().getCards())
            {
                System.out.println(card);
            }
            System.out.println();
        }
    }
}
