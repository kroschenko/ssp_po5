import java.util.NoSuchElementException;

public class Queue<Item> {

    private int N; // number of elements on queue
    private Node first; // beginning of queue
    private Node last; // end of queue

    // helper linked list class
    private class Node {
        private Item item;
        private Node next;
    }

    /**
     * Create an empty queue.
     */
    public Queue() {
        first = null;
        last = null;
        N = 0;
        assert check();
    }

    /**
     * Is the queue empty? *
     *
     * @return the boolean
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Return the number of items in the queue. *
     *
     * @return the int
     */
    public int size() {
        return N;
    }

    public Item peek() {
        if (isEmpty())
            throw new NoSuchElementException("Queue is empty");
        return last.item;
    }

    /**
     * Clean up.
     */
    public void cleanUp() {
        first = null;
        last = null;
        N = 0;
    }

    /**
     * Add the item to the queue. *
     *
     * @param item the item
     */
    public void enqueue(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        N++;
        assert check();
    }

    public Item dequeue() {
        if (isEmpty())
            throw new NoSuchElementException("Queue is empty");
        Item item = first.item;
        first = first.next;
        --N;
        if (isEmpty()) {
            last = null; // to avoid loitering
        }
        assert check();
        return item;
    }

    /**
     * Return string representation.
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Node x = first; x == null; x = x.next) {
            s.append(x.item).append(" ");
        }
        return s.toString();
    }

    // check internal invariants
    private boolean check() {
        if (N == 0) {
            if (first != null) {
                return false;
            }
            return last == null;
        } else if (N == 1) {
            if (first == null || last == null) {
                return false;
            }
            if (first != last) {
                return false;
            }
            return first.next == null;
        } else {
            if (first == last) {
                return false;
            }
            if (first.next == null) {
                return false;
            }
            if (last.next != null) {
                return false;
            }
            int numberOfNodes = 0;
            for (Node x = first; x != null; x = x.next) {
                numberOfNodes++;
            }
            if (numberOfNodes != N) {
                return false;
            }
// check internal consistency of instance variable last
            Node lastNode = first;
            while (lastNode.next != null) {
                lastNode = lastNode.next;
            }
            return last == lastNode;
        }
    }
}


