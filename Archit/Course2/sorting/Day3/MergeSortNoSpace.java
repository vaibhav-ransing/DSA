package Day3;

public class MergeSortNoSpace {
    
    public static void sortRange(int[] arr, int l1,int l2){
        int p1 = l1;
        int p2 = l2;
        while(p1 < l2){
            if(arr[p1] >= arr[p2]){
                swap(arr, p1, p2);
            }else{
                p2++;
            }
            p1++;
        }
    }
    public static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;

        mergeSort(arr, left, mid);
        mergeSort(arr, mid+1, right);

        sortRange(arr, left, mid+1);
    }

    public static void main(String[] args) {
        int[] arr = {5,3,9,3,1,5,3};
        mergeSort(arr, 0, arr.length-1);
        for(int val : arr){
            System.out.print(val+" ");
        }

    }
}
