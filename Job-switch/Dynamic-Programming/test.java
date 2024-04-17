public class test {
    
    public static long spaceOptimized (int n, long[] prices) {
        n = prices.length;
        long prev[] = new long[2];

        for (int i = n - 1; i >= 0; i--) {
            long curr[] = new long[2];
            for (int buy = 0; buy <= 1; buy++) {
                long profit = 0;
                if(buy == 1){
                    profit = prev[0] - prices[i];
                }else{
                    profit = prev[1] + prices[i];
                }
                long skip = prev[buy];

                curr[buy] = Math.max(profit, skip);
            }
            prev = curr;
        }
        return prev[1];
    }
    
}
