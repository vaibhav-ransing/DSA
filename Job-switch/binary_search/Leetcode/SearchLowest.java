package Leetcode;

public class SearchLowest {

    public int[] searchRange2(int[] nums, int target) {
        int idx = recursive(nums, target, 0, nums.length - 1);
        if (idx == -1)
            return new int[] { -1, -1 };
        int lb = idx;
        int rb = idx;

        while (lb > 0 && nums[lb - 1] == target) {
            lb--;
        }
        while (rb < nums.length - 1 && nums[rb + 1] == target) {
            rb++;
        }
        return new int[] { lb, rb };
    }

    public int recursive(int[] nums, int target, int low, int high) {
        int mid = low + (high - low) / 2;
        if (low > high)
            return -1;
        if (nums[mid] == target)
            return mid;
        if (nums[mid] > target) {
            return recursive(nums, target, low, mid - 1);
        } else {
            return recursive(nums, target, mid + 1, high);
        }
    }

}
