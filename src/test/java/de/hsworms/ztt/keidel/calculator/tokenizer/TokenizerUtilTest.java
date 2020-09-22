package de.hsworms.ztt.keidel.calculator.tokenizer;

import de.hsworms.ztt.keidel.calculator.tokenizer.TokenizerUtil;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class TokenizerUtilTest {

    @Test
    public void tokenize() throws IOException {

            assertEquals(
                    "[4.0, *, x, +, 5.2024, *, (, Log, (, x, ,, y, ), ^, z, ), -, 300.12]",
                    TokenizerUtil.tokenize("4*x+5.2024*(Log(x,y)^z)-300.12").toString());
            assertEquals(
                    "[4.0, *, x, +, 5.2024, *, (, Log, (, x, ,, y, ), ^, z, ), -, 300.12]",
                    TokenizerUtil.tokenize("4 * x + 5.2024 * (Log(x,y)^z) - 300.12").toString());
            assertEquals(
                    "[4.0, *, x, +, 5.2024, *, (, Log, (, x, ,, y, ), ^, z, ), -, 300.12]",
                    TokenizerUtil.tokenize("4   * x +   5.2024 *         " +
                            "(Log(x,y)^z) - 300.12").toString());
    }

    @Test
    public void tokenizeToTokenList() throws IOException {
        Token token = new Token("*");
        List<Token> tokens = TokenizerUtil.tokenizeToTokenList("*");
        assertEquals(token.getValue(), tokens.get(0).getValue());
        assertEquals(token.getOperator(), tokens.get(0).getOperator());
        assertEquals(token.getType(), tokens.get(0).getType());
    }
}