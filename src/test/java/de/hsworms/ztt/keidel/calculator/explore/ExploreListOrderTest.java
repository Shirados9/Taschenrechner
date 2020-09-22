package de.hsworms.ztt.keidel.calculator.explore;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static org.junit.Assert.assertEquals;

public class ExploreListOrderTest {

    @Test
    public void testAddMethodOfStack() {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);

        int counter = 1;
        for (Integer i : integerList) {
            assertEquals(new Integer(counter), i);
            counter++;
        }
    }
}
