package Partition_DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MinCostToCutStick {

    public static int minCost(int n, int[] cuts) {
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.stream(cuts).forEach(val -> list.add(val));
        list.add(0);
        list.add(n);
        Collections.sort(list);

        int dp[][] = new int[list.size()][list.size()];
        Arrays.stream(dp).forEach(row -> Arrays.fill(row, -1));
        int ans = cutsRec(1, list.size() - 2, list, dp);
        return ans;
    }

    public static int cutsRec(int i, int j, ArrayList<Integer> list, int dp[][]) {
        if (i > j)
            return 0;
        System.out.println(i + " " + j + " " + list.size());
        if (dp[i][j] != -1)
            return dp[i][j];
        int ans = Integer.MAX_VALUE;

        // idx is running on cuts
        for (int idx = i; idx <= j; idx++) {
            int cost = list.get(j + 1) - list.get(i - 1);
            int left = cutsRec(i, idx - 1, list, dp);
            int right = cutsRec(idx + 1, j, list, dp);

            ans = Math.min(ans, cost + left + right);
        }
        return dp[i][j] = ans;
    }

    // running index on n
    public static int rec(int left, int right, int[] cuts, int count, boolean[] used) {
        if (count == cuts.length)
            return 0;
        int ans = 9999;
        for (int i = 0; i < cuts.length; i++) {
            if (cuts[i] <= right && !used[i]) {
                used[i] = true;
                int temp = rec(left, cuts[i], cuts, count + 1, used) // left rem
                        + rec(cuts[i], right, cuts, count + 1, used) // right rem
                        + (right - left) + 1;
                used[i] = false;
                ans = Math.min(ans, temp);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = { 5, 6, 1, 4, 2 };
        int n = 9;
        // int arr[] = { 1, 3, 4, 5 };
        // int n = 7;
        System.out.println(minCost(n, arr));
    }
}