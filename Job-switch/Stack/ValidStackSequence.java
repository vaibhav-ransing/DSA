package Stack;

import java.util.Stack;

public class ValidStackSequence {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int n = pushed.length;
        int i = 0, j = 0;
        while (i < n) {
            stack.push(pushed[i++]);
            while (stack.size() > 0 && stack.peek() == popped[j]) {
                j++;
                stack.pop();
            }
        }
        return stack.size() == 0;
    }
}