package Imp;

import java.util.HashMap;

public class LongestArithmeticsSubseq {

    public int longestArithSeqLength(int[] arr) {
        int n = arr.length;
        HashMap<Integer, Integer>[] dp = new HashMap[n];
        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
        }
        int max = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int diff = arr[i] - arr[j];
                int val = dp[j].getOrDefault(diff, 1) + 1;
                max = Math.max(max, val);
                dp[i].put(diff, val);
            }
        }
        return max;
    }

}
