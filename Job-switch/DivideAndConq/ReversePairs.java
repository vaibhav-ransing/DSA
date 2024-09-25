package DivideAndConq;

import java.util.Arrays;

public class ReversePairs {
    public int reversePairs(int[] nums) {
        mergeSort(nums);
        return count;
    }

    public void check(int[] left, int[] right) {
        int j = 0;
        for (int i = 0; i < left.length; i++) {
            while (j < right.length && (long) left[i] > 2L * right[j]) { // Use long to avoid overflow
                j++;
            }
            count += j; // Add the number of valid reverse pairs
        }
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

        check(left, right); // This checks for reverse pairs

        merge(arr, left, right); // This merges the sorted arrays
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
