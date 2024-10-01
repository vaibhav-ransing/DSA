package ZRandom;

import java.util.Arrays;

public class Sum3Closest {

    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        // -4, -1, 1, 2 (tgt = 1)
        int currClose = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length - 2; i++) {
            int sum = target - nums[i];
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int currSum = nums[left] + nums[right];
                if (Math.abs(target - (currSum + nums[i])) < Math.abs(target - currClose)) {
                    currClose = currSum + nums[i];  // Update currClose with the total sum
                }
                if (currSum < sum) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return currClose;
    }
}
