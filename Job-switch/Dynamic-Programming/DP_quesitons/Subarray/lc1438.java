package Subarray;

import java.util.Arrays;

public class lc1438 {

    public static int numSubarrayBoundedMax(int[] arr, int left, int right) {
        int i = 0, j = 0;
        int n = arr.length;
        int dp[] = new int[n]; // no. of subarrays with maxval <= right

        while (j < n) {
            int cv = arr[j];
            if (left <= cv && cv <= right) {
                dp[j] = j - i + 1;
            } else if (cv < left) { 
                // this can be appended to the end of previous subarrays
                    // i.e. no. of subarrays ending with j-1
                dp[j] = j - 1 >= 0 ? dp[j - 1] : 0;
            } else {
                i = j + 1;
            }
            j++;
        }
        System.out.println(Arrays.toString(dp));
        int ans = Arrays.stream(dp).sum();
        return ans;
    }

    public static void main(String[] args) {
        int[] arr= {73,55,36,5,55,14,9,7,79,52};
        numSubarrayBoundedMax(arr, 32, 69);
    }
}