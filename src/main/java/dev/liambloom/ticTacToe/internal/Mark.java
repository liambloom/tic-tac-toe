package dev.liambloom.ticTacToe.internal;

import java.util.Collections;
import java.util.List;

public class Mark {
    private final Game game;
    private final Team team;
    private final int x;
    private final int y;
    private final int turnCreated;
    private final Row[] rows = new Row[4];

    public Mark(Game game, Team team, int x, int y) {
        this.game = game;
        this.team = team;
        this.x = x;
        this.y = y;
        turnCreated = game.getTurn();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public List<Row> getRows() {
        return List.of(rows);
    }

    public Row getRow(Orientation orientation) {
        return rows[orientation.ordinal()];
    }
}
