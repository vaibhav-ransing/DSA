package DoLastWeek.Expression;

import java.util.Stack;

public class BasicCalci3 {

    static int idx = 0;

    public static int calci3(String str) {
        Stack<Integer> stack = new Stack<>();
        char op = '+';
        int num = 0;

        while (idx < str.length()) {
            char ch = str.charAt(idx++);

            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }

            if (ch == '(') {
                num = calci3(str); // Recursive call for sub-expression in parentheses
            }

            if (ch == ')' || (!Character.isDigit(ch) && ch != ' ' && ch != '(') || idx == str.length()) {
                // Apply the previous operator
                if (op == '+') {
                    stack.push(num);
                } else if (op == '-') {
                    stack.push(-num);
                } else if (op == '*') {
                    stack.push(stack.pop() * num);
                }

                // we can break also here because outter res will be same as insite
                if (ch == ')') { // go to parent call
                    // break; // this too works
                    int res = 0;
                    while (!stack.isEmpty()) {
                        res += stack.pop();
                    }
                    System.out.println(res);
                    return res;
                }

                // Update the operator and reset the number
                op = ch;
                num = 0;
            }
        }

        // Sum up all the values in the stack
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        System.out.println(res);
        return res;
    }

    public static int calci2(String str) {
        Stack<Integer> stack = new Stack<>();
        char op = '+';
        int num = 0;

        for (int i = 0; i <= str.length(); i++) {
            char ch = i < str.length() ? str.charAt(i) : '+'; // Evaluate after last char
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }

            if (!Character.isDigit(ch) && ch != ' ' || i == str.length() - 1) {
                if (op == '+') {
                    stack.push(num);
                } else if (op == '-') {
                    stack.push(-num);
                } else if (op == '*') {
                    stack.push(stack.pop() * num);
                }
                // Reset the operation and number for next
                op = ch;
                num = 0;
            }
        }

        // Sum up all the values in the stack
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        System.out.println(res);
        return res;
    }

    public static void main(String[] args) {
        calci3("(5 + 5) * 4 - 10");
    }
}
