package de.hsworms.ztt.keidel.calculator.tokenizer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TokenTest {

    @Test
    public void testToken() {
        Token token = new Token("(");
        assertEquals("(", token.getValue());
        assertFalse(token.isOperator());
        assertEquals(Token.Type.LEFT_BRACKET, token.getType());

        token = new Token(")");
        assertEquals(")", token.getValue());
        assertFalse(token.isOperator());
        assertEquals(Token.Type.RIGHT_BRACKET, token.getType());

        token = new Token("-");
        assertEquals("-", token.getValue());
        assertTrue(token.isOperator());
        assertEquals(Token.Type.OPERATOR, token.getType());
        assertEquals(Token.Operator.SUBTRACT, token.getOperator());

        token = new Token("*");
        assertEquals("*", token.getValue());
        assertTrue(token.isOperator());
        assertEquals(Token.Type.OPERATOR, token.getType());
        assertEquals(Token.Operator.MULTIPLY, token.getOperator());

        token = new Token("-1");
        assertEquals("-1", token.getValue());
        assertFalse(token.isOperator());
        assertEquals(Token.Type.LITERAL, token.getType());

        //tests for Power Operator
        token = new Token("^");
        assertEquals("^", token.getValue());
        assertTrue(token.isOperator());
        assertEquals(Token.Type.OPERATOR,token.getType());
        assertEquals(Token.Operator.POWER,token.getOperator());


        //tests for faculty Function

        token = new Token("fac");
        assertEquals("fac", token.getValue());
        assertTrue(token.isFunction());
        assertEquals(Token.Type.FUNCTION, token.getType() );
        assertEquals(Token.Function.FAC, token.getFunction());


        //tests for sine function

        token = new Token("sin");
        assertEquals("sin", token.getValue());
        assertTrue(token.isFunction());
        assertEquals(Token.Type.FUNCTION, token.getType() );
        assertEquals(Token.Function.SIN, token.getFunction());

        //tests for cosine function
        token = new Token("cos");
        assertEquals("cos", token.getValue());
        assertTrue(token.isFunction());
        assertEquals(Token.Type.FUNCTION, token.getType() );
        assertEquals(Token.Function.COS, token.getFunction());

        //tests for tangent function
        token = new Token("tan");
        assertEquals("tan", token.getValue());
        assertTrue(token.isFunction());
        assertEquals(Token.Type.FUNCTION, token.getType() );
        assertEquals(Token.Function.TAN, token.getFunction());

        //tests for square root function
        token = new Token("sqrt");
        assertEquals("sqrt", token.getValue());
        assertTrue(token.isFunction());
        assertEquals(Token.Type.FUNCTION, token.getType() );
        assertEquals(Token.Function.SQRT, token.getFunction());

        //tests for natural logarithm function
        token = new Token("ln");
        assertEquals("ln", token.getValue());
        assertTrue(token.isFunction());
        assertEquals(Token.Type.FUNCTION, token.getType() );
        assertEquals(Token.Function.NLOG, token.getFunction());

        //test for logarithm with base 10

        token = new Token("log");
        assertEquals("log", token.getValue());
        assertTrue(token.isFunction());
        assertEquals(Token.Type.FUNCTION, token.getType() );
        assertEquals(Token.Function.LOG, token.getFunction());




        //tests for Constant
        //π
        token = new Token("\u03C0");
        assertEquals("\u03C0", token.getValue());
        assertTrue(token.isConstant());
        assertEquals(Token.Type.CONSTANT, token.getType() );
        assertEquals(Token.Constant.π, token.getConstant());

        //e
        token = new Token("e");
        assertEquals("e", token.getValue());
        assertTrue(token.isConstant());
        assertEquals(Token.Type.CONSTANT, token.getType() );
        assertEquals(Token.Constant.e, token.getConstant());
    }
}