public class InsertionSort {
    
    public static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void solution(int[] arr){

        for(int i=1; i<arr.length; i++){
            for(int j=i; j>0; j--){
                if(arr[j] < arr[j-1]){
                    swap(arr, j-1, j);
                }
            }
        }
        for(int val : arr){
            System.out.print(val+" ");
        }
    }

    public static void main(String[] args) {
        int[] arr = { 5, 2, 1, 7, 4, 3 };
        solution(arr);
    }
}
