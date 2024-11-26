package AALastGo.Stack;

import java.util.LinkedList;
import java.util.Stack;

public class BasciCalci2 {

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

}
