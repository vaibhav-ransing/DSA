import java.util.Arrays;

public class CoingChange2 {

    public static int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        Arrays.sort(coins);
        dp[0] = 1;
        for (int coin : coins) {
            for (int amt = 1; amt < dp.length; amt++) {
                if (amt >= coin) {
                    dp[amt] += dp[amt - coin];
                }
            }
        }
        // 1 2 3 amt = 3
        // 1 1 2 3
        System.out.println(Arrays.toString(dp));
        ogArr(dp);
        return dp[amount];
    }

    public static int ogArr(int[] dp) {
        int amount = dp.length - 1;
        for (int i = 1; i < dp.length; i++) {
            if (dp[i] == 1) {
                int coin = i;
                for (int amt = dp.length - 1; amt >= i; amt--) {
                    dp[amt] -= dp[amt - coin];
                }
                System.out.println("coin " + coin);
                System.out.println(Arrays.toString(dp));
            }
        }
        return dp[amount];
    }
    // 1 2
    // 3 -> 1 1 2 2 -> 1 0 1 0 -> 1 0 0 1
  
    public static void main(String[] args) {
        // int[] coins = { 1, 2, 5 };
        int[] coins = { 2, 5, 6 };
        // int[] coins = { 5, 6, 7 };
        change(10, coins);
    }
}
