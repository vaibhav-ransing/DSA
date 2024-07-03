import java.util.Arrays;
import java.util.HashSet;

public class CanIWin {

    public boolean canIWin(int max, int desiredTotal) {
        // If the sum of all numbers from 1 to max is less than desiredTotal, no one can win
        int sum = (max * (max + 1)) / 2;
        if (sum < desiredTotal) {
            return false;
        }

        // If the desired total is 0 or less, the first player wins by default
        if (desiredTotal <= 0) {
            return true;
        }
        int[][] dp = new int[desiredTotal + 1][2];
        Arrays.stream(dp).forEach(d -> Arrays.fill(d, -1));
        return helper(true, desiredTotal, new HashSet<>(), max, dp);
    }

    public boolean helper(boolean p1_call, int totalVal, HashSet<Integer> set, int maxChosable, int[][] dp) {
        if (totalVal <= 0) {
            return !p1_call; // Return based on whose turn it is when totalVal becomes <= 0
        }
        if(dp[totalVal][p1_call ? 1:0] != -1){
            return dp[totalVal][p1_call ? 1:0] == 1;
        }
        for (int i = 1; i <= maxChosable; i++) {
            if (!set.contains(i)) {
                set.add(i);
                boolean res = helper(!p1_call, totalVal - i, set, maxChosable, dp);
                set.remove(i);

                // If it's player 1's turn and the result of the recursive call is true,
                // it means player 1 can force a win
                if (p1_call && res) {
                    dp[totalVal][p1_call ? 1:0] = 1;
                    return  true;
                }
                
                // If it's player 2's turn and the result of the recursive call is false,
                // it means player 2 can force a win
                if (!p1_call && !res) {
                    dp[totalVal][p1_call ? 1:0] = 0;
                    return false;
                }
            }
        }
        // If it's player 1's turn and no winning move was found, return false
        // If it's player 2's turn and no losing move was found, return true
        dp[totalVal][p1_call ? 1:0] =  p1_call ? 0 : 1;
        return !p1_call;
    }
}