public class IterativeCode {

    public int searchIterative(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        return recursive(nums, target, 0, nums.length - 1);
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