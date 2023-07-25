package Day1;

public class BubbleSort {

    // public static void sortBubble(int[] arr) {
    //     while (keepSwapping(arr)) {
    //         keepSwapping(arr);
    //     }
    //     for (int val : arr) {
    //         System.out.print(val + " ");
    //     }
    // }

    public static void sortBubble2(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    count++;
                }
            }
            if (count == 0)
                return;
        }

        for (int val : arr) {
            System.out.print(val + " ");
        }
    }

    public static boolean keepSwapping(int[] arr) {
        boolean swapFlag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                swapFlag = true;
                swap(arr, i, i + 1);
            }
        }
        return swapFlag;
    }

    public static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = { 5, 2, 1, 7, 4, 3 };
        sortBubble2(arr);
    }
}