package Day4_buySellStock;

public class lc_123_twoTrans {
    

    public int maxProfit(int[] prices) {
        int max=0;
        int mp = prices[0];
        int dpL[] = new int[prices.length];
        for(int i=1; i<prices.length; i++){
            max = Math.max(max, prices[i]-mp);
            mp = Math.min(mp, prices[i]);
            dpL[i] = Math.max(dpL[i-1], max);
        }

        int prof=0;
        int maxP = prices[prices.length-1];
        int dpR[] = new int[prices.length];
        for(int i=prices.length-2; i>=0; i--){
            prof = Math.max(prof, maxP -  prices[i]);
            System.out.println("prof "+ i+" "+prof);
            maxP = Math.max(maxP, prices[i]);
            dpR[i] = Math.max(dpR[i+1], maxP);
        }
        for(int val: dpL){
            System.out.print(val+" ");
        }
        System.out.println();
        for(int val: dpR){
            System.out.print(val+" ");
        }
        int ans = 0;
        for(int i=0; i<prices.length; i++){
            ans = Math.max(ans, dpL[i]+dpR[i]);
        }

        return ans;
    }   

    public int maxProfit2(int[] prices) {
        int n = prices.length;
        int dpLeft[] = new int[n];   
        
        int LBI = 0;
        int LSI = 0;
        int profit = 0;
        for(int i=1; i<n; i++){
            if(prices[i-1] < prices[i]){
                LSI++;
            }else{
                profit+= prices[LSI] - prices[LBI];
                dpLeft[i] = profit;
                LBI = i;
                LSI = i;
            }
            dpLeft[i] = Math.max(dpLeft[i-1], profit);
        }
        for(int val: dpLeft){
            System.out.println(val+" ");
        }
        System.out.println();
        int dpRight[] = new int[n];
        int RSI = n-1;
        int RBI = n-1;
        profit = 0;
        for(int i=n-2; i>=0; i--){
            if(prices[i]<prices[i+1]){
                RBI--;
            }else{
                profit+= prices[RSI] - prices[RBI];
                dpRight[i] = profit;
                RSI = RBI = i;
            }
            dpRight[i] = Math.max(dpRight[i+1], profit);
        }
        int ans = 0;
        for(int i=0; i<n; i++){
            ans = Math.max(ans, dpLeft[i]+dpRight[i]);
        }
        for(int val: dpRight){
            System.out.println(val+" ");
        }
        System.out.println();
        return ans;
    }   

}
