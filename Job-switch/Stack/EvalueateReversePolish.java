package Stack;

import java.util.Stack;

public class EvalueateReversePolish {

    public int evalRPN(String[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (String v : arr) {
            if (v.equals("+")) {
                int v1 = stack.pop();
                int v2 = stack.pop();
                stack.push(v1 + v2);
            } else if (v.equals("-")) {
                int v1 = stack.pop();
                int v2 = stack.pop();
                stack.push(v2 - v1);

            } else if (v.equals("*")) {
                int v1 = stack.pop();
                int v2 = stack.pop();
                stack.push(v2 * v1);

            } else if (v.equals("/")) {
                int v1 = stack.pop();
                int v2 = stack.pop();
                stack.push(v2 / v1);

            } else {
                stack.push(Integer.parseInt(v));
            }
        }
        return stack.peek();
    }

}
