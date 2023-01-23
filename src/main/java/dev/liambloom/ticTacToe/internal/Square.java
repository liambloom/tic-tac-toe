package dev.liambloom.ticTacToe.internal;

import java.util.Objects;

public class Square {
    private final int x;
    private final int y;

    public Square(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Square(Mark mark) {
        this(mark.getX(), mark.getY());
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Square[] getAdjacentSquares() {
        Square[] r = new Square[8];
        int i = 0;
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                if (x != 0 || y != 0) {
                    r[i++] = new Square(x, y);
                }
            }
        }
        return r;
    }

    public Square[] getAdjacentSquares(Orientation orientation) {
        return switch (orientation) {
            case North_South -> new Square[]{ new Square(x, y + 1), new Square(x, y - 1) };
            case NorthEast_SouthWest -> new Square[]{ new Square(x + 1, y + 1), new Square(x - 1, y - 1) };
            case East_West -> new Square[]{ new Square(x + 1, y), new Square(x - 1, y) };
            case NorthWest_SouthEast -> new Square[]{ new Square(x - 1, y + 1), new Square(x + 1, y - 1) };
        };
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Square other) {
            return this.getX() == other.getX() && this.getY() == other.getY();
        }
        else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY());
    }
}
