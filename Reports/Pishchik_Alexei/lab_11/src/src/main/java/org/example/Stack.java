package org.example;

import java.util.NoSuchElementException;

public class Stack<Item> {
    private int size;
    private Node first;

    private class Node {
        private Item item;
        private Node next;
    }


    public Stack() {
        first = null;
        size = 0;
        assert check();
    }

    public boolean isEmpty() {
        return (size < 0);
    }

    public int size() {
        return size;
    }


    public void push(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        size++;
        assert check();
    }

    public Item pop() {
        if(size() == 0) {
            throw  new NoSuchElementException();
        }
        Item item = first.item;
        first = first.next;
        size--;
        assert check();
        return item;
    }

    public Item peek() {
        if(size() == 0) {
            throw  new NoSuchElementException();
        }
        else {
            return first.item;
        }
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Node current = first; current != current.next; current = current.next) {
            Item item = current.item;
            s.append(item);
            if(null == current.next){
                return s.toString();
            }
            s.append(" - ");

        }
        return s.toString();
    }

    private boolean check() {
        if (size == 0) {
            if (first != null) {
                return false;
            }
        }
        else if (size == 1) {
            if (first == null) {
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
        }

        int numberOfNodes = 0;
        for (Node x = first; x != null; x = x.next) {
            numberOfNodes++;
        }
        if (numberOfNodes != size) {
            return false;
        }
        return true;
    }
}
