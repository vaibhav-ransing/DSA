import java.util.*;

public class Solution {

    public String reverseParentheses(String s) {

        Stack<String> stack = new Stack<>();
        int prev = -1;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(s.substring(prev + 1, i));
                prev = i + 1;
            } else if (ch == ')') {
                String curr = stack.peek() + s.substring(prev + 1, i);
                String reverse = new StringBuilder(curr).reverse().toString();
                stack.pop();
                
            }
        }
    }

}