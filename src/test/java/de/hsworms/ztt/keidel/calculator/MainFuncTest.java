package de.hsworms.ztt.keidel.calculator;

import de.hsworms.ztt.keidel.calculator.gui.fxml.MainWindowController;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class MainFuncTest {

    public static double DELTA = 1e-6;
    MainWindowController test = new MainWindowController();

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getCalculatorResult() throws IOException {
        assertEquals(0.,Main.getCalculatorResult("-1+1"),DELTA);
        assertEquals(0., Main.getCalculatorResult("1- (1*2) + 1"), DELTA);

        assertEquals(-5.,Main.getCalculatorResult("1*(5 - 10)"),DELTA);


    }
}