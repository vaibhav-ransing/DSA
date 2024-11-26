package AALastGo.Stack;

import java.util.Stack;

public class ValidateMathExpression {
    // "(2 + 3) * (4 + 5)" -> True
    // "((a + b) - (c - d) / (e + f))" -> True
    // "7(9)" -> False
    // "(2 + a) - (b + 4) * ((c - d + 66))" -> True

    public static boolean isValidExpression(String str) {
        Stack<Character> stack = new Stack<>();
        boolean lastWasOperator = true; // Tracks if the last non-space character was an operator
        boolean lastWasOpeningParen = false; // Tracks if the last character was an opening parenthesis

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // Ignore spaces
            if (ch == ' ')
                continue;

            // Check if character is an opening parenthesis
            if (ch == '(') {
                stack.push(ch);
                lastWasOperator = true; // Expect a number or opening parenthesis next
                lastWasOpeningParen = true;
            }
            // Check if character is a closing parenthesis
            else if (ch == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false; // Unmatched closing parenthesis
                }
                lastWasOperator = false; // Closing parenthesis can be followed by an operator
                lastWasOpeningParen = false;
            }
            // Check if character is a digit or variable (consider lowercase variables)
            else if (Character.isDigit(ch) || (ch >= 'a' && ch <= 'z')) {
                // Ensure no direct number followed by an opening parenthesis, e.g., 7(9)
                if (!lastWasOperator && lastWasOpeningParen) {
                    return false;
                }
                lastWasOperator = false; // Number or variable means an operator should come next
                lastWasOpeningParen = false;
            }
            // Check if character is a valid operator
            else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                // Ensure an operator is not at the start or not directly after another operator
                if (lastWasOperator || lastWasOpeningParen) {
                    return false;
                }
                lastWasOperator = true; // Expect a number or opening parenthesis next
            }
            // Invalid character found
            else {
                return false;
            }
        }

        // At the end, the stack should be empty (all parentheses matched), and the last
        // character shouldn't be an operator
        return stack.isEmpty() && !lastWasOperator;
    }

    public static void main(String[] args) {
        System.out.println(isValidExpression("(2 + 3) * (4 + 5)")); // True
        System.out.println(isValidExpression("((a + b) - (c - d) / (e + f))")); // True
        System.out.println(isValidExpression("7(9)")); // False
        System.out.println(isValidExpression("(2 + a) - (b + 4) * ((c - d + 66))")); // True
    }
}
