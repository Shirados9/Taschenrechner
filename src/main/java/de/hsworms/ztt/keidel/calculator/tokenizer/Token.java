package de.hsworms.ztt.keidel.calculator.tokenizer;


import de.hsworms.ztt.keidel.calculator.InfixToPostfixConverter;

import java.util.HashMap;
import java.util.Map;

public class Token {

    public enum Type {
        LITERAL, OPERATOR, LEFT_BRACKET, RIGHT_BRACKET, NOT_DETERMINED, FUNCTION, CONSTANT, WHITESPACE
    }

    /**
     * For information about Infix Preferences see
     * <a href="https://en.wikipedia.org/wiki/Order_of_operations">
     * https://en.wikipedia.org/wiki/Order_of_operations</a>
     */
    public enum Operator {
        ADD(1), SUBTRACT(1), MULTIPLY(2), DIVIDE(2), MODULO(2), POWER(3);
        public final int precedence;

        Operator(int p) {
            precedence = p;
        }
    }

    public enum Function {
        SIN(4), COS(4), TAN(4), FAC(4), SQRT(4), NLOG(4), LOG(4) ;
        public final int precedence;

        Function(int p) { precedence = p;}
    }

    public enum Constant {
        e, π
    }
    public static Map<String, Token.Operator> ops = new HashMap<String, Operator>() {{
        put("+", Token.Operator.ADD);
        put("-", Token.Operator.SUBTRACT);
        put("*", Token.Operator.MULTIPLY);
        put("/", Token.Operator.DIVIDE);
        put("%", Operator.MODULO);
        put("^", Operator.POWER);
    }};

    /* Map for all implemented functions */
    public static Map<String, Token.Function> fnc = new HashMap<String, Function>() {{
        put("sin", Function.SIN);
        put("fac",Function.FAC);
        put("cos",Function.COS);
        put("tan",Function.TAN);
        put("sqrt",Function.SQRT);
        put("ln",Function.NLOG);
        put("log",Function.LOG);
    }};
    /* Map for implemented Constants */
    public static Map<String, Token.Constant> con = new HashMap<String, Constant>() {{
       put("e", Constant.e);
       put("\u03C0", Constant.π);
    }};
    private Type type = Type.NOT_DETERMINED;
    private String value;

    private Operator operator = null;
    private Function function = null;
    private Constant constant = null;

    /**
     * Evaluates input String on the fly.
     *
     * @param value Input String for Token constructor
     */
    public Token(String value) {
        if (value.equalsIgnoreCase("(")) {
            type = Type.LEFT_BRACKET;
        } else if (value.equalsIgnoreCase(")")) {
            type = Type.RIGHT_BRACKET;

            /* Swapped order of LITERAL to recognize negative numbers */
        } else if (value.matches("-?[0-9.]+")) {
            type = Type.LITERAL;

        } else if (value.matches("[-+*/%^]")) {
            type = Type.OPERATOR;
            operator = ops.get(value);

        } else if (value.matches("fac|sin|tan|cos|sqrt|ln|log")) {
            type = Type.FUNCTION;
            function = fnc.get(value);

            /* Matches of constant, PI is in unicode so we could use it for the GUI */
        }else if (value.matches("e|\u03C0")) {
            type = Type.CONSTANT;
            constant = con.get(value);
        } else if(value.matches(" ")) {
            type = Type.WHITESPACE;
        } else {
            throw new IllegalStateException("Programing Error! Implement: " + value);
        }
        this.value = value;
    }

    boolean isOperator() {
        return operator != null;
    }

    boolean isFunction() {
        return function != null;
    }

    boolean isConstant() {return constant != null;}

    public Operator getOperator() {
        return operator;
    }

    public String getValue() {
        return value;
    }

    public Type getType() {
        return type;
    }

    public Function getFunction() {
        return function;
    }

    public Constant getConstant() {return constant;}
}
