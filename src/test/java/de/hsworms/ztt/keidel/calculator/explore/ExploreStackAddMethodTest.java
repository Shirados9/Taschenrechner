package de.hsworms.ztt.keidel.calculator.explore;

import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.*;

public class ExploreStackAddMethodTest {

    @Test
    public void testAddMethodOfStack() {
        Stack<Integer> integerStack = new Stack<>();
        integerStack.add(0, 1);
        integerStack.add(0, 2);
        integerStack.add(0, 3);
        assertEquals(new Integer(1), integerStack.pop());
        assertEquals(new Integer(2), integerStack.pop());
        assertEquals(new Integer(3), integerStack.pop());
    }
}
