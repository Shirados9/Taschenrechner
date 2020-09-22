package de.hsworms.ztt.keidel.calculator.explorativecode;

import de.hsworms.ztt.keidel.calculator.explorativecode.StackImpl;
import de.hsworms.ztt.keidel.calculator.explorativecode.StackInterface;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StackInterfaceTest {

    private StackInterface stack;

    @Before
    public void setUp() throws Exception {
        stack = new StackImpl();
    }

    @After
    public void tearDown() throws Exception {
        stack = null;
    }

    @Test
    // 1
    public void testAutoBoxing() {
        Integer one = 1;
        assertEquals(one, new Integer(1));
    }

    @Test
    // 2
    public void push() {
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());

        assertEquals(0, stack.size());
    }

    @Test
    // 3
    public void pop() {
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.pop());
    }

    @Test
    // 4
    public void popWithException() {
        try {
            stack.pop();
            fail("Expected 'IndexOutOfBoundsException'");
        } catch (IndexOutOfBoundsException e) {
            // OK, test passed
        } catch (Exception e) {
            fail("Wrong Exception fired: " + e.getMessage());
        }
    }

    @Test
    public void clearAll() {
        stack.push(1);
        stack.push(2);
        stack.clearAll();
        assertEquals(0, stack.size());
    }

    private static final int TEST_SIZE = 100;

    @Test
    public void size() {

        for (int i = 0; i < TEST_SIZE; i++) {
            stack.push(i);
        }
        assertEquals(TEST_SIZE, stack.size());
    }
}