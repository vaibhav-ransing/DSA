import java.util.Arrays;

public class BS_k_times {
    
    public static int maxProfit(int k, int[] prices) {
        int dp[][] = new int[prices.length][k*2];
        Arrays.stream(dp).forEach(row -> Arrays.fill(row, -1));
        return recursion(0, 0, prices, dp, k*2);
    }

    public static int recursion(int idx, int transaction, int[] prices, int[][] dp, int k) {

        if (transaction == k || idx == prices.length)
            return 0;

        if (dp[idx][transaction] != -1)
            return dp[idx][transaction];
        int profit = 0;
        // 0 1 2 3 -> 4
        // B S B S -> 4 transactions are done
        if (transaction % 2 == 0) { // buy
            profit = recursion(idx + 1, transaction + 1, prices, dp, k) - prices[idx];
        } else {
            profit = recursion(idx + 1, transaction + 1, prices, dp, k) + prices[idx];
        }
        int skip = recursion(idx + 1, transaction, prices, dp, k);

        return dp[idx][transaction] = Math.max(profit, skip);
    }

    public static int maxProfit2(int k, int[] prices) {
        int idx = 0;
        int transactions = k;
        int dp[][][] = new int[prices.length][2][2*k];
        Arrays.stream(dp).forEach(row -> Arrays.stream(row).forEach(temp -> Arrays.fill(temp, -1)));
        return dpSolution(idx, 1, transactions, prices, dp);
    }

    public static int dpSolution(int idx, int canBuy, int transactions, int[] prices, int dp[][][]) {
        if (idx == prices.length || transactions == 0)
            return 0;
        if (dp[idx][canBuy][transactions] != -1)
            return dp[idx][canBuy][transactions];

        int profit = 0;
        if (canBuy == 1) { // we can buy here caouse canBuy is true.
            profit = dpSolution(idx + 1, 0, transactions, prices, dp) - prices[idx];

        } else { // we cannot buy we can only sell coause canBuy is false.
            profit = dpSolution(idx + 1, 1, transactions - 1, prices, dp) + prices[idx];
        }
        int dontBuyOrSell = dpSolution(idx + 1, canBuy, transactions, prices, dp);
        profit = Math.max(profit, dontBuyOrSell);
        return dp[idx][canBuy][transactions] = profit;
    }
    
}
