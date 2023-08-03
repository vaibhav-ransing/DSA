public class Sort01 {
    
    public static void sort(int[] arr){
        int left = 0, right = 0;
        while(right < arr.length){
            if(arr[right] == 0){
                swap(arr, left, right);
                left++;
            }
            right++;
        }
        for(int val : arr){
            System.out.print(val+" ");
        }
    }

    public static void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }

    public static void main(String[] args) {
        int arr[] = {0, 0, 1, 1, 0};
        sort(arr);
    }
}
