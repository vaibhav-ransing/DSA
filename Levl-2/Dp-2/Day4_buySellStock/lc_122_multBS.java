package Day4_buySellStock;

public class lc_122_multBS {
    
    public int maxProfit(int[] prices) {
        // 1,3,5,2,3
        int profit = 0;
        int buyIndex = 0;
        int sellIndex = 0;
        for(int i=1; i<prices.length; i++){
            int cp = prices[i];
            if(cp>=prices[i-1]){
                sellIndex++;
            }else{
                profit+= prices[sellIndex] - prices[buyIndex];
                sellIndex = i;
                buyIndex = i;
            }
        }
        return profit;
    }
}
