package de.hsworms.ztt.keidel.calculator.util;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CharacterUtilTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void isDigit() {
        assertTrue(CharacterUtil.isDigit('1'));

        assertFalse(CharacterUtil.isDigit('*'));
    }

    @Test
    public void isOperator() {
        assertTrue(CharacterUtil.isOperator('*'));

        assertFalse(CharacterUtil.isOperator('1'));
    }

    @Test
    public void dotDoesnotWork() {
        assertFalse(CharacterUtil.isDigit('.'));

        assertFalse(CharacterUtil.isOperator('.'));
    }
}