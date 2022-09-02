package Day4_buySellStock;

public class lc_714_multBSFee {
    

    public int maxProfit(int[] prices, int fee) {
        int profit = 0;
        int buyIndex = 0;
        int sellIndex = 0;
        int dp[][] = new int[2][prices.length];
        dp[0][0] = -prices[0];
        dp[1][0] = 0;
        for(int i=1; i<dp.length; i++){

        }
        return profit;
    }
    public int maxProfitSir(int[] prices, int fee) {
        int obsp = -prices[0];
        int ossp = 0;
        for(int i = 1; i < prices.length; i++){
            int nbsp = Math.max(ossp - prices[i], obsp);
            int nssp = Math.max(obsp + prices[i] - fee, ossp);
            obsp = nbsp;
            ossp = nssp;
        }
        
        return ossp;
    }


    // for(int i=1; i<prices.length; i++){
    //     int cp = prices[i];
    //     if(cp>=prices[i-1]){
    //         sellIndex++;
    //     }else{
    //         if((prices[sellIndex] - prices[buyIndex])>fee)
    //             profit+= prices[sellIndex] - prices[buyIndex] - fee;
    //         System.out.println(i+" "+profit);
    //         sellIndex = i;
    //         buyIndex = i;
    //     }
    // }
    // if((prices[sellIndex] - prices[buyIndex])>fee)
    //     profit+= prices[sellIndex] - prices[buyIndex] - fee;

}
