package Day3;

public class ShellSort {

    public static void swap(long arr1[], long arr2[], int i, int j) {
        long temp = arr1[i];
        arr1[i] = arr2[j];
        arr2[j] = temp;
    }

    public static void merge(long arr1[], long arr2[], int n, int m) {
        int i = n + m;
        while (i >= 1) {
            for (int j = 0; j + i < n + m; j++) {
                if(compare(arr1, arr2, j, j+i)){
                    swap(arr1, arr2, j, j + i);
                }   
            }
            if (i == 1)
                break;
            i = i / 2 + i % 2;
        }
    }
    public static boolean compare(long[] arr1, long[] arr2, int l, int r){
        return true;
    }

}
