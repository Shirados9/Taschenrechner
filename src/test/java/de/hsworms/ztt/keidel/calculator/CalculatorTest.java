package de.hsworms.ztt.keidel.calculator;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class CalculatorTest {

    private static final double DELTA = 0.0000001;

    @Test
    public void getResult() throws IOException {
        assertEquals(2.0, Calculator.getResult("(1+1)"), DELTA);
        assertEquals(4.0, Calculator.getResult("(1+1)*2"), DELTA);
        assertEquals(2.0, Calculator.getResult("(1+1)*(2 - 1)"), DELTA);
        assertEquals(121.0, Calculator.getResult("(120+1)*(2 - 1)"), DELTA);
        assertEquals(121.0, Calculator.getResult("(120+1)/(2 - 1)"), DELTA);
        assertEquals(12.0, Calculator.getResult("((120+1) - 1)/(11 - 1)"), DELTA);
        assertEquals(0., Calculator.getResult("(   1 - 1)"), DELTA);
        assertEquals(-1.0, Calculator.getResult("(   1 - 2)"), DELTA);
        assertEquals(-1.0, Calculator.getResult("(   1.1 - 2.1)"), DELTA);
        assertEquals(0.5, Calculator.getResult("(   1.0 / 2.0)"), DELTA);
        assertEquals(3.0, Calculator.getResult("1 + 1 * 2"), DELTA);
        assertEquals(2.0, Calculator.getResult("1 + 1 * 2 / 2"), DELTA);
        assertEquals(3.0, Calculator.getResult("1 + 1 * 2 / 2 + 1"), DELTA);

        // Praktikum task: Modulo
        assertEquals(0., Calculator.getResult("2 % 2"), DELTA);
        assertEquals(1., Calculator.getResult("1 % 2"), DELTA);
        assertEquals(0., Calculator.getResult("0 % 2"), DELTA);
        assertEquals(2., Calculator.getResult("1 + 1 % 2"), DELTA);
        assertEquals(0., Calculator.getResult("(1 + 1) % 2"), DELTA);
        assertEquals(0., Calculator.getResult("(1 + 1) % (1 + 1)"), DELTA);
        assertEquals(0., Calculator.getResult("(1023 + 1) % (1 + 1)"), DELTA);

        //Calculator tests for Power
        assertEquals(4., Calculator.getResult("2 ^ 2"), DELTA);
        assertEquals(2., Calculator.getResult("4 ^(1/2)"), DELTA); //same as sqrt
        assertEquals(16., Calculator.getResult(" ( 2 + 2 )^2"), DELTA);
        assertEquals(16., Calculator.getResult("(2 + 2) ^ (1 + 1)"), DELTA);
        assertEquals(5., Calculator.getResult("2^2 + 1"), DELTA);


        //Calculator tests for Faculty
        assertEquals(24., Calculator.getResult("fac(4)"), DELTA);
        assertEquals(25., Calculator.getResult("fac(4) + 1"), DELTA);
        assertEquals(25., Calculator.getResult("1+ fac(4)"), DELTA);
        assertEquals(6., Calculator.getResult("fac(69/23)"),DELTA);

        //Calculator tests for sine
        assertEquals(0.,Calculator.getResult("sin(0)"),DELTA);
        assertEquals(0.8414709848,Calculator.getResult("sin(1)"),DELTA);
        assertEquals(1.8414709848,Calculator.getResult("sin(1) + 1 "),DELTA);
        assertEquals(1.8414709848,Calculator.getResult("1 + sin(1) "),DELTA);
        assertEquals(12.8096519217, Calculator.getResult("5+8*sin(5*6)^2"),DELTA);

        //Calculator tests for cosine
        assertEquals(1.,Calculator.getResult("cos(0)"),DELTA);
        assertEquals(0.54030230586,Calculator.getResult("cos(1)"),DELTA);
        assertEquals(1.54030230586,Calculator.getResult("cos(1) + 1 "),DELTA);
        assertEquals(1.54030230586,Calculator.getResult("1 + cos(1) "),DELTA);
        assertEquals(5.19034807834, Calculator.getResult("5+8*cos(5*6)^2"),DELTA);

        //Calculator tests for tan
        assertEquals(0.,Calculator.getResult("tan(0)"),DELTA);
        assertEquals(1.55740772465,Calculator.getResult("tan(1)"),DELTA);
        assertEquals(2.55740772465,Calculator.getResult("tan(1) + 1 "),DELTA);
        assertEquals(2.55740772465,Calculator.getResult("1 + tan(1) "),DELTA);
        assertEquals(333.22614191, Calculator.getResult("5+8*tan(5*6)^2"),DELTA);

        //Calculator test for Square root
        assertEquals(3.,Calculator.getResult("sqrt(9)"),DELTA);
        assertEquals(2.2360679775,Calculator.getResult("sqrt(5)"),DELTA);
        assertEquals(5.,Calculator.getResult("1+sqrt(9)+1"),DELTA);
        assertEquals(14.4714277063,Calculator.getResult("sqrt(58)+sqrt(47)"),DELTA);
        assertEquals(9604.,Calculator.getResult("(25 * sqrt(36) - 52)^2"),DELTA);

        //Calculator test for natural logarithm
        assertEquals(2.07944154168,Calculator.getResult("ln(8)"),DELTA);
        assertEquals(1., Calculator.getResult("ln(e)"),DELTA);
        assertEquals(2., Calculator.getResult("ln(e) + 1"),DELTA);
        assertEquals(2., Calculator.getResult("1 + ln(e)"),DELTA);
        assertEquals(5.99568683158, Calculator.getResult("5*ln(4)-ln(7)/ln(8)"),DELTA);


        //Calculator test for logarithm with base 10
        assertEquals(1.,Calculator.getResult("log(10)"),DELTA);
        assertEquals(0.69897000433, Calculator.getResult("log(5)"),DELTA);
        assertEquals(0., Calculator.getResult("log(log(10))"),DELTA);
        assertEquals(1.69897000433, Calculator.getResult("1 + log(5)"),DELTA);
        assertEquals(0.31794671576, Calculator.getResult("log(ln(8))"),DELTA);


        //Calculator test for π (pi)
        assertEquals(Math.PI,Calculator.getResult("\u03C0"),DELTA);
        assertEquals(1.,Calculator.getResult("\u03C0/\u03C0"),DELTA);
        assertEquals(Math.PI, Calculator.getResult("sqrt(\u03C0^2)"),DELTA);

        //Calculator test for e
        assertEquals(Math.exp(1.),Calculator.getResult("e"),DELTA);
        assertEquals(1.,Calculator.getResult("e/e"),DELTA);
        assertEquals(Math.exp(1.), Calculator.getResult("sqrt(e^2)"),DELTA);


        //tests for minus as operator and sign
        assertEquals(5.,Calculator.getResult("10 + -5"),DELTA);
        assertEquals(15.,Calculator.getResult("10 - -5"),DELTA);
        assertEquals(-25.,Calculator.getResult("5 * -5"),DELTA);
        assertEquals(-0.8414709848,Calculator.getResult("sin(-1)"),DELTA);
        assertEquals(1.,Calculator.getResult("1^-5"),DELTA);
        assertEquals(-0.95892427466,Calculator.getResult("sin(\u03C0 + -5)"),DELTA);
        assertEquals(0.95892427466,Calculator.getResult("sin(-5)"),DELTA);

    }
}