package Day4_buySellStock;

public class lc_121_oneBS {

   

    public int maxProfit(int[] prices) {
        int max=0;
        int mp = prices[0];
        for(int i=1; i<prices.length; i++){
            max = Math.max(max, prices[i]-mp);
            mp = Math.min(mp, prices[i]);
        }
        return max;
    }

}
