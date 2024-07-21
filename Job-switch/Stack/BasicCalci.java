package Stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * BasicCalci
 */
public class BasicCalci {

    public int calculate(String s) {
        idx = 0;
        return rec(s);
    }

    int idx;

    public int rec(String s) {
        int num = 0;
        int res = 0;
        int op = 1;
        while (idx < s.length()) {
            char ch = s.charAt(idx++);

            if (ch == '+' || ch == '-') {
                res += (num * op);
                num = 0;
                op = ch == '+' ? 1 : -1;

            } else if (ch == '(') {
                num = rec(s);

            } else if (ch == ')') {
                return res + (num * op);

            } else if (ch >= '0' && ch <= '9') {
                num = num * 10 + Integer.parseInt(ch + "");
            }

        }
        res += num * op;
        return res;
    }

    class MySonlnSolution {
        public int calculate(String str) {
            String[] arr = str.split(" ");
            Stack<Integer> valStack = new Stack<>();
            Stack<String> opStack = new Stack<>();

            for (int i = 0; i < arr.length; i++) {
                String curr = arr[i].trim();

                if (curr.equals("+") || curr.equals("-")) {
                    opStack.push(curr);
                } else if (curr.equals("(")) {
                    opStack.push(curr);
                } else if (curr.equals(")")) {
                    while (true) {
                        String op = opStack.pop();
                        if (op.equals("("))
                            break;

                        // Correcting the way you pop and apply operations
                        int v1 = valStack.pop();
                        int v2 = valStack.pop();
                        if (op.equals("+")) {
                            valStack.push(v2 + v1); // Correctly apply addition
                        } else if (op.equals("-")) {
                            valStack.push(v2 - v1); // Correctly apply subtraction
                        }
                    }
                } else {
                    valStack.push(Integer.parseInt(curr));
                }
            }

            // Process remaining operators in the stack
            while (!opStack.isEmpty()) {
                String op = opStack.pop();
                int v1 = valStack.pop();
                int v2 = valStack.pop();
                if (op.equals("+")) {
                    valStack.push(v2 + v1); // Correctly apply addition
                } else if (op.equals("-")) {
                    valStack.push(v2 - v1); // Correctly apply subtraction
                }
            }

            return valStack.peek(); // Return the result
        }

        public static void main(String[] args) {
            Solution sol = new Solution();
            System.out.println(sol.calculate("1 + 1")); // Output: 2
            System.out.println(sol.calculate("2 - 1 + 2")); // Output: 3
            System.out.println(sol.calculate("(1 + (4 + 5 + 2) - 3) + (6 + 8))")); // Output: 23
        }
    }

}