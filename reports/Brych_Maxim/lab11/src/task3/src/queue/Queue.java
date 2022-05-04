package queue;

import java.util.NoSuchElementException;

/**
 * The <tt>Queue</tt> class represents a first-in-first-out (FIFO) queue of
 * generic items. It supports the usual <em>enqueue</em> and <em>dequeue</em>
 * operations, along with methods for peeking at the top item, testing if the
 * queue is empty, and iterating through the items in FIFO order.
 */

public class Queue<Item> {
    // the number of elements
    private int N;

    // the head
    private Node first;

    // the tail                    //fixed
    private Node last;

    // simple Node
    private class Node {
        private Item item;
        private Node next;
    }

    /**
     * Create an empty queue.
     */
    public Queue() {
        clear();                //fixed
    }

    /**
     * Clear queue.
     */
    public void clear() {
        first = null;
        last = null;
        N = 0;
        assert check();
    }

    /**
     * Is the queue empty?
     */
    public boolean isEmpty() {
        return first == null;               // != // ==
    }

    /**
     * Return the number of items in the queue.
     */
    public int size() {
        return N;
    }

    /**
     * Return the item least recently added to the queue.
     *
     * @throws java.util.NoSuchElementException if queue is empty.
     */
    public Item peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();     // added
        }
        return first.item;
    }

    /**
     * Add the item to the queue.
     */
    public void enqueue(Item item) {
        Node oldLast = last;             // oldlast // oldLast

        last = new Node();
        last.item = item;
        last.next = null;

        ++N;                            // added

        if (isEmpty()) {
            first = last;
        }
        else {
            oldLast.next = last;
        }

        assert check();
    }

    /**
     * Remove and return the item on the queue least recently added.
     *
     * @throws java.util.NoSuchElementException if queue is empty.
     */
    // name fixed
    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();         // added
        }

        Item item = first.item;
        first = first.next;

        --N;

        if (isEmpty()) {
            last = null;                                // fixed
        }

        assert check();
        return item;
    }

    /**
     * Return string representation.
     */
    public String toString() {
        StringBuilder s = new StringBuilder();

        for (Node x = first; x != null; x = x.next) {
            s.append(x.item).append(" ");               // added
        }

        return s.toString();
    }

    // internal invariants checking
    private boolean check() {
        if (N == 0) {
            if (first != null) {
                return false;
            }
            return last == null;
        }
        else if (N == 1) {
            if (first == null || last == null) {
                return false;
            }
            if (first != last) {
                return false;
            }
            return first.next == null;
        }
        else {
            // become more wide
            if (first == null || last == null) {
                return false;
            }
            if (first == last) {
                return false;
            }
            if (first.next == null) {
                return false;
            }
            if (last.next != null) {
                return false;
            }

            // internal consistency of instance variable N checking
            int numberOfNodes = 0;

            for (Node x = first; x != null; x = x.next) {
                numberOfNodes++;
            }

            if (numberOfNodes != N) {
                return false;
            }

            // internal consistency of instance variable last checking
            Node lastNode = first;

            while (lastNode.next != null) {
                lastNode = lastNode.next;
            }

            return last == lastNode;
        }
    }
}
