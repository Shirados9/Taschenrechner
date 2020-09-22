package de.hsworms.ztt.keidel.calculator.gui.fxml;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlotWindowControllerTest {

    @Test
    public void xToStringConverter() {
        PlotWindowController test = new PlotWindowController();


        String infix = "5.0+-x";
        assertEquals("5.0+ -2.0", test.xToStringConverter(infix.split(""), 2.0));

        infix = "x";
        assertEquals("2.0", test.xToStringConverter(infix.split(""), 2.0));

        infix = "-x";
        assertEquals("2.0", test.xToStringConverter(infix.split(""), -2.0));

        infix = "5.0-x";
        assertEquals("5.0 - 2.0", test.xToStringConverter(infix.split(""), 2.0));

        infix = "5.0 - x";
        assertEquals("5.0 - 2.0", test.xToStringConverter(infix.split(""), 2.0));

        infix = "5.0--x";
        assertEquals("5.0- -2.0", test.xToStringConverter(infix.split(""), 2.0));
    }

}