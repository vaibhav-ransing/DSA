package Day2;

public class lc_300_LIS {
    
    public static int lengthOfLIS(int[] nums) {
        // [10,11,2,5,3,7,101,18]
        int dp[] = new int[nums.length];
        dp[0]=1;
        for(int i=1; i<nums.length; i++){
            dp[i]=1;
            for(int j=0; j<i; j++){
                if(nums[i]>nums[j]){
                    dp[i] = Math.max(dp[j]+1, dp[i]);
                }
            }
        }
        int max=0;
        for(int val: dp){
            max = Math.max(max, val);
        }
        return max;
    }






    public static void main(String[] args) {
        int arr[]={4,10,4,3,8,9};
        lengthOfLIS(arr);
    }
}
