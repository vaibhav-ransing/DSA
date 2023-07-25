package Day1;   

public class SelectionSort {        


    public static void selectionSortCode(int[] arr){

        int minIdx = -1;
        
        for(int i=0; i<arr.length; i++){
            int minVal = Integer.MAX_VALUE;
            for(int j=i; j<arr.length; j++){
                if(arr[j] < minVal){
                    minIdx = j;
                    minVal = arr[j];
                }
            }
            swap(arr, minIdx, i);
        }

        for(int val : arr){
            System.out.print(val+" ");
        }
    }

    public static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {    
        int[] arr = { 5, 2, 1, 7, 4, 3 };
        selectionSortCode(arr);
    }   
}   
