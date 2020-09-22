package de.hsworms.ztt.keidel.calculator.explorativecode;

import de.hsworms.ztt.keidel.calculator.util.CharacterUtil;

import java.util.Iterator;
import java.util.StringTokenizer;

public class Expression {

    private StringTokenizer stringTokenizer;
    private Token[] tokens;

    enum Type {
        LITERAL, OPERATOR
    }

    class Token {
        private String surface;
        private Type type;

        public Token(String surface, Type type) {
            this.surface = surface;
            this.type = type;
        }

        public String getSurface() {
            return surface;
        }

        public Type getType() {
            return type;
        }
    }

    public Expression(String input) {
        stringTokenizer = new StringTokenizer(input);
        evaluate();
    }

    private Token[] evaluate() {
        tokens = new Token[100];
        int counter = 0;
        while(stringTokenizer.hasMoreTokens()) {
            String item = stringTokenizer.nextToken();

            if(CharacterUtil.isDigit(item.charAt(0))) {
                tokens[counter] = new Token(item, Type.LITERAL);
                counter++;
            } else if(CharacterUtil.isOperator(item.charAt(0))) {
                tokens[counter] = new Token(item, Type.OPERATOR);
                counter++;
            } else {
                throw new IllegalStateException("expected [0-9] or [-+/*] but got " + item);
            }
        }
        return tokens;
    }

    public Iterator<Token> getIterator() {
        return new TokenIterator();
    }

    private class TokenIterator implements Iterator<Token> {

        private int counter = 0;

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return tokens[counter] != null;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws java.util.NoSuchElementException if the iteration has no more elements
         */
        @Override
        public Token next() {
            return tokens[counter++];
        }
    }
}
