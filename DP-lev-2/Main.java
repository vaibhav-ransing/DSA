public class Main{

    static int ans = 0;
    public static int tallestBillboard(int[] rods) {
        int sum = 0;
        ans = 0;
        for(int val: rods) sum+=val;
        boolean dp[][] = new boolean[sum+1][sum+1];
        helper(rods, 0, 0, 0 , dp);
        System.out.println("ans "+ans);
        return ans;
    }
    static void helper(int[] rods, int i, int sum1, int sum2, boolean dp[][]){
        
        if(sum1==sum2){
            System.out.println(sum1);
            ans = Math.max(ans, sum1);
        }
        if(i==rods.length || dp[sum1][sum2]){
            dp[sum1][sum2] = true;
            return;
        }
        int val = rods[i];
        helper(rods, i+1, sum1, sum2, dp);
        helper(rods, i+1, sum1+val, sum2, dp);
        helper(rods, i+1, sum1, sum2+val, dp);
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6};
        tallestBillboard(arr);
    }
}