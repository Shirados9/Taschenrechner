package de.hsworms.ztt.keidel.calculator.explorativecode;

public interface StackInterface {

    void push(Object o);

    Object pop() throws IndexOutOfBoundsException;

    void clearAll();

    int size();

}
