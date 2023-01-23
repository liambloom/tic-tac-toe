package dev.liambloom.ticTacToe.internal;

public class MarkPlacementException extends Exception {
    public static enum Type {
        OutOfBounds,
        OccupiedSpace,
    }

    private final Type type;

    public MarkPlacementException(Type type) {
        this.type = type;
    }
}
