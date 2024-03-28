import java.util.* ;
import java.io.*; 
public class Solution {
	public static int countPartitions(int n, int d, int[] arr) {
		// Write your code here.
		return tabulation(arr, d);
	}

	public static int tabulation(int arr[], int diff) {

        int ts = Arrays.stream(arr).sum();

        int s2 = (ts - diff) / 2;
        int dp[][] = new int[arr.length + 1][s2 + 1];
        dp[0][0] = 1;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (j == 0) {
                    dp[i][j] = 1;
                } else {
                    int dontTake = dp[i - 1][j];
                    int take = 0;
                    if (j - arr[i - 1] >= 0)
                        take = dp[i - 1][j - arr[i - 1]];

                    dp[i][j] = take + dontTake;
                }
            }
        }

        return dp[dp.length - 1][dp[0].length - 1];
    }
}