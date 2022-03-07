public class paintFence {
    
    public static void dpSoln(int n, int k) {
        int dp[][] = new int[3][n+1];
        for(int i=2;i<dp[0].length;i++){
            if(i==2){
                dp[0][i]=k;
                dp[1][i]=k*(k-1);
            }else{
                dp[0][i] = dp[1][i-1];
                dp[1][i] = dp[2][i-1]*(k-1);
            }
            dp[2][i]= dp[0][i]+dp[1][i];
        }
        display( dp);
        // System.out.println(dp[2][dp[0].length-1]);
    }
    static void display(int dp[][]){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++)
                System.out.print(dp[i][j]+" ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        dpSoln(8, 3);
    }
}
