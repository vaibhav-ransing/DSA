package BinaryIndexTree;

import java.util.Arrays;

class Solution {

    public int reversePairsBrute(int[] nums) {

        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if ((long) nums[j] > 2 * (long) nums[i])
                    count++;
            }
        }
        return count;
    }

    public int reversePairs(int[] nums) {
        mergeSort(nums);
        return count;
    }

    int count = 0;

    public void mergeSort(int[] arr) {
        if (arr.length <= 1)
            return;
        int mid = arr.length / 2;

        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);

        mergeSort(left);
        mergeSort(right);

        check(left, right);

        merge(arr, left, right);
    }

    public void check(int[] left, int[] right) {
        for (int j = 0; j < right.length; j++) {
            int idx = Arrays.binarySearch(left, 2 * right[j]);
            idx = idx < 0 ? -(idx + 1) : idx + 1;

            int remValues = left.length - idx;
            count += remValues;
        }
    }

    public void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        while (i < left.length) {
            arr[k++] = left[i++];
        }
        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }

}