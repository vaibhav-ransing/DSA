package Stack;

import java.util.Stack;

public class MinRemovalToMakeValidParanthesis {

    class Solution {

        public String minRemoveToMakeValid(String s) {
            boolean[] balanced = new boolean[s.length()];
            Stack<Integer> stack = new Stack<>();

            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (ch == '(') {
                    stack.push(i);
                } else if (ch == ')') {
                    if (stack.size() > 0) {
                        balanced[stack.pop()] = true;
                        balanced[i] = true;
                    } else {
                        balanced[i] = false;
                    }
                } else {
                    balanced[i] = true;
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (balanced[i]) {
                    sb.append(s.charAt(i));
                }
            }
            return sb.toString();
        }
    }
}