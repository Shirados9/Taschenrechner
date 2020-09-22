package de.hsworms.ztt.keidel.calculator.tokenizer;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Source:
 * <a href="https://stackoverflow.com/questions/16498649/advanced-tokenizer-for-a-complex-math-expression">
 * Stackoverflow Stefan Haustein</a>
 */
public class TokenizerUtil {

    public static List<String> tokenize(String s) throws IOException {
        StreamTokenizer tokenizer = new StreamTokenizer(new StringReader(s));
        tokenizer.ordinaryChar('-');  // Don't parse minus as part of numbers.
        tokenizer.ordinaryChar('/');  // Don't treat slash as a comment start.
        List<String> tokBuf = new ArrayList<String>();
        while (tokenizer.nextToken() != StreamTokenizer.TT_EOF) {
            switch (tokenizer.ttype) {
                case StreamTokenizer.TT_NUMBER:
                    tokBuf.add(String.valueOf(tokenizer.nval));
                    break;
                case StreamTokenizer.TT_WORD:
                    tokBuf.add(tokenizer.sval);
                    break;
                default:  // operator
                    tokBuf.add(String.valueOf((char) tokenizer.ttype));
            }
        }
        return tokBuf;
    }

    public static List<Token> tokenizeToTokenList(String s) throws IOException {
        StreamTokenizer tokenizer = new StreamTokenizer(new StringReader(s));

        /* commented out so we can use "-" as an algebraic sign for numbers */
        //tokenizer.ordinaryChar('-');  // Don't parse minus as part of numbers.

        tokenizer.ordinaryChar('/');  // Don't treat slash as a comment start.
        List<Token> tokens = new ArrayList<Token>();
        while (tokenizer.nextToken() != StreamTokenizer.TT_EOF) {
            switch (tokenizer.ttype) {
                case StreamTokenizer.TT_NUMBER:
                    tokens.add(new Token(String.valueOf(tokenizer.nval)));
                    break;
                case StreamTokenizer.TT_WORD:
                    tokens.add(new Token(tokenizer.sval));
                    break;
                default:  // operator
                    tokens.add(new Token(String.valueOf((char) tokenizer.ttype)));
            }
        }
        return tokens;
    }
}
