package Random;

import java.util.Arrays;

public class JumpGame {

    // Best soln without dp
    public boolean canJumpBestSoln(int[] nums) {
        int goal = nums.length - 1;

        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= goal) {
                goal = i;
            }
        }

        return goal == 0;        
    }

    //  with dp
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[n - 1] = true;
        for (int i = n - 2; i >= 0; i--) {
            int jump = nums[i];
            for (int j = 1; j <= jump; j++) {
                if(i + j < n){
                    dp[i] = dp[i] | dp[i + j];
                }
                if(dp[i]) 
                    break;
            }
        }
        return dp[0];
    }


    // with rec
    class RecSoln {
        public boolean canJump(int[] arr) {
            int n = arr.length;
            int dp[] = new int[n];
            Arrays.fill(dp, -1);
            return rec(0, arr, dp);
        }

        public boolean rec(int idx, int[] arr, int[] dp) {
            if (idx == arr.length - 1)
                return true;
            if (idx >= arr.length)
                return false;

            if (dp[idx] != -1)
                return dp[idx] == 1;
            boolean ans = false;
            int jumps = arr[idx];
            for (int i = 1; i <= jumps; i++) {
                ans |= rec(idx + i, arr, dp);
            }
            dp[idx] = ans ? 1 : 0;
            return ans;
        }
    }
}
