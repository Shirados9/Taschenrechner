package de.hsworms.ztt.keidel.calculator.explorativecode;

import de.hsworms.ztt.keidel.calculator.explorativecode.Adder;
import org.junit.Test;

import static org.junit.Assert.*;

public class AdderTest {

    @Test
    public void add() {
        double DELTA = 0.0000001;
        assertEquals(2., Adder.add(1., 1.), DELTA);

        assertEquals(Double.MAX_VALUE, Adder.add(0., Double.MAX_VALUE), DELTA);

        assertEquals(2. * Double.MAX_VALUE, Adder.add(Double.MAX_VALUE, Double.MAX_VALUE), DELTA);
        assertTrue(Adder.add(Double.MAX_VALUE, Double.MAX_VALUE) > 0.);
    }
}