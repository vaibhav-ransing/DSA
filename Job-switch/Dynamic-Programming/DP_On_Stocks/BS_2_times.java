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

    public static int tabulation(int[] prices) {
        // For tabulation
        // we have base case as idx == n and transaction == 0
        // Now idx will start from n-1 to 0
        // we are sending buy as 1->0 in recursion so here it will go from 0 to 1
        // transaction in recursion start from 2->0 so here we do reverse i.e. 0->2
        int n = prices.length;
        int dp[][][] = new int[n + 1][2][3]; // n, buy, transactions
        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int transactions = 1; transactions <= 2; transactions++) {
                    int profit = 0;
                    if (buy == 1) {
                        profit = dp[i + 1][0][transactions] - prices[i];
                    } else {
                        profit = dp[i + 1][1][transactions - 1] + prices[i];
                    }
                    int dontBuyOrSell = dp[i + 1][buy][transactions];
                    dp[i][buy][transactions] = Math.max(profit, dontBuyOrSell);
                }

            }
        }
        return dp[0][1][2];
    }

    public static int tabulationSpaceOptimized(int[] prices) {
        int n = prices.length;
        int prev[][] = new int[2][3]; // n, buy, transactions
        for (int i = n - 1; i >= 0; i--) {
            int curr[][] = new int[2][3];
            for (int buy = 0; buy <= 1; buy++) {
                for (int transactions = 1; transactions <= 2; transactions++) {
                    int profit = 0;
                    if (buy == 1) {
                        profit = prev[0][transactions] - prices[i];
                    } else {
                        profit = prev[1][transactions - 1] + prices[i];
                    }
                    int dontBuyOrSell = prev[buy][transactions];
                    curr[buy][transactions] = Math.max(profit, dontBuyOrSell);
                }
            }
            prev = curr;
        }
        return prev[1][2];
    }

    public static void main(String[] args) {
        // System.out.println("hello");
        int prices[] = { 3, 2, 6, 5, 0, 3 };

        System.out.println(maxProfit(prices));

    }

}
