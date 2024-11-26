package AALastGo.Stack;

import java.util.Stack;

public class BasicCalci3 {

    static int idx = 0;

    public static int calci3(String str) {
        char prevOp = '+';
        int num = 0;
        Stack<Integer> stack = new Stack<>();
        while (idx < str.length()) {
            char ch = str.charAt(idx++);

            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');

            } else if (ch == '(') {
                num = calci3(str);

            } else if (ch == ')') {
                // return res
                break;

            } else if (idx == str.length() - 1 || ch != ' ') {
                if (ch == '+' || ch == '-') {
                    if (prevOp == '+') {
                        stack.push(num);
                    } else if (prevOp == '-') {
                        stack.push(-num);
                    } else if (prevOp == '*') {
                        stack.push(stack.pop() * num);
                    } else if (prevOp == '/') {
                        stack.push(stack.pop() / num);
                    }

                    prevOp = ch;
                    num = 0;
                }
            }

        }
        int res = 0;
        while (stack.size() > 0) {
            res += stack.pop();
        }
        return res;
    }
}
