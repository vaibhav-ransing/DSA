import java.util.*;
import java.util.stream.IntStream;

public class BS_n_times {

    public static int maxProfit(int[] prices) {
        int max = Arrays.stream(prices).max().orElse(0);
        int dp[][] = new int[prices.length][2];
        Arrays.stream(dp).forEach(row -> Arrays.fill(row, -1));

        // int ans = recursion_keeping_previous_buy_value(prices.length - 1, 0, prices,
        // dp);
        // int ans = recursion(0, true, prices, dp);
        int ans = dpSolution(0, true, prices, dp);
        return ans;
    }

    public static int bestSolution(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += (prices[i] - prices[i - 1]);
            }
        }
        return maxProfit;
    }

    public static long getMaximumProfit(int n, long[] prices) {

        long dp[][] = new long[prices.length][2];
        Arrays.stream(dp).forEach(row -> Arrays.fill(row, -1));

        // we are returning dp[0][1] which will be the final outupt of tabulation
        return dpSolution(0, true, prices, dp);
    }

    // Recursive / Memoization
    public static long dpSolution(int idx, boolean canBuy, long[] prices, long dp[][]) {

        // since our base case is at idx == n, this will be the base case also in tabulation
        if (idx == prices.length)
            return 0;

        if (dp[idx][(canBuy ? 1 : 0)] != -1)
            return dp[idx][(canBuy ? 1 : 0)];

        long profit = 0;
        if (canBuy) { // we can buy here caouse canBuy is true.
            profit = dpSolution(idx + 1, false, prices, dp) - prices[idx];
        } else { // we cannot buy we can only sell coause canBuy is false.
            profit = dpSolution(idx + 1, true, prices, dp) + prices[idx];
        }
        long dontBuyOrSell = dpSolution(idx + 1, canBuy, prices, dp);
        profit = Math.max(profit, dontBuyOrSell);
        return dp[idx][(canBuy ? 1 : 0)] = profit;
    }

    // Tabulating the above solution
    public static int tabulation(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n + 1][2];

        // we start from n-1 cause tabulation is reverse of recursion
        // so our basecase is at i == n, so we loop from n-1
        for (int i = n - 1; i >= 0; i--) {

            // This buy will be either 0 or 1, pretry straight forward
            for (int buy = 0; buy <= 1; buy++) {

                int profit = 0;
                if (buy == 1) {
                    // in recursion we use exact same indices here
                    profit = dp[i + 1][0] - prices[i];
                } else {
                    profit = dp[i + 1][1] + prices[i];
                }
                int skip = dp[i + 1][buy];

                dp[i][buy] = Math.max(profit, skip);
            }
        }
        // in our main function we have returned dpSolution(0, true) --> dp[0][1]
        return dp[0][1];
    }

    public static int dpSolution(int idx, boolean canBuy, int[] prices, int dp[][]) {
        if (idx == prices.length)
            return 0;
        if (dp[idx][(canBuy ? 1 : 0)] != -1)
            return dp[idx][(canBuy ? 1 : 0)];

        int profit = 0;
        if (canBuy) { // we can buy here caouse canBuy is true.
            profit = dpSolution(idx + 1, false, prices, dp) - prices[idx];
        } else { // we cannot buy we can only sell coause canBuy is false.
            profit = dpSolution(idx + 1, true, prices, dp) + prices[idx];
        }
        int dontBuyOrSell = dpSolution(idx + 1, canBuy, prices, dp);
        profit = Math.max(profit, dontBuyOrSell);
        return dp[idx][(canBuy ? 1 : 0)] = profit;
    }

    public static int recursion(int idx, boolean canBuy, int[] prices, int dp[][]) {
        if (idx == prices.length)
            return 0;

        int profit = 0;
        if (canBuy) { // we can buy here caouse canBuy is true.
            int doBuy = recursion(idx + 1, false, prices, dp) - prices[idx];
            int dontBuy = recursion(idx + 1, canBuy, prices, dp);
            profit = Math.max(doBuy, dontBuy);
        } else { // we cannot buy we can only sell coause canBuy is false.
            int doSell = recursion(idx + 1, true, prices, dp) + prices[idx];
            int dontSell = recursion(idx + 1, canBuy, prices, dp);
            profit = Math.max(doSell, dontSell);
        }

        return profit;
    }

    public static int recursion_keeping_previous_buy_value(int idx, int boughtAt, int[] prices, int dp[][]) {
        if (idx < 0) {
            return 0;
        }
        if (dp[idx][boughtAt] != -1)
            return dp[idx][boughtAt];
        int buyNow = 0;
        int sellNow = 0;
        if (boughtAt == 0) {
            buyNow = recursion_keeping_previous_buy_value(idx - 1, prices[idx], prices, dp);
        } else {
            sellNow = (boughtAt - prices[idx]) + recursion_keeping_previous_buy_value(idx - 1, 0, prices, dp);
        }
        int dontBuyOrSell = recursion_keeping_previous_buy_value(idx - 1, boughtAt, prices, dp);

        return dp[idx][boughtAt] = Math.max(buyNow, Math.max(sellNow, dontBuyOrSell));
    }

    public static void main(String[] args) {
        // 7 5 6 6 6 4
        // int arr[] = { 7, 1, 5, 3, 6, 4 };
        int arr[] = { 3, 3, 5, 0, 0, 3, 1, 4 };
        System.out.println(maxProfit(arr));
    }
}
