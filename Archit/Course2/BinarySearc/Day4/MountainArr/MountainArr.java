package Archit.Course2.BinarySearc.Day4.MountainArr;

public class MountainArr {

    // LC - 852
    public int peakIndexMountainArr(int[] arr) {

        int left = 1, right = arr.length - 2;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return mid;
            } else if (arr[mid] > arr[mid - 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public int searchInMountainArr(int[] arr, int val) {
        int peakIndex = peakIndexMountainArr(arr);
        int incInd = binarySearchIncreasing(arr, 0, peakIndex);
        int decInd = binarySearchDecreasing(arr, peakIndex, arr.length - 1);

        return incInd != -1 ? incInd : decInd;
    }

    public int binarySearchIncreasing(int arr[], int start, int end) {

        return -1;
    }

    public int binarySearchDecreasing(int arr[], int start, int end) {
        return -1;
    }

    public static void main(String[] args) {

    }
}
