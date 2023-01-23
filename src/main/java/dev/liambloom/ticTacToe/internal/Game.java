package dev.liambloom.ticTacToe.internal;

import java.util.*;

public class Game {
    private final HashMap<Square, Mark> board = new HashMap<>();
    private final int rows;
    private final int cols;
    private final int winLength;
    private final int onBoard;

    private int turn = 0;
    private final Team currentTeam = Team.X;

    public Game(int rows, int cols, int winLength, int onBoard) {
        this.rows = rows;
        this.cols = cols;
        this.winLength = winLength;
        this.onBoard = onBoard;
    }

    public Mark place(int x, int y) throws MarkPlacementException {
        if (x < 0 || y < 0 || x >= rows || y >= cols) {
            throw new MarkPlacementException(MarkPlacementException.Type.OutOfBounds);
        }

        Mark mark = new Mark(this, getCurrentTeam(), x, y);
        Square square = new Square(mark);

        if (board.putIfAbsent(square, mark) != null) {
            throw new MarkPlacementException(MarkPlacementException.Type.OccupiedSpace);
        }

        for (Orientation orientation : Orientation.values()) {
            Square[] adjacent = square.getAdjacentSquares(orientation);
            List<Mark> adjacentMarks = new ArrayList<>(adjacent.length);
            for (int i = 0; i < adjacent.length; i++) {
                Mark adjMark = board.get(adjacent[i]);
                if (adjMark != null)
                    adjacentMarks.add(adjMark);
            }

            if (adjacentMarks.isEmpty())
                continue;

            Row[] adjRows = new Row[adjacentMarks.size() + 1];
            for (int i = 0; i < adjacentMarks.size(); i++) {
                Mark adjMark = adjacentMarks.get(i);
                Row adjRow = mark.getRow(orientation);
                adjRows[i] = Objects.requireNonNullElseGet(adjRow, () -> new Row(orientation, adjMark));
            }

            adjRows[adjRows.length - 1] = new Row(orientation, mark);

            if (Row.merge(adjRows).length() >= winLength) {
                // TODO: Game Won
            }
        }

        return mark;
    }

    public int getTurn() {
        return turn;
    }

    public Team getCurrentTeam() {
        return currentTeam;
    }
}
