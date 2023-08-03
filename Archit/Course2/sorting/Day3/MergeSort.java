package Day3;

public class MergeSort {

    public static int[] merge(int[] arr1, int[] arr2) {
        int p1 = 0;
        int p2 = 0;
        int p3 = 0;
        int finalArr[] = new int[arr1.length + arr2.length];
        while (p1 < arr1.length || p2 < arr2.length) {
            int v1 = p1 < arr1.length ? arr1[p1] : Integer.MAX_VALUE;
            int v2 = p2 < arr2.length ? arr2[p2] : Integer.MAX_VALUE;
            if (v1 <= v2) {
                finalArr[p3] = v1;
                p1++;
            } else {
                finalArr[p3] = v2;
                p2++;
            }
            p3++;
        }
        return finalArr;
    }

    public int[] mergeSort(int[] arr, int left, int right) {
        if (left == right) {
            return new int[] { arr[left] };
        }
        int mid = (left + right) / 2;
        int[] larr = mergeSort(arr, left, mid);
        int[] rarr = mergeSort(arr, mid + 1, right);
        return merge(larr, rarr);
    }

    public static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
