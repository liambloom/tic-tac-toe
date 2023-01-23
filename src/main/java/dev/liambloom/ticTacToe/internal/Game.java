package dev.liambloom.ticTacToe.internal;

import java.util.HashMap;
import java.util.HashSet;

public class Game {
    private final HashSet<Point> points = new HashSet<>();

    private final int turn = 0;

    public int getTurn() {
        return turn;
    }
}
