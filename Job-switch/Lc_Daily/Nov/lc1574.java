package Lc_Daily.Nov;

import java.util.Arrays;

public class lc1574 {
    class Solution {
        public int findLengthOfShortestSubarray(int[] arr) {
            int j = arr.length - 1;

            // Find the first index from the end where the array stops being sorted
            while (j > 0 && arr[j - 1] <= arr[j]) {
                j--;
            }

            // If the entire array is already sorted
            if (j == 0)
                return 0;

            int min = j; // Initial minimum is removing the prefix up to `j`

            for (int i = 0; i < arr.length; i++) {
                // Stop if current index `i` exceeds `j`
                if (i > 0 && arr[i] < arr[i - 1])
                    break;

                // Find the next index `nextJ` from `j` where `arr[nextJ] >= arr[i]`
                int nextJ = helper(arr, i, j);

                // Calculate the subarray to remove
                min = Math.min(min, nextJ - i - 1);
            }

            return min;
        }

        public int helper(int[] arr, int i, int j) {
            int smaller = arr[i];

            // Use binary search for efficiency
            int left = j, right = arr.length;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (arr[mid] >= smaller) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            return left;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 3, 5, 7, 9, 12, 17 };
        int idx = Arrays.binarySearch(arr, 2, 6, 2);
        System.out.println(idx);
        System.err.println(-idx - 1);
    }

}
