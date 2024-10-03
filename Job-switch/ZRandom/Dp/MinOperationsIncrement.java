package ZRandom.Dp;

import java.util.Arrays;

public class MinOperationsIncrement {

    public long minimumOperations(int[] nums, int[] target) {
        int n = nums.length;
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = target[i] - nums[i];
        }
        System.out.println(Arrays.toString(arr));

        long count = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) {
                count += arr[i] - arr[i - 1];
            }
        }
        return count;
    }

    class Solution {
        public long minimumOperations(int[] nums, int[] target) {
            // Input: nums = [1,3,2], target = [2,1,4]

            long answer = 0;
            int prev = 0;

            for (int i = 0; i < nums.length; i++) {

                int curr = nums[i] - target[i]; // prev = -1, curr = 2

                if ((curr >= 0 && prev < 0) || (prev >= 0 && curr < 0)) {
                    answer += Math.abs(curr);
                } else if (Math.abs(curr) > Math.abs(prev)) {
                    answer += Math.abs(curr - prev);
                }

                prev = curr;
            }
            return answer;
        }
    }
}
