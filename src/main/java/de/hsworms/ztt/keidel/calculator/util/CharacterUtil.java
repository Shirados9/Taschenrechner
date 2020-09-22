package de.hsworms.ztt.keidel.calculator.util;

public class CharacterUtil {

     public static boolean isDigit(char input) {
         String inputString = Character.toString(input);
         return inputString.matches("[0-9]");
     }

     public static boolean isOperator(char input) {
         String inputString = Character.toString(input);
         return inputString.matches("[-+/*]");
     }
}
