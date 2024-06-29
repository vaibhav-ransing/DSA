package Random;

import java.util.Arrays;
import java.util.HashMap;

public class ArithmeticSlicing2 {

    public static int numberOfArithmeticSlices(int[] arr) {
        HashMap<Integer, Integer>[] dp = new HashMap[arr.length];
        for (int i = 0; i < arr.length; i++) {
            dp[i] = new HashMap<>();
        }
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int diff = arr[j] - arr[i];
                if (dp[i].get(diff) != null) {
                    ans += dp[i].get(diff);
                }
                dp[j].put(diff, dp[j].getOrDefault(diff, 0) + 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 4, 6, 8 };
        System.out.println(numberOfArithmeticSlices(arr));
    }
}
