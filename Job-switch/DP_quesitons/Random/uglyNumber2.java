package Random;

import java.util.*;

public class uglyNumber2 {

    public int nthUglyNumber(int n) {
        int dp[] = new int[n + 1];
        dp[1] = 1;
        int idx2 = 1;
        int idx3 = 1;
        int idx5 = 1;

        for (int i = 2; i < dp.length; i++) {
            int mfo2 = dp[idx2] * 2;
            int mfo3 = dp[idx3] * 3;
            int mfo5 = dp[idx5] * 5;

            dp[i] = Math.min(mfo2, Math.min(mfo3, mfo5));
            if (dp[i] == mfo2) {
                idx2++;
            }
            if (dp[i] == mfo3) {
                idx3++;
            }
            if (dp[i] == mfo5) {
                idx5++;
            }
        }
        return dp[n];
    }

    public int nthUglyNumberExtraStorage(int n) {

        int arr[] = { 2, 3, 5 };
        PriorityQueue<Long> pq = new PriorityQueue<>();
        HashSet<Long> set = new HashSet<>();
        pq.add(1L);
        while (n-- > 1) {
            long peek = pq.poll();
            for (int val : arr) {
                if (!set.contains(val * peek)) {
                    pq.add(val * peek);
                    set.add(val * peek);
                }
            }
        }
        long peek = pq.peek();
        return (int) peek;
    }

}
