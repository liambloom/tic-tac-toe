package dev.liambloom.ticTacToe.internal;

import java.util.*;

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
    private final List<Mark> marks;

    private final Orientation orientation;

    public Row(Orientation orientation, Mark... marks) {
        this(orientation, new LinkedList<>());
        Collections.addAll(this.marks, marks);
    }

    public Row(Orientation orientation, LinkedList<Mark> marks) {
        this.orientation = orientation;
        this.marks = marks;
    }

    public static Row merge(Orientation orientation, Row... rows) {
        PriorityQueue<PeekableIterator<Mark>> pq =
                new PriorityQueue<>(Comparator.comparing(iter -> iter.peek().getTurnCreated()));

        for (Row row : rows)
            pq.add(PeekableIterator.from(row.marks.iterator()));

        LinkedList<Mark> list = new LinkedList<>();

        // TODO: To improve efficiency, use a ListIterator from the longest
        //  row to add things to that one list. Also, for each Mark, replace
        //  mark.row[orientation.ordinal()] = newRow
        while (!pq.isEmpty()) {
            PeekableIterator<Mark> iter = pq.poll();
            list.add(iter.next());
            if (iter.hasNext())
                pq.add(iter);
        }

        return new Row(orientation, list);
    }

    public int length() {
        return marks.size();
    }
}
