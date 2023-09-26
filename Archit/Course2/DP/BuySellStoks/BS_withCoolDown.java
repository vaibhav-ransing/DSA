package DP.BuySellStoks;

public class BS_withCoolDown {
    
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] buy = new int[n];
        int[] sell = new int[n];
        buy[0] = -prices[0];
        
        for(int i=1; i<n; i++){
            if(i>1)
                buy[i] = Math.max(buy[i-1], sell[i-2] - prices[i]);
            else
                buy[i] = Math.max(buy[i-1], -prices[i]);

            sell[i] = Math.max(sell[i-1], buy[i-1]+prices[i]);
        }
        return sell[n-1];
    }

    public static void main(String[] args) {
        
    }
}
