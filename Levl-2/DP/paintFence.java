public class paintFence {
    
    static void soln(int n, int k){
        int dp[][] = new int[3][n+1];
        dp[1][1] = k;
        dp[2][1] = k;
        for(int j=2;j<dp[0].length;j++){
            for(int i=0;i<dp.length;i++){
                if(i==0){
                    dp[i][j] = dp[i+1][j-1];
                }else if(i==1){
                    dp[i][j] = (k-1)*dp[i+1][j-1];
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i-2][j]; 
                }
            }
        }
        // System.out.println(dp[dp.length-1][n]);
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        soln(8,3);
    }
}
