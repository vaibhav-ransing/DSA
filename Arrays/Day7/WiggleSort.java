package Day7;

import java.util.Arrays;

public class WiggleSort {

    public void wiggleSort2(int[] arr) {

        Arrays.sort(arr);
        int ans[] = new int[arr.length];

        int i=1, j = arr.length-1;
        while(i<arr.length){
            ans[i] = arr[j];
            i+=2;
            j--;
        }
        i=0;
        while(i<arr.length){
            ans[i] = arr[j];
            j--;
            i+=2;
        }

        for(int idx=0; idx<arr.length; idx++){
            arr[idx] = ans[idx];
        }

    }


    public static int[] wiggleSort(int n, int[] arr) {
        // 1 2 3 4 5 even index should be smaller than odd indexed values
        // 1 4 2 5 3
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0 && (arr[i] > arr[i + 1])) {
                swap(arr, i, i + 1);
            } else if (i % 2 == 1 && (arr[i] < arr[i+1])) {
                swap(arr, i, i + 1);
            }
        }
        return arr;
    }

    public static void swap(int[] arr, int i, int j) {
        int val = arr[i];
        arr[i] = arr[j];
        arr[j] = val;
    }

    
    public static void main(String[] args) {

    }
}
