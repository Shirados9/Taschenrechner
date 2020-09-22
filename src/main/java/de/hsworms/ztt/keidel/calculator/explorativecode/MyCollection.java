package de.hsworms.ztt.keidel.calculator.explorativecode;

import java.util.Iterator;
import java.util.StringTokenizer;

public class MyCollection implements Iterator<String> {

    private StringTokenizer stringTokenizer;

    public MyCollection(String inputString) {
        stringTokenizer = new StringTokenizer(inputString);
    }


    /**
     * Returns {@code true} if the iteration has more elements.
     * (In other words, returns {@code true} if {@link #next} would
     * return an element rather than throwing an exception.)
     *
     * @return {@code true} if the iteration has more elements
     */
    @Override
    public boolean hasNext() {
        return stringTokenizer.hasMoreTokens();
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     * @throws java.util.NoSuchElementException if the iteration has no more elements
     */
    @Override
    public String next() {
        return stringTokenizer.nextToken();
    }
}
