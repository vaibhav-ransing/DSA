package Subarray;

public class maxSumOrTwoNonOverlappingSubarr {

    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {

        int n = nums.length;
        int arr[] = new int[n + 1];
        for (int i = 0; i < n; i++) {
            arr[i + 1] = nums[i] + arr[i];
        }

        int sum = 0;
        // take the fist sum from 
        for (int i = 0; i <= n - firstLen - secondLen; i++) {
            int firstsum = arr[i + firstLen] - arr[i];
            for (int j = i + firstLen; j <= n - secondLen; j++) {
                int secondsum = arr[j + secondLen] - arr[j];
                sum = Math.max(sum, firstsum + secondsum);
            }
        }
        for (int i = 0; i <= n - firstLen - secondLen; i++) {
            int secondsum = arr[i + secondLen] - arr[i];
            for (int j = i + secondLen; j <= n - firstLen; j++) {
                int firstsum = arr[j + firstLen] - arr[j];
                sum = Math.max(sum, firstsum + secondsum);
            }
        }
        return sum;
    }
}
