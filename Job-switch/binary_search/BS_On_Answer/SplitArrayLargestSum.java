package BS_On_Answer;

import java.util.Arrays;

public class SplitArrayLargestSum {

    public int splitArray(int[] nums, int k) {
        int high = Arrays.stream(nums).sum();
        int low = Arrays.stream(nums).max().orElse(Integer.MAX_VALUE);
        while (low <= high) {
            int mid = (low + high) / 2;
            if (canSplit(nums, k, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public boolean canSplit(int[] arr, int k, int maxSumInSubArr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            int cv = arr[i];
            if (cv > maxSumInSubArr)
                return false;
            if (cv + sum > maxSumInSubArr) {
                k--;
                sum = cv;
            } else {
                sum += cv;
            }
        }
        return k >= 1;
    }
}
