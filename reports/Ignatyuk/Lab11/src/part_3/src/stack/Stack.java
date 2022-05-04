package stack;

import java.util.NoSuchElementException;

public final class Stack<Item> {
    private Integer N = 0;
    private Node first = null;

    private final class Node {
        private Item item;
        private Node next;

        public Node(final Item item, final Node next) {
            this.item = item;
            this.next = next;
        }
    }

    public Stack() {
        assert check();
    }

    public final Boolean isEmpty() {
        return this.N == 0;
    }

    public final int size() {
        return this.N;
    }

    public final void push(final Item item) {
        Node oldfirst = this.first;
        first = new Node(item, oldfirst);
        ++this.N;

        assert check();
    }

    public final Item pop() {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        }

        Item item = this.first.item;
        this.first = this.first.next;
        --this.N;

        assert check();
        return item;
    }

    public final Item peek() {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        }

        Item item = this.first.item;

        assert check();
        return item;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();

        for (Node current = this.first; current != null; current = current.next) {
            Item item = current.item;
            sb.append(item + " ");
        }

        return sb.toString();
    }

    public final void clear() {
        while (!this.isEmpty()) {
            this.pop();
        }
    }

    private final Boolean check() {
        if (this.N == 0 && this.first != null) {
            return false;
        }

        if (this.N != 0 && this.first == null) {
            return false;
        }

        if (this.N > 1 && this.first.next == null) {
            return false;
        }

        Integer checkN = 0;

        for (Node x = this.first; x != null; x = x.next) {
            ++checkN;
        }

        if (this.N != checkN) {
            return false;
        }

        return true;
    }
}
