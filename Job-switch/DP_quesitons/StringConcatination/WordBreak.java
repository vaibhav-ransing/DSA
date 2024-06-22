package StringConcatination;

import java.util.*;

public class WordBreak {

    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            HashSet<String> set = new HashSet<>();
            for (String word : wordDict) {
                set.add(word);
            }
            int dp[] = new int[s.length()];
            Arrays.fill(dp, -1);
            return helper(s, 0, set, dp);
        }

        public boolean helper(String str, int idx, HashSet<String> set, int dp[]) {

            if (idx == str.length() || set.contains(str)) {
                return true;
            }
            if (dp[idx] != -1)
                return dp[idx] == 1;
            boolean ans = false;
            for (int i = idx; i < str.length(); i++) {

                String temp = str.substring(idx, i + 1);
                if (set.contains(temp)) {
                    ans |= helper(str, i + 1, set, dp);
                }
            }
            dp[idx] = ans ? 1 : 0;
            return ans;
        }
    }
}