public class Partition {

    public static void partitionArray(int arr[], int pivot) {
        int left = 0, right = 0;
        while (right < arr.length) {
            if (arr[right] <= pivot) {
                swap(arr, left, right);
                left++;
            }
            right++;
        }
        for (int val : arr) {
            System.out.print(val + " ");
        }
    }

    public static void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }

    public static void main(String[] args) {
        int[] arr = { 70, 20, 40, 80, 10, 60, 30, 50 };
        partitionArray(arr, 50);
    }
}