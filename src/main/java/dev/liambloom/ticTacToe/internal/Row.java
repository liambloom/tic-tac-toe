package dev.liambloom.ticTacToe.internal;

import java.util.Collections;
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
    private final LinkedList<Mark> marks;

    private final Orientation orientation;

    public Row(Orientation orientation, Mark... marks) {
        this.orientation = orientation;
        this.marks = new LinkedList<>();
        Collections.addAll(this.marks, marks);
    }

    public static Row merge(Row... rows) {
        // TODO: Merging Rows
        return null;
    }

    public int length() {
        return marks.size();
    }
}
