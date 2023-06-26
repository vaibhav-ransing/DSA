package Archit.Course2.BinarySearc.Day4.RotatedArr;

public class MinInRotatedSortedArr {

    public int findMinArchitSOln(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        if (nums[left] <= nums[right])
            return nums[0];

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] >= nums[0]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return nums[left];
    }

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        if (nums[left] <= nums[right])
            return nums[0];

        while (left <= right) {
            int mid = (left + right) / 2;

            if(nums[mid] > nums[left] ){
                left = mid+1;
            }else if( nums[mid] < nums[right] ){
                right = mid - 1;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {

    }
}