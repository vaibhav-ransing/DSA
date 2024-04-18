import java.util.Arrays;

public class BS_2_times_iq {

    public static int maxProfit(int[] prices) {
        int dp[][] = new int[prices.length][4];
        Arrays.stream(dp).forEach(row -> Arrays.fill(row, -1));
        return recursion(0, 0, prices, dp);
    }

    public static int recursion(int idx, int transaction, int[] prices, int[][] dp) {

        if (transaction == 4 || idx == prices.length)
            return 0;

        if (dp[idx][transaction] != -1)
            return dp[idx][transaction];
        int profit = 0;
        // 0 1 2 3 -> 4
        // B S B S -> 4 transactions are done
        if (transaction % 2 == 0) { // buy
            profit = recursion(idx + 1, transaction + 1, prices, dp) - prices[idx];
        } else {
            profit = recursion(idx + 1, transaction + 1, prices, dp) + prices[idx];
        }
        int skip = recursion(idx + 1, transaction, prices, dp);

        return dp[idx][transaction] = Math.max(profit, skip);
    }

    public static int tabulation(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n + 1][5];

        for (int idx = n - 1; idx >= 0; idx--) {
            for(int transaction = 3; transaction >=0; transaction-- ){
                int profit = 0;
                if(transaction % 2 == 0){
                    profit = dp[idx + 1][transaction + 1] - prices[idx];
                }else{
                    profit = dp[idx + 1][transaction + 1] + prices[idx];
                }
                int skip = dp[idx + 1][transaction];
                dp[idx][transaction] = Math.max(profit, skip);
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {

    }
}
