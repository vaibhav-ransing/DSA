package GoogleQuestions;

import java.util.Stack;

public class EquationValidator {

    public static boolean validateEquation(String equation) {
        if (equation == null || equation.isEmpty()) {
            return false;
        }

        int equalSignIndex = equation.indexOf('=');
        if (equalSignIndex == -1 || equalSignIndex == equation.length() - 1) {
            return false; // No '=' sign or no RHS
        }

        String lhs = equation.substring(0, equalSignIndex).trim();
        String rhs = equation.substring(equalSignIndex + 1).trim();

        return validateSide(lhs) && validateSide(rhs);
    }

    private static boolean validateSide(String side) {
        if (side.isEmpty()) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        boolean expectOperand = true; // We should start with an operand (a-z or '(')
        boolean lastWasOperator = false;

        for (int i = 0; i < side.length(); i++) {
            char c = side.charAt(i);

            if (c >= 'a' && c <= 'z') {
                if (!expectOperand) {
                    return false;
                }
                expectOperand = false;
                lastWasOperator = false;
            } else if (c == '+' || c == '-') {
                if (expectOperand || lastWasOperator) {
                    return false; // Operators cannot be at the beginning or follow another operator
                }
                expectOperand = true;
                lastWasOperator = true;
            } else if (c == '(') {
                stack.push(c);
                expectOperand = true;
                lastWasOperator = false;
            } else if (c == ')') {
                if (expectOperand || stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
                expectOperand = false;
                lastWasOperator = false;
            } else {
                return false; // Invalid character
            }
        }

        return stack.isEmpty() && !expectOperand && !lastWasOperator;
    }

    public static void main(String[] args) {
        String[] testCases = {
                "a + x = b + (c + a)", // Valid
                "a + x =", // Invalid
                "a + -x = a + b", // Invalid
                "a + b = c - (d + e)", // Valid
                "a + b + = c + d", // Invalid
                "a + (b = c)" // Invalid
        };

        for (String testCase : testCases) {
            System.out.println("Equation: " + testCase + " is " + (validateEquation(testCase) ? "Valid" : "Invalid"));
        }
    }
}
