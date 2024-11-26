package AALastGo.Stack;

public class BasicCalculator {

    public int calculate(String s) {
        idx = 0;
        // 1 + (4 - 2) - 1
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

}
