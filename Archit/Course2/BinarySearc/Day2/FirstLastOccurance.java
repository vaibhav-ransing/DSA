package Archit.Course2.BinarySearc.Day2;

public class FirstLastOccurance {

    public int[] searchRange(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else if (nums[mid] == target && (mid + 1 < nums.length && nums[mid + 1] == target)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        int last = (nums.length != 0 && l < nums.length && nums[l] == target) ? l : -1;

        l = 0;
        r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else if (nums[mid] == target && (mid - 1 >= 0 && nums[mid - 1] == target)) {
                r = mid - 1;
            } else {
                r = mid - 1;
            }
        }
        // int first = r;
        int first = (nums.length != 0 && l < nums.length && nums[l] == target) ? l : -1;
        int[] ans = { first, last };
        return ans;
    }

    public static void main(String[] args) {

    }
}
