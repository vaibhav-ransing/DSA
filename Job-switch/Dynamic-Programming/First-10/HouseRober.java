import java.util.Arrays;

public class HouseRober {
    public static int rob(int[] nums) {
        int dp[][] = new int[nums.length + 1][2];
        // Arrays.fill(dp, Integer.MIN_VALUE);
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                dp[i][j] = Integer.MIN_VALUE;
            }
        }
        return recursive(nums, 0, true, dp);
    }

    public  static int recursive(int[] nums, int idx, boolean take, int[][] dp){
        if(idx == nums.length)
            return 0;
        if(dp[idx][take ? 0 : 1] != Integer.MIN_VALUE)
            return dp[idx][take ? 0 : 1];
        int dontTake = recursive(nums, idx+1, true, dp);
        int takeCurr = 0;
        if(take)
            takeCurr = nums[idx] + recursive(nums, idx+1, false, dp);
        
        return dp[idx][take ? 0 : 1] = Math.max(takeCurr, dontTake);
    }

    public static int recursionSoln2(int[] nums, int n){
        if(n < 0)
            return 0;
        
        int take = nums[n] + recursionSoln2(nums, n-2);
        int dontTake = recursionSoln2(nums, n-1);

        return Math.max(take, dontTake);
    }

    public static int memoization(int[] nums, int n, int[] dp){
        if(n < 0)
            return 0;
        if(dp[n] != 0) 
            return dp[n];

        int take = nums[n] + memoization(nums, n-2, dp);
        int dontTake = memoization(nums, n-1, dp);

        return dp[n] = Math.max(take, dontTake);
    }

    public static int solutionTabulation(int[] nums){
        if(nums.length == 0 || nums.length == 1)
            return nums.length == 0 ? 0 : nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.min(nums[0], nums[1]);

        for(int i=2; i<nums.length; i++){
            dp[i] = Math.max(dp[i-1], nums[i] + dp[i-2]);
        }
        return dp[nums.length-1];
    }


    public static int spaceOptimized(int[] nums, int start, int end){
        int pre1 = nums[start];
        int prev2 = 0;

        for(int i = start; i<end; i++){
            int take = nums[i] + prev2;
            int dontTake = pre1;
            int currVal = Math.max(take, dontTake);

            prev2 = pre1;
            pre1 = currVal;
        }
        return pre1;
    }


    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        int n = nums.length;
        int[] dp = new int[nums.length];
        // System.out.println(recursionSoln2(nums, nums.length - 1));
        System.out.println(memoization(nums, n-1, dp));
    }
}
