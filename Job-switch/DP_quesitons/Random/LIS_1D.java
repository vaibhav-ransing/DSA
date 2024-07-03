package Random;

public class LIS_1D {
    public int[] longestObstacleCourseAtEachPosition(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for(int j=0; j<i; j++){
                if(arr[j] <= arr[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp;
    }
}