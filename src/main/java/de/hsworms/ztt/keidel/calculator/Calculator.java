package de.hsworms.ztt.keidel.calculator;

import de.hsworms.ztt.keidel.calculator.InfixToPostfixConverter;
import de.hsworms.ztt.keidel.calculator.tokenizer.Token;
import de.hsworms.ztt.keidel.calculator.tokenizer.TokenizerUtil;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;
import java.util.Stack;
import java.util.stream.LongStream;

/**
 * For an idea how it works:
 * <a href="https://en.wikipedia.org/wiki/Reverse_Polish_notation">
 * Wikipedia: Reverse Polish notation (left-to-right algorithm)</a>
 */
public class Calculator {
    //Implementation for Factorial to use in Calculator
    static public int calcFactorial(int n) {
        if (n <= 2) {
            return n;
        }
        return n * calcFactorial(n - 1);
    }

    public static double getResult(String infix) throws IOException {
        Stack<Token> tokenStack = new Stack<>();
        List<Token> tokenList = InfixToPostfixConverter.toPostfixListOfToken(infix);
        for (Token token : tokenList) {
            switch (token.getType()) {
                case LITERAL:
                    tokenStack.push(token);
                    break;
                case OPERATOR:
                    double operandB = Double.parseDouble(tokenStack.pop().getValue());
                    double operandA = Double.parseDouble(tokenStack.pop().getValue());
                    switch (token.getOperator()) {
                        case ADD:
                            tokenStack.push(new Token(String.valueOf(operandA + operandB)));
                            break;
                        case SUBTRACT:
                            tokenStack.push(new Token(String.valueOf(operandA - operandB)));
                            break;
                        case MULTIPLY:
                            tokenStack.push(new Token(String.valueOf(operandA * operandB)));
                            break;
                        case DIVIDE:
                            tokenStack.push(new Token(String.valueOf(operandA / operandB)));
                            break;
                        case MODULO:
                            tokenStack.push(new Token(String.valueOf(operandA % operandB)));
                            break;
                        case POWER:
                            tokenStack.push(new Token(String.valueOf(Math.pow(operandA,operandB))));
                            break;
                        default:
                            throw new IllegalStateException("Programing Error! Implement: " + token.getOperator());
                    }
                    break;
                case FUNCTION:
                    double operand = Double.parseDouble(tokenStack.pop().getValue());
                    switch(token.getFunction()) {
                        case FAC:
                            tokenStack.push(new Token(String.valueOf(calcFactorial((int)operand))));
                            break;
                        case SIN:
                            tokenStack.push(new Token(String.valueOf(Math.sin(operand))));
                            break;
                        case COS:
                            tokenStack.push(new Token(String.valueOf(Math.cos(operand))));
                            break;
                        case TAN:
                            tokenStack.push(new Token(String.valueOf(Math.tan(operand))));
                            break;
                        case SQRT:
                            tokenStack.push(new Token(String.valueOf(Math.sqrt(operand))));
                            break;
                        case NLOG:
                            tokenStack.push(new Token(String.valueOf(Math.log(operand))));
                            break;
                        case LOG:
                            tokenStack.push(new Token(String.valueOf(Math.log10(operand))));
                            break;
                        default:
                            throw new IllegalStateException("Programing Error! Implement: " + token.getFunction());
                    }
                    break;
                default:
                    throw new IllegalStateException("Programing Error! Implement: " + token.getType());
            }
        }
        return Double.valueOf(tokenStack.pop().getValue());
    }
}
