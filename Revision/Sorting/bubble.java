public class bubble{

    static void sort(int arr[]){
        int last = arr.length;
        
        while(last !=0){
            for(int i=1; i<last; i++){
                if(arr[i-1] > arr[i]){
                    swap(arr, i, i-1);
                }
            }
            last--;
        }
        for(int val: arr)
            System.out.print(val +" ");
    }
    static void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        int arr[] = {5,2,8,3,4,1,6};
        sort(arr);
    }
}