package problem13;

import java.util.Stack;

class Problem13 {

    private static final String ROMAN_NUMERAL_MODIFIERS = "IXC";
    private static final String ROMAN_NUMERALS_SMALL_TO_LARGE = "IVXLCDM";

    public static int romanToInt(String s) {

        Stack<String> numeralStack = new Stack<>();
        numeralStack = buildRomanNumeralStack(numeralStack, s);

        return tallyRomanNumeralStack(numeralStack);
    }

    public static Stack<String> buildRomanNumeralStack(Stack<String> stack,
                                                       String romanNumeral) {

        // Initialize Stack if null
        if (stack == null) {
            stack = new Stack<>();
        }

        // Recursion Check
        if (romanNumeral.length() >= 2) {

            char[] comparisonPair = romanNumeral.substring(0, 2).toCharArray();

            // Check for Leading Numeral Modifier
            if(ROMAN_NUMERAL_MODIFIERS.contains(String.valueOf(comparisonPair[0]))
                    && ROMAN_NUMERALS_SMALL_TO_LARGE.indexOf(String.valueOf(comparisonPair[0])) < ROMAN_NUMERALS_SMALL_TO_LARGE.indexOf(String.valueOf(comparisonPair[1]))) {

                // Push the Roman Numeral Pair
                stack.push(String.valueOf(comparisonPair));
                return buildRomanNumeralStack(stack, romanNumeral.substring(2));
            }
            // No Leading Modifier Found
            else {
                // Push the Singular Roman Numeral
                stack.push(String.valueOf(comparisonPair[0]));
                return buildRomanNumeralStack(stack, romanNumeral.substring(1));
            }
        }
        else if (romanNumeral.length() == 1) {
            stack.push(romanNumeral);
            return stack;
        }
        // Break recursion
        else {
            return stack;
        }
    }

    private static int convertRomanNumeral(char romanNumeralChar) {

        switch (romanNumeralChar) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    private static int tallyRomanNumeralStack(Stack<String> stack) {
        int total = 0;

        while (!stack.empty()) {

            String romanNumeral = stack.pop();
            if (romanNumeral.length() == 1) {
                total += convertRomanNumeral(romanNumeral.charAt(0));
            } else {
                total += convertRomanNumeral(romanNumeral.charAt(1)) - convertRomanNumeral(romanNumeral.charAt(0));
            }
        }

        return total;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
        System.out.println(romanToInt("DCXXI"));
    }
}