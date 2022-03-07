public class countBinary {
    
    static void dpCountBinary(int n){
        if(n==0)
            return;
        int dp[][]= new int[2][n+1];
        dp[0][1]=1;
        dp[1][1]=1;
        for(int i=2;i<dp[0].length;i++){
            dp[0][i]= dp[1][i-1];
            dp[1][i]= dp[0][i-1]+dp[1][i-1];
        }
        System.out.println(dp[0][dp[0].length-1]+dp[1][dp[0].length-1]);
    }

    public static void main(String[] args) {
        dpCountBinary(7);
    }
}
