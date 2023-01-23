package dev.liambloom.ticTacToe.internal;

public class Point {
    private final Game game;
    private final Team team;
    private final int x;
    private final int y;
    private final int turnCreated;
    private final Row[] rows = new Row[4];

    public Point(Game game, Team team, int x, int y) {
        this.game = game;
        this.team = team;
        this.x = x;
        this.y = y;
        turnCreated = game.getTurn();
    }
}
