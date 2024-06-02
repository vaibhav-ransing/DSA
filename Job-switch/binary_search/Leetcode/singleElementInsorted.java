package Leetcode;

public class singleElementInsorted {

    public int singleNonDuplicate(int[] arr) {
        int[]
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid + 1 < arr.length && arr[mid] == arr[mid + 1]) {  // make sure we are at `the right` index of 2 duplicates elements i.e. arr[mid - 1] == arr[mid]  this is what we want to achieve
                mid = mid + 1;
            } else if (mid - 1 >= 0 && arr[mid] == arr[mid - 1]) { // index is already at correct index
                mid = mid;
            } else {  
                return arr[mid];
            }
            // x x y y z z a a b b c
            int ls = mid - low + 1; // + 1 because we are mking sure that 
            int rs = high - mid;

            if (ls % 2 == 0) { // left side is even so element is on right size
                low = mid + 1;
            } else { // right side is even  so element is in left side
                high = mid - 1;
            }
        }
        return - 1;
    }
}
