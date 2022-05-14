package com.spp.labs.stack;

import java.util.NoSuchElementException;

/**
 * The <tt>Stack</tt> class represents a last-in-first-out (LIFO) stack of
 * generic items. It supports the usual <em>push</em> and <em>pop</em>
 * operations, along with methods for peeking at the top item, testing if the
 * stack is empty, and iterating through the items in LIFO order.
 * <p>
 */
//TODO FIXME Find Bugs & Write Tests
public class Stack<Item> {
    private int N; // size of the stack
    private Node first; // top of stack
    private Node last;

    // helper linked list class
    private class Node {
        private Item item;
        private Node next;
    }

    /**
     * Create an empty stack.
     */
    public Stack() {
        clear();
    }
    
    public void clear() {
        first = null;
        last = null;
        N = 0;
        assert check();
    }

    /**
     * Is the stack empty?
     */
    public boolean isEmpty() {
        // TODO Implement method
        return N == 0;
    }

    /**
     * Return the number of items in the stack.
     */
    public int size() {
        return N;
    }

    /**
     * Add the item to the stack.
     */
    public void push(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        last = first;
        N++;
        assert check();
    }

    /**
     * Delete and return the item most recently added to the stack.
     *
     * @throws java.util.NoSuchElementException if stack is empty.
     */
    public Item pop() {
        // FIXME throw exception if stack is Empty.
        if (isEmpty())
            throw new NoSuchElementException();
        
        Item item = first.item; // save item to return
        first = first.next; // delete first node
        N--;
        assert check();
        return item; // return the saved item
    }

    /**
     * Return the item most recently added to the stack without deletion.
     *
     * @throws java.util.NoSuchElementException if stack is empty.
     */
    public Item peek() {
        // TODO implement function
        // FIXME throw exception if stack is Empty.
        if (isEmpty())
            throw new NoSuchElementException();
        
        return first.item;
    }
    
    public int search(Item searchItem) {
        if (isEmpty()) 
            return -1;
        
        int counter = 0;
        Node item = first;
                
        while (item != null) {
            if (item.item.equals(searchItem)) {
                return counter;
            }
            
            counter++;
            item = item.next;
        }
        
        return -1;
    }

    /**
     * Return string representation.
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Node current = first; current != null; current = current.next) {
            Item item = current.item;
            s.append(item).append(" ");
        }
        return s.toString();
    }

    // check internal invariants
    private boolean check() {
        if (N == 0) {
            if (first != null || last != null) {
                return false;
            }
        }
        else if (N == 1) {
            if (first == null || last == null) {
                return false;
            }
            if (first.next != null) {
                return false;
            }
        }
        else {
            if (first.next == null) {
                return false;
            }
            if (first == null || last == null) {
                return false;
            }
        }

        // check internal consistency of instance variable N
        int numberOfNodes = 0;
        
        for (Node x = first; x != null; x = x.next) {
            numberOfNodes++;
        }
        
        if (numberOfNodes != N) {
            return false;
        }

        return true;
    }
}
