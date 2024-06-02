package Leetcode.Rotated;

public class MinInRotatedArray {

    public int findMin1(int[] arr) {
        int low = 0, high = arr.length - 1;

        int ans = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] >= arr[low]) { // left is sorted means arr[low] is minimum at left side, 
                                        // so we take "min of arr[low] and ans" and check the right side
                ans = Math.min(ans, arr[low]);
                low = mid + 1;

            } else { // right is sorted means arr[mid] is minimum possible answer right side, so we
                     // take that "min or arr[mid]" and go to left to find any smaller.
                ans = Math.min(arr[mid], ans);
                high = mid - 1;
            }
        }
        return ans;
    }

    // Solution without any variable
    public int findMin2(int[] nums) {
        int left = 0, right = nums.length - 1;
        while(left < right) {
            int mid = left + (right - left) / 2;

            if(nums[mid] < nums[right]) { // right side is sorted so min can be mid itself so move right to mid
                right = mid;
            } else { // nums[mid] > nums[right]  right side val is smaller 
                left = mid + 1;
            }
        }

        return nums[left];
    }

}
