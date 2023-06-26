package Archit.Course2.BinarySearc.Day1;

public class BinarySearch {

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length;

        while(left <= right){
            int mid = (left+right)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else{  
                left = mid+1;
            }
        }
        return -1;
    }

}
