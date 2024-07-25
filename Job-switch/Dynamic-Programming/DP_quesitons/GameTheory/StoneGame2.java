
public class StoneGame2 {

    public static int stoneGameII(int[] piles) {
        int n = piles.length;
        Integer[][][] memo = new Integer[n][n + 1][2]; // Adding memoization
        return rec(0, 1, piles, true, memo);
    }

    public static int rec(int idx, int M, int[] piles, boolean aliceChance, Integer[][][] memo) {
        if (idx >= piles.length)
            return 0;

        if (memo[idx][M][aliceChance ? 1 : 0] != null)
            return memo[idx][M][aliceChance ? 1 : 0];

        int sum = 0;
        if (aliceChance) {
            int max = 0;
            for (int x = 1; x <= 2 * M && (idx + x) <= piles.length; x++) {
                sum += piles[idx + x - 1];
                max = Math.max(max, sum + rec(idx + x, Math.max(M, x), piles, !aliceChance, memo));
            }
            memo[idx][M][1] = max;
            return max;
        } else {
            int min = Integer.MAX_VALUE;
            for (int x = 1; x <= 2 * M && (idx + x) <= piles.length; x++) {
                sum += piles[idx + x - 1];
                // In the below call we are doing sum + rec...
                // But this is bobs chance so this sum will be take away by bob
                // so whatever comes from rec will be sent back to alics
                // min = Math.min(min, sum + rec(idx + x, Math.max(M, x), piles, !aliceChance));
                min = Math.min(min, rec(idx + x, Math.max(M, x), piles, !aliceChance, memo));
            }
            memo[idx][M][0] = min;
            return min;
        }
    }

}
