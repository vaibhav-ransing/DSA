import java.util.HashMap;

public class FrogJump {
    public boolean canCross(int[] stones) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            map.put(stones[i], i);
        }
        int dp[][] = new int[2001][2001];
        if (stones[1] != 1)
            return false;
        return helper(stones, 1, 1, map, dp);
    }

    public boolean helper(int[] stones, int idx, int k, HashMap<Integer, Integer> map, int dp[][]) {
        if (idx == stones.length - 1)
            return true;

        if (dp[idx][k] != 0) {
            return dp[idx][k] == 1;
        }
        boolean possible = false;
        for (int i = -1; i <= 1; i++) {
            int curr_stone = stones[idx];
            int next_stone = curr_stone + (k + i);

            if (curr_stone != next_stone && map.containsKey(next_stone)) {
                possible |= helper(stones, map.get(next_stone), k + i, map, dp);
            }
        }
        dp[idx][k] = possible ? 1 : -1;
        return possible;
    }
}
