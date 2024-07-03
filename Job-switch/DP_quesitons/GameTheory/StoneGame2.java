package GameTheory;

public class StoneGame2 {

    public static int stoneGameII(int[] piles) {
        int ans = rec(0, 1, piles, true);
        return ans;
    }

    public static int rec(int idx, int M, int piles[], boolean aliceChance) {
        if (idx >= piles.length)
            return 0;

        if (aliceChance) {
            int max = 0;
            int sum = 0;
            int count = 0;
            for (int i = 1; i <= 2 * M && i < piles.length; i++) {
                count++;
                sum += piles[idx + i - 1];
                max = Math.max(max, sum + rec(i + 1, count, piles, !aliceChance));
            }
            return max;
        } else {
            int min = Integer.MAX_VALUE;
            int sum = 0;
            int count = 0;
            for (int i = 1; i <= 2 * M && i < piles.length; i++) {
                count++;
                sum += piles[idx + i - 1];
                min = Math.min(min, sum + rec(i + 1, count, piles, !aliceChance));
            }
            return min;
        }
    }

}
