package Day4_buySellStock;

public class k_transactions {
    public int maxProfit(int k, int[] prices) {
        if(prices.length==0 || k==0){
            return 0;
        }
        int dp[][] =  new int[k+1][prices.length];
        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                dp[i][j]=dp[i][j-1];
                for(int jj=0; jj<j; jj++){
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][jj]+prices[j]-prices[jj]);
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }


    public static void main(String[] args) {
        
    }
}
