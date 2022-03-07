public class tilesRe {
        static void dpSoln(int n, int m){
            int dp[] = new int[n+1];
            dp[0]=1;
            dp[1] = 1;
            for(int i=2;i<dp.length;i++){
                dp[i] = dp[i-1];
                if(i-m>=0)
                    dp[i]+=dp[i-m];
            }
            // System.out.println(dp[dp.length-1]);
            for(int i=0;i<dp.length;i++)
                System.out.print(dp[i]+" ");
        }

    public static void main(String[] args) {
            dpSoln(7, 3);
    }
}
