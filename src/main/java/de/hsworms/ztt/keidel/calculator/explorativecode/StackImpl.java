package de.hsworms.ztt.keidel.calculator.explorativecode;

import java.util.EmptyStackException;
import java.util.Stack;

public class StackImpl implements StackInterface {

    private Object[] content = new Object[10];
    private Stack<Object> stack = new Stack<>();

    @Override
    public void push(Object o) {
        stack.push(o);
    }

    @Override
    public Object pop() throws IndexOutOfBoundsException {
        Object result;
        try {
            result = stack.pop();
        } catch (EmptyStackException emptyStackException) {
            throw new IndexOutOfBoundsException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    @Override
    public void clearAll() {
        stack.clear();
    }

    @Override
    public int size() {
        return stack.size();
    }
}
