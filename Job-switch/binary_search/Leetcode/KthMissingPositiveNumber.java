package Leetcode;

public class KthMissingPositiveNumber {

    public int findKthPositive(int[] arr, int k) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int missingElements = arr[mid] - mid - 1;
            if (missingElements < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        if(high < 0) return k;
        int leftMissing = arr[high] - high - 1;
        // return low + k
        // return high + 1 + k
        return arr[high] + (k - leftMissing);
    }

    public int findKthPositiveN(int[] arr, int k) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= k)
                k++;
            else
                break;
        }
        return k;
    }
}
