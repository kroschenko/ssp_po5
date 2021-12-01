package main6.task2;

import java.util.Iterator;


public class FlattenIterator<T> implements Iterator<T> {

    private final Iterator<Iterator<T>> iterator;

    private Iterator<T> current;

    public FlattenIterator(Iterator<Iterator<T>> iterator) {
        this.iterator = iterator;
        if (iterator.hasNext()){
            current = iterator.next();
        }
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext() || current.hasNext();
    }

    @Override
    public T next() {
        if (!current.hasNext()) {
            current = iterator.next();
        }
        return current.next();
    }
}
