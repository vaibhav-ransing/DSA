import java.util.Arrays;

public class BS_with_fee {

    public static int maximumProfit(int[] prices, int n, int fee) {
        // Write your code here.
        n = prices.length;
        int dp[][] = new int[n][2];
        Arrays.stream(dp).forEach(row -> Arrays.fill(row, -1));
        return recursion(0, 1, prices, dp, fee);
    }

    public static int recursion(int idx, int buy, int[] prices, int dp[][], int fee) {
        if (idx >= prices.length)
            return 0;

        if (dp[idx][buy] != -1)
            return dp[idx][buy];

        int profit = 0;
        if (buy == 1) { // buy
            profit = recursion(idx + 1, 0, prices, dp, fee) - prices[idx];
        } else {
            profit = recursion(idx + 1, 1, prices, dp, fee) + prices[idx] - fee;
        }
        int skip = recursion(idx + 1, buy, prices, dp, fee);
        return dp[idx][buy] = Math.max(profit, skip);
    }

    public static void main(String[] args) {

    }
}
