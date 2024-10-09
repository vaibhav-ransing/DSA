package ZRandom;

public class MeditanOfTwoSorted {

    public double findMedianSortedArrays(int[] arr, int[] nums) {
        int i = 0, j = 0;
        int len = arr.length + nums.length;
        int mid1 = -1, mid2 = -1;
        for (int count = 0; count < len / 2; count++) {
            mid1 = mid2;
            if (i < arr.length && (j == nums.length || arr[i] < nums[j])) {
                mid2 = arr[i];
                i++;
            } else {
                mid2 = nums[j];
                j++;
            }
        }
        if (len % 2 == 1) {
            return mid2;
        } else {
            return (mid1 + mid2) / 2.0;
        }
    }
}