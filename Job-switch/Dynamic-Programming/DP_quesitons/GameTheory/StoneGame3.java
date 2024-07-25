import java.util.Arrays;

public class StoneGame3 {

    public String stoneGameIII(int[] arr) {
        int sum = Arrays.stream(arr).sum();

        int dp[][] = new int[arr.length][2];
        Arrays.stream(dp).forEach(d -> Arrays.fill(d, Integer.MAX_VALUE));

        int aliceBest = rec(0, arr, 1, dp);

        if (aliceBest * 2 == sum)  // both have same score
            return "Tie";

        return aliceBest * 2 > sum ? "Alice" : "Bob";
    }

    public int rec(int idx, int[] arr, int alice, int dp[][]) {

        int n = arr.length;
        if (idx == n)
            return 0;
        if (dp[idx][alice] != Integer.MAX_VALUE)
            return dp[idx][alice];
        int result = alice == 1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        int sum = 0;

        for (int i = 0; i < 3 && idx + i < n; i++) {
            sum += arr[idx + i]; // make sure to do `idx + i`, I was doing arr[i]

            if (alice == 1) { // if it is alices turn get max result
                result = Math.max(result, sum + rec(idx + i + 1, arr, 1 - alice, dp));

            } else { // if it is bobs turn get the minimun from the idx to idx + 3 index
                result = Math.min(result, rec(idx + i + 1, arr, 1 - alice, dp));
            }
        }
        return dp[idx][alice] = result;
    }
}