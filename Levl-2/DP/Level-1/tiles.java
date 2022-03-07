public class tiles {
    static void dpSoln(int n){
        int dp[] = new int[n+1];
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<dp.length;i++)
            dp[i] = dp[i-1]+dp[i-2];
        System.out.println(dp[n]);
    }

    public static void main(String[] args) {
        
    }
}
