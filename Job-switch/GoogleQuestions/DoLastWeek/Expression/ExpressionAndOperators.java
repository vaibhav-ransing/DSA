package DoLastWeek.Expression;

import java.util.*;

public class ExpressionAndOperators {

    public List<String> addOperators(String str, int target) {
        tgt = target;
        rec(0, str, "");
        return ans;
    }

    char[] operations = new char[] { '+', '-', '*' };
    List<String> ans = new ArrayList<>();
    int tgt;
    
    // create all the possible combinartion of substrings with given operators in between and then check if it form target
    public void rec(int idx, String str, String currStr) {
        if (idx == str.length()) {
            if (calculate(currStr) == tgt) {
                ans.add(currStr);
            }
            return;
        }

        // try all the possible substring 
        for (int i = idx; i < str.length(); i++) {
            String substr = str.substring(idx, i + 1);
            if (substr.length() > 1 && substr.charAt(0) == '0') {
                break; // no need to check further, because adding more digits to a leading '0' is
                       // invalid
            }
            // if there is no curr means the string has not started and curr substr will be the first one so no operator comes in
            if (currStr.length() == 0) {
                rec(i + 1, str, substr);
            } else {
                // currStr is already there so we try all operators and add substr ahead of it.
                for (char op : operations) {
                    rec(i + 1, str, currStr + op + substr);
                }
            }
        }
    }

    // Basic calculator 2 exact same just no need of divisor
    public static int calculate(String s) {
        int num = 0;
        char lastOp = '+'; // Track the last operator
        LinkedList<Integer> valueLL = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0'); // Build the number
            }

            if (i == s.length() - 1 || (ch == '+' || ch == '-' || ch == '*' || ch == '/')) {
                // Process the last operator when encountering a new one or the end of the
                // string
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

    public static void main(String[] args) {
        // String str = "2*3+2";
        // String str = "2-3-4+1";
        String str = "1*2*3";
        calculate(str);
    }
}