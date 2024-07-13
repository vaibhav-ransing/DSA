import java.util.Stack;

public class maxScoreAfterRemovingSubstring {

    public int maximumGain(String s, int x, int y) { // ab ba
        String big = x > y ? "ab" : "ba";
        String sml = x > y ? "ba" : "ab";

        int ans = 0;
        Pair p = stackHelper(s, big, x > y ? x : y);
        ans += p.val;
        Pair p2 = stackHelper(p.rem, sml, x > y ? y : x);
        ans += p2.val;
        return ans;
    }

    class Pair {
        int val;
        String rem;

        Pair(String str, int val) {
            this.rem = str;
            this.val = val;
        }
    }

    public Pair stackHelper(String str, String subs, int val) {
        Stack<Character> stack = new Stack<>();
        int ans = 0;
        for (char ch : str.toCharArray()) {
            if (stack.size() > 0 && stack.peek() == subs.charAt(0) && ch == subs.charAt(1)) {
                ans += val;
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (stack.size() > 0) {
            sb.append(stack.pop());
        }
        String rem = sb.reverse().toString();
        return new Pair(rem, ans);
    }

    public int maximumGain2(String s, int x, int y) {
        return rec(s, x, y);
    }

    public int rec(String str, int x, int y) {

        int ans = 0;
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == 'a' && str.charAt(i + 1) == 'b') {
                ans = Math.max(ans, x + rec(str.substring(0, i) + str.substring(i + 2), x, y));
            } else if (str.charAt(i) == 'b' && str.charAt(i + 1) == 'a') {
                ans = Math.max(ans, y + rec(str.substring(0, i) + str.substring(i + 2), x, y));
            }
        }
        return ans;
    }
}
