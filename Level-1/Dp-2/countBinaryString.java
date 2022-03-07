public class countBinaryString {
    
    static void CBS(int n){
        int dp[][] = new int[2][n+1];
        dp[0][1]=1;
        dp[1][1]=1;
        for(int i=2;i<dp[0].length;i++){
            dp[0][i] = dp[1][i-1];
            dp[1][i] = dp[1][i-1] + dp[0][i-1];
        }
        // System.out.println(dp[0][n]+dp[1][n]);
        for(int i=0;i<dp[0].length;i++){
            System.out.print(dp[0][i]+" "+dp[1][i]);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        CBS(6);
    }    
}
