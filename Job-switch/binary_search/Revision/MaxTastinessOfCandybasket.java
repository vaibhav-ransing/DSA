package Revision;

import java.util.Arrays;

public class MaxTastinessOfCandybasket {

    public int maximumTastiness(int[] arr, int k) {
        // 1, 2, 5, 8, 13, 21
        Arrays.sort(arr);
        int left = 0, right = 9999;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canPickKElements(arr, mid, k)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    public boolean canPickKElements(int[] arr, int diff, int k) {

        int prev = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[prev] >= diff) {
                prev = i;
                k--;
            }
        }
        return k <= 1;
    }
}
