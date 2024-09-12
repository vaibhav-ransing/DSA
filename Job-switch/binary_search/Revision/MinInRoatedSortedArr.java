package Revision;

public class MinInRoatedSortedArr {

    class Solution {
        public int findMin(int[] arr) {
            int low = 0, high = arr.length - 1;
    
            while (low < high) {
                int mid = (low + high) / 2;
                
                // If mid element is greater than the high element, the minimum is in the right half
                if (arr[mid] > arr[high]) {
                    low = mid + 1;
                }
                // If mid element is less than or equal to the high element, the minimum is in the left half
                else {
                    high = mid;
                }
            }
    
            // At the end, low == high and points to the minimum element
            return arr[low];
        }
    }
    
}