package DP.BuySellStoks;

public class CantHoldStock {

    public int maxProfit(int[] prices) {
        int buy = -prices[0], sell = 0;
        for(int i=1; i<prices.length; i++){
            buy = Math.max(buy, sell - prices[i]);
            sell = Math.max(sell, buy + prices[i]);
        }        
        return sell;
    }
}
