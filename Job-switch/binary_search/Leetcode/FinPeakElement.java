package Leetcode;

public class FinPeakElement {

    public int findPeakElement(int[] arr) {
        int n = arr.length;
        if (n == 1)
            return 0;

        if (arr[0] > arr[1])
            return 0;
        if (arr[n - 1] > arr[n - 2])
            return n - 1;

        int low = 1, high = n - 2;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            if(arr[mid - 1] < arr[mid]){  // means mid is in increasing state and mid + 1 side will have peek
                low = mid + 1;
            }else{  // arr[mid] > arr[mid + 1]  means mid is decreaing so mid - 1 side will have peaka
                high = mid - 1;
            }
        }

        return - 1;
    }

    public static int findPeakElementBruteforce(int arr[]) {

        for (int i = 0; i < arr.length; i++) {
            int left = i == 0 ? Integer.MIN_VALUE : arr[i - 1];
            int right = i == arr.length - 1 ? Integer.MIN_VALUE : arr[i + 1];

            int curr = arr[i];
            if (left < curr && curr > right)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}