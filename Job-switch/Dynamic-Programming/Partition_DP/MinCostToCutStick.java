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
        System.out.println(list);

        return 0;
    }

    public static int cutsRec(int i, int j, ArrayList<Integer> list) {
        
        return 0;
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
        // int arr[] = { 5, 6, 1, 4, 2 };
        // int n = 9;
        int arr[] = { 1, 3, 4, 5 };
        int n = 7;
        System.out.println(minCost(n, arr));
    }
}