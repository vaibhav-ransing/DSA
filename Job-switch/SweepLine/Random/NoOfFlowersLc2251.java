package SweepLine.Random;

import java.util.Arrays;

public class NoOfFlowersLc2251 {

    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int[][] arr = new int[2 * flowers.length][]; // time, start-0/end-1
        int idx = 0;
        for (int[] flower : flowers) {
            arr[idx++] = new int[] { flower[0], 0 };
            arr[idx++] = new int[] { flower[1], 1 };
        }
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        int dp[] = new int[arr[arr.length - 1][0] + 1];
        int count = 0, prevTime = -1;
        for (int i = 0; i < arr.length; i++) {
            int[] a = arr[i];
            int currTime = a[0];
            if (a[1] == 0) {
                count++;
            } else {
                count--;
            }
            for (int j = prevTime + 1; j <= currTime; j++) {
                dp[j] = count;
            }
            prevTime = currTime;
        }

        int[] ans = new int[people.length];
        for (int i = 0; i < people.length; i++) {
            ans[i] = dp[people[i]];
        }
        return ans;
    }
}
