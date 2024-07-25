package Z_DailyLC;
public class subseq1 {

    public int maximumLength(int[] arr) {
        int n = arr.length;
        int dp[][] = new int[n][2];
        dp[0][0] = 1;
        dp[0][1] = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if ((arr[i] + arr[j]) % 2 == 0) {
                    dp[i][0] = Math.max(dp[i][0], 1 + dp[j][0]);
                } else {
                    dp[i][1] = Math.max(dp[i][1], 1 + dp[j][1]);
                }
            }
        }
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            maxLength = Math.max(maxLength, Math.max(dp[i][0], dp[i][1]));
        }
        return maxLength;
    }
}