import java.util.HashSet;

public class SubStringWIthLargesVarianceFast {

    public static int largestVariance(String str) {

        HashSet<Character> set = new HashSet<>();
        for (char ch : str.toCharArray()) {
            set.add(ch);
        }
        // abcaab
        // now suppose we want to maximize a
        int ans = 0;
        for (char c1 = 'a'; c1 <= 'z'; c1++) {
            for (char c2 = 'a'; c2 <= 'z'; c2++) {
                if (!set.contains(c1) || !set.contains(c2) || c1 == c2) {
                    continue;
                }
                int tempMax = getMax(str, c1, c2);
                ans = Math.max(ans, tempMax);
            }
        }
        return ans;
    }

    public static int getMax(String str, char c1, char c2) {
        int ans = 0;
        int f1 = 0, f2 = 0;
        boolean past_c2 = false;
        for (char ch : str.toCharArray()) {
            if (ch == c1) {
                f1++;
            } else if (ch == c2) {
                past_c2 = true;
                f2++;
            }
            if (f2 != 0) {
                int diff = f1 - f2;
                ans = Math.max(ans, diff);
                if (diff < 0) {
                    f1 = 0;
                    f2 = 0;
                }
            } else if (past_c2) {
                ans = Math.max(ans, f1 - 1);
            }
        }
        return ans;
    }

}
