package com.niantic.models;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Deck deck;
    private List<Player> players;

    public Game() {
        deck = new Deck();
        players = new ArrayList<>();
    }

}
