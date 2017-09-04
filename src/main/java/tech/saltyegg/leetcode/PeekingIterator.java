package tech.saltyegg.leetcode;

import java.util.Iterator;

/**
 * @author hzhou
 * @since 9/4/17
 */
public class PeekingIterator implements Iterator<Integer> {

    private Iterator<Integer> it;
    private Integer peek;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.

        this.it = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (peek == null) {
            peek = it.next();
        }
        return peek;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (peek != null) {
            Integer tmp = peek;
            peek = null;
            return tmp;
        }
        return it.next();
    }

    @Override
    public boolean hasNext() {
        return peek != null || it.hasNext();
    }
}