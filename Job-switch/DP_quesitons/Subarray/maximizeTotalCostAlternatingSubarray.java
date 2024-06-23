package Subarray;
import java.util.HashMap;

public class maximizeTotalCostAlternatingSubarray {

    public static long maximumTotalCost(int[] nums) {
        HashMap<String, Long> map = new HashMap<>();

        return helper(0, false, nums, 0, map);
    }

    public static long helper(int idx, boolean isOdd, int[] nums, long sum, HashMap<String, Long> map) {
        if (idx == nums.length)
            return sum; 

        String key = idx + " " + isOdd + " " + sum;
        if (map.containsKey(key)) {
            return map.get(key);
        }

        long take = helper(idx + 1, !isOdd, nums, sum + (isOdd ? -(nums[idx]) : nums[idx]), map);
        long skip = sum + helper(idx + 1, isOdd, nums, nums[idx], map);

        map.put(key, Math.max(take, skip));
        return Math.max(take, skip);
    }

    public static void main(String[] args) {
        int[] arr = { -14, -13, -20 };
        System.out.println(maximumTotalCost(arr));
    }
}
