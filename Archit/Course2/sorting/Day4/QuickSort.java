public class QuickSort {
    
    public static void quickSort(int[] arr){
        recursion(arr, 0, arr.length-1);
        for(int val : arr){
            System.out.print(val+" ");
        }
    }

    public static void recursion(int[] arr, int left, int right){
        if(left >= right || left<0 || right>=arr.length) return;
        randomize(arr, left, right);
        int mid = partition(arr, left, right, arr[right]);
        recursion(arr, left, mid-1);
        recursion(arr, mid+1 , right);
    }

    public static void randomize(int[] arr, int left, int right){
        int idx = (int)(Math.random()* (right - left + 1) + left );
        swap(arr, idx, right);
    }

    public static int partition(int[] arr, int left, int right, int piv){
        int i = left, j = left;
        while(j <= right){
            if(arr[j] <= piv){
                swap(arr, i, j);
                i++;
            }
            j++;
        }
        return i-1;
    }

    public static void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {2,7,4,8,1,6,2,5};
        quickSort(arr);
    }
}
