package CP.RangeQueries.Day1;

public class prefixSum {
    
    // public static int[] dp;
    // public static void soln(int arr[]){
    //     dp = new int[arr.length];
    //     dp[0] = arr[0];
    //     for(int i=1; i<arr.length; i++){
    //         dp[i] = arr[i] + dp[i-1];
    //     }
    // }
    public int[][] dp;
    public prefixSum(int[][] arr) {
        int n = arr.length;
        dp = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(j==0)
                    dp[i][j] = arr[i][j];
                else
                    dp[i][j] = arr[i][j] + dp[i][j-1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        if(col1==0){
            for(int i=row1; i<=row2; i++){
                sum+= dp[i][col2];
            }
        }else{
            for(int i=row1; i<=row2; i++){
                sum+= dp[i][col2] - dp[col1-1][i];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        
    }
}