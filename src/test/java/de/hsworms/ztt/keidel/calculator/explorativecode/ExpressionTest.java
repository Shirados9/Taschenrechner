package de.hsworms.ztt.keidel.calculator.explorativecode;

import de.hsworms.ztt.keidel.calculator.explorativecode.Expression;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class ExpressionTest {

    private Expression expression;
    private static final String TEST_INPUT = "1 + 2 + 3";

    @Before
    public void setUp() throws Exception {
        expression = new Expression(TEST_INPUT);
    }

    @After
    public void tearDown() throws Exception {
        expression = null;
    }

    @Test
    public void evaluate() {
        // Note: this is not an example how to use the Iterator Interface!!!
        Iterator<Expression.Token> tokenIterator = expression.getIterator();
        assertEquals(Expression.Type.LITERAL, tokenIterator.next().getType());
        assertEquals(Expression.Type.OPERATOR, tokenIterator.next().getType());
        assertEquals(Expression.Type.LITERAL, tokenIterator.next().getType());
        assertEquals(Expression.Type.OPERATOR, tokenIterator.next().getType());
        assertEquals(Expression.Type.LITERAL, tokenIterator.next().getType());
    }

    @Test
    public void testIteratorNotNull() {
        Iterator<Expression.Token> tokenIterator = expression.getIterator();
        assertNotNull(tokenIterator);
    }

    @Test
    public void testIterator() {
        Iterator<Expression.Token> tokenIterator = expression.getIterator();
        int counter = 0;
        while(tokenIterator.hasNext()) {
            tokenIterator.next();
            counter++;
        }
        assertEquals(5, counter);
    }
}