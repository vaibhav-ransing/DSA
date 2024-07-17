package GoogleQuestions;

import java.util.Stack;

// Validate if the equation is syntactically correct.

// Valid operators: +, -, a-z, (, )
// Test cases:
// Valid - a + x = b + (c + a)
// Invalid - a + x = (ending with =; doesn't have RHS)
// Invalid - a + - x = a + b (- in -x is a unary operator)

public class StackValidator {
    // b + (c + a - d)
    public boolean solve(String str) {
        Stack<Character> characters = new Stack<>(); // b c a d
        Stack<Character> operators = new Stack<>(); //  + ( + - 

        for (char ch : str.toCharArray()) {
            if (ch == ' ')
                continue;
            if (ch == '-' || ch == '+') {

            } else if (ch == '(') {

            } else if (ch == ')') {

            } else {

            }
        }

        return true;
    }
}
