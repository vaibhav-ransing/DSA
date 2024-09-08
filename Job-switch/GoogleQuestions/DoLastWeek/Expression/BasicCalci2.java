package DoLastWeek.Expression;

import java.util.LinkedList;

public class BasicCalci2 {

    class Solution {
        public int calculate(String s) {
            int num = 0;
            char lastOp = '+'; // Track the last operator
            LinkedList<Integer> valueLL = new LinkedList<>();
    
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
    
                if (Character.isDigit(ch)) {
                    num = num * 10 + (ch - '0'); // Build the number
                }
    
                if (i == s.length() - 1 || (ch == '+' || ch == '-' || ch == '*' || ch == '/')) {
                    // Process the last operator when encountering a new one or the end of the string
                    if (lastOp == '+') {
                        valueLL.add(num);
                    } else if (lastOp == '-') {
                        valueLL.add(-num);
                    } else if (lastOp == '*') {
                        valueLL.add(valueLL.removeLast() * num);
                    } else if (lastOp == '/') {
                        valueLL.add(valueLL.removeLast() / num);
                    }
    
                    // Reset num and update lastOp
                    num = 0;
                    lastOp = ch;
                }
            }
    
            // Sum all the values in valueLL to get the final result
            int res = 0;
            for (int val : valueLL) {
                res += val;
            }
    
            return res;
        }
    }

    
    public static int calculate(String s) {
        int num = 0;
        LinkedList<Character> operators = new LinkedList<>();
        LinkedList<Integer> valueLL = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9') {
                num = num * 10 + (ch - '0');
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') { // +, -
                if (operators.size() > 0 && operators.getFirst() == '*') {
                    int v1 = valueLL.removeFirst();
                    operators.removeFirst(); // remove mult op
                    valueLL.addFirst(v1 * num);
                    num = 0;
                } else if (operators.size() > 0 && operators.getFirst() == '/') {
                    int v1 = valueLL.removeFirst();
                    operators.removeFirst(); // remove div op
                    valueLL.addFirst(v1 / num);
                    num = 0;
                } else {
                    valueLL.addFirst(num);
                    num = 0;
                }
                operators.addFirst(ch);
            }
        }
        valueLL.addFirst(num);
        System.out.println(operators.toString());
        System.out.println(valueLL.toString());

        while (operators.size() > 0) {
            char op = operators.removeLast();
            int early = valueLL.removeLast();
            int next = valueLL.removeLast();
            if (op == '+' || op == '-') {
                valueLL.addLast(early + next * (op == '-' ? -1 : 1));
            } else if(op == '*') {
                valueLL.add(early * next);
            } else if(op == '/'){
                valueLL.add(early / next);
            }
        }
        int res = valueLL.remove();
        System.out.println(res);
        return res;
    }

    public static void main(String[] args) {
        calculate("3/2*2");
        calculate("3*2/2+ 1");
    }
}
