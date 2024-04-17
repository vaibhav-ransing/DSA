import java.util.Arrays;

public class BS_2_times {

    public static int maxProfit(int[] prices) {
        int idx = 0;
        int transactions = 2;
        int dp[][][] = new int[prices.length][2][3];
        Arrays.stream(dp).forEach(row -> Arrays.stream(row).forEach(temp -> Arrays.fill(temp, -1)));
        return dpSolution(idx, 1, transactions, prices, dp);
    }

    public static int dpSolution(int idx, int canBuy, int transactions, int[] prices, int dp[][][]) {
        if (idx == prices.length)
            return 0;
        if (dp[idx][canBuy][transactions] != -1)
            return dp[idx][canBuy][transactions];

        int profit = 0;
        if (canBuy == 1) { // we can buy here caouse canBuy is true.
            if (transactions > 0)
                profit = dpSolution(idx + 1, 0, transactions - 1, prices, dp) - prices[idx];

        } else { // we cannot buy we can only sell coause canBuy is false.
            profit = dpSolution(idx + 1, 1, transactions, prices, dp) + prices[idx];
        }
        int dontBuyOrSell = dpSolution(idx + 1, canBuy, transactions, prices, dp);
        profit = Math.max(profit, dontBuyOrSell);
        return dp[idx][canBuy][transactions] = profit;
    }

    public static void main(String[] args) {
        // System.out.println("hello");
        int prices[] = { 3, 2, 6, 5, 0, 3 };

        System.out.println(maxProfit(prices));

    }

}
