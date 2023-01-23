package dev.liambloom.ticTacToe.internal;

import java.util.LinkedList;

public class Row {
    /**
     * LinkedList because I will mostly use it as a queue,
     * but also sometimes insert things arbitrarily. I will
     * never need random access or delete from the middle.
     */
    /* Since I am trying to keep this sorted, a TreeSet seems intuitive,
        but the points will mostly be added in order, or by merging, two
        other lists created by adding points in order, so the trees will
        be very, very unbalanced
     */
    private final LinkedList<Point> points = new LinkedList<>();

    private final Orientation orientation;

    public Row(Orientation orientation) {
        this.orientation = orientation;
    }
}
