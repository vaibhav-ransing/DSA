package DP.Day3;

public class JumpGame {
    
    public boolean rec(int[] nums, int currIdx){

        if(currIdx == nums.length - 1) return true;

        if(currIdx >= nums.length) return false;

        boolean flag = false;
        
        for(int i=1; i<=nums[currIdx]; i++){
            flag = rec(nums, currIdx+i);
        }
        return flag;
    }

    public boolean dpMemo(int[] nums, int currIdx, boolean[] dp){

        if(currIdx >= nums.length) return false;
        if(currIdx == nums.length - 1 || dp[currIdx]) return true;
        boolean flag = false;
        
        for(int i=1; i<=nums[currIdx]; i++){
            flag = dpMemo(nums, currIdx+i, dp);
            if(flag) break;
        }
        return dp[currIdx] = flag;
    }

    public boolean canJump(int[] nums) {
        boolean dp[] = new boolean[nums.length];
        return dpMemo(nums, 0, dp);
    }

}
