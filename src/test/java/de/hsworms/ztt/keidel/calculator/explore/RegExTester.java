package de.hsworms.ztt.keidel.calculator.explore;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RegExTester {



    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {

    }

    @Test
    public void testRegularExpressionResultTrue() {
        String inputStringWithoutCarrot = "TestStringHorribleLong 0000 <L>";
        Assert.assertTrue(inputStringWithoutCarrot.matches("^[^^]*$"));
    }

    @Test
    public void testRegularExpressionResultFalse() {
        String inputStringWithCarrot = "TestStringHorrible^Long 0000 <L>";
        Assert.assertFalse(inputStringWithCarrot.matches("^[^^]*$"));
    }
}
