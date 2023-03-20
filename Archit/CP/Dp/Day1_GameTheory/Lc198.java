package CP.Dp.Day1_GameTheory;

public class Lc198 {

    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n][n];
        for(int i=0; i<n; i++)
            for(int j=0; j<nums.length; j++)
                dp[i][j] = Integer.MIN_VALUE;
            
        int val = helper(nums, 0, nums.length-1, dp);
        return val>=0;
    }
    static int helper(int arr[], int i, int j, int dp[][]){
        
        if(i==j)
            return arr[i];
        if(dp[i][j] != Integer.MIN_VALUE)
            return dp[i][j];
        int iChoise = arr[i] -  helper(arr, i+1, j, dp);
        int jChoise = arr[j] - helper(arr, i, j-1, dp);
        dp[i][j] = Math.max(iChoise, jChoise);
        return dp[i][j];
    }  
}
