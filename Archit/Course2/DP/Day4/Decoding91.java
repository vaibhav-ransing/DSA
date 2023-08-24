package DP.Day4;

import java.util.Arrays;

public class Decoding91 {

    public int numDecodings(String s) {
        int dp[] = new int[s.length()+2];
        Arrays.fill(dp,-1);
        return rec(s, 0, dp);
    }

   public int rec(String s, int idx, int[] dp) {
        if (idx == s.length())
            return 1;
        if (s.charAt(idx) == '0' || idx > s.length())
            return 0;
        if(dp[idx] != -1) return dp[idx];
        int one = rec(s, idx + 1, dp);
        int two = 0;
        if( idx+2 <= s.length() && Integer.parseInt(s.substring(idx, idx+2)) < 27 )
            two = rec(s, idx + 2, dp);
        return dp[idx] = one + two;
    }
}
