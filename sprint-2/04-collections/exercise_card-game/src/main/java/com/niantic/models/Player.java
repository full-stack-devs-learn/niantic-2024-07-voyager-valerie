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



}
