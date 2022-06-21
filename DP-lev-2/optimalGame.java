public class optimalGame {
    
    public static void optimalStrategy(int[] a){
        //Write your code here
        int dp[][] = new int[a.length][a.length];
        System.out.println(helper(a,0,a.length-1, dp));
    }   
    public  static boolean PredictTheWinner(int[] nums) {
        int sum = 0;
        for(int val: nums){
            sum+=val;
        }
        int dp[][] = new int[nums.length][nums.length];
        int tem = helper(nums, 0, nums.length-1, dp);
        int opp = sum-tem;
        return tem>opp;
    }
    static int helper(int arr[], int i, int j, int dp[][]){
        if(i>j)    return 0;
        if(dp[i][j]!=0) return dp[i][j];
        int iChoosen = arr[i] + Math.min(helper(arr, i+2, j, dp), helper(arr, i+1, j-1, dp));
        int jChoosen = arr[j] + Math.min(helper(arr, i+1, j-1, dp), helper(arr, i, j-2, dp));
        int val = Math.max(iChoosen, jChoosen);
        dp[i][j]=val;
        return val;
    }     

    public static void main(String[] args) {
        int arr[] = {8,15,3,7};
        // optimalStrategy(arr);
        int a[]= {1,3,1};
        System.out.println(PredictTheWinner(a));
    }
}
