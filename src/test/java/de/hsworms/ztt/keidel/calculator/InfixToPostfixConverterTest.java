package de.hsworms.ztt.keidel.calculator;

import de.hsworms.ztt.keidel.calculator.tokenizer.Token;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class InfixToPostfixConverterTest {

    @Test
    public void toPostfix() {
        assertEquals("1 2 3 4 - * + ", InfixToPostfixConverter.toPostfix("1 + 2 * ( 3 - 4 )"));
    }

    @Test
    public void toPostfixListOfToken() throws IOException {
        List<Token> tokens = InfixToPostfixConverter.toPostfixListOfToken("11* 22");
        assertEquals("11.0", tokens.get(0).getValue());
        assertEquals("22.0", tokens.get(1).getValue());
        assertEquals(Token.Operator.MULTIPLY, tokens.get(2).getOperator());

        tokens = InfixToPostfixConverter.toPostfixListOfToken("11* (22 + 1)");
        // 11 22 1 + *
        assertEquals("11.0", tokens.get(0).getValue());
        assertEquals("22.0", tokens.get(1).getValue());
        assertEquals("1.0", tokens.get(2).getValue());
        assertEquals(Token.Operator.ADD, tokens.get(3).getOperator());
        assertEquals(Token.Operator.MULTIPLY, tokens.get(4).getOperator());

        // 5 -8 +

        tokens = InfixToPostfixConverter.toPostfixListOfToken("5 + -8");
        assertEquals("5.0",tokens.get(0).getValue());
        assertEquals("-8.0", tokens.get(1).getValue());
        assertEquals(Token.Operator.ADD, tokens.get(2).getOperator());



    }
}