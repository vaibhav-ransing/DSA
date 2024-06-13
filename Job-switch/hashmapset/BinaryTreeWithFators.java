import java.util.Arrays;
import java.util.HashMap;

public class BinaryTreeWithFators {

    public int numFactoredBinaryTrees(int[] arr) {
        long MOD = (long) 1e9 + 7;

        Arrays.sort(arr);
        int n = arr.length;
        long[] dp = new long[n];
        Arrays.fill(dp, 1);

        HashMap<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put((long) arr[i], i);
        }
        
        for (int i = 1; i < n; i++) {
            int val = arr[i];
            for (int j = 0; j < i; j++) { // all the factors will be less than current number
                int div = arr[j];
                if (val % div == 0 && map.containsKey((long) val / div)) {
                    dp[i] = (dp[i] + dp[j] * dp[map.get((long) val / div)]) % MOD;
                }
            }
        }

        long sum = 0;
        for (long num : dp) {
            sum = (sum + num) % MOD;
        }
        return (int) sum;
    }

}
