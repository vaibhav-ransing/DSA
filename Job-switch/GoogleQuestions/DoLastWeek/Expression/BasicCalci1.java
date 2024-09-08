package DoLastWeek.Expression;

import java.util.Stack;

public class BasicCalci1 {

    public int calculate(String str) {
        return rec(str);
    }

    int idx = 0;

    public int rec(String str) {

        int num = 0;
        int res = 0;
        int op = 1;

        while (idx < str.length()) {
            char ch = str.charAt(idx++);
            if (ch == '+' || ch == '-') {
                res += num * op;
                op = ch == '+' ? 1 : -1;
                num = 0;
            } else if (ch == '(') {
                num = rec(str);
            } else if (ch == ')') {
                // we need to return here becuse after this closing it's parent funciton will do
                // the rest of the oprations
                return res += num * op;
            } else if (ch >= '0' && ch <= '9') {
                num = num * 10 + (ch - '0');
            }
        }
        res += num * op;
        return res;
    }

}
