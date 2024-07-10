package PickNotPick;

import java.util.Arrays;
import java.util.HashSet;

public class ExtraCharactersInString {
    int[] dp;

    public int minExtraChar(String s, String[] dictionary) {
        dp = new int[s.length()];
        Arrays.fill(dp, -1);
        HashSet<String> set = new HashSet<>();
        for (String t : dictionary) {
            set.add(t);
        }
        return rec(0, s, set);
    }

    public int rec(int idx, String str, HashSet<String> set) {
        if (idx == str.length())
            return 0;
        if (dp[idx] != -1)
            return dp[idx];
        int ans = 1 + rec(idx + 1, str, set);
        for (int i = idx; i < str.length(); i++) {
            if (set.contains(str.substring(idx, i + 1))) {
                ans = Math.min(ans, rec(i + 1, str, set));
            }
        }
        return dp[idx] = ans;
    }
}