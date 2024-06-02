package Leetcode.Rotated;

public class SearchInRotatedArr1 {

    public int search(int[] arr, int target) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            System.out.println(low + " " + mid + " " + high);
            if (arr[mid] == target)
                return mid;
            if (arr[low] <= arr[mid]) { // left side sorted
                System.out.println("left sorted");
                System.out.println(arr[low] +" "+ target + " "+ arr[high]);
                if (arr[low] <= target && target <= arr[mid] ) { // target falls in left half
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                System.out.println("right sorted");
                if (arr[mid] <= target && target <= arr[high]  ) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            System.out.println(low + " " + mid + " " + high);
            System.out.println("-------------");
        }
        return -1;
    }
}