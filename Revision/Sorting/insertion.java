public class insertion {
    
    
    static void sort(int arr[]){
        //  3,2,4,1
        // 2,3,4  1
        for(int i=1;i<arr.length;i++){
            int j=i;
            while(j>=1){
                if(arr[j-1]> arr[j]){
                    swap(arr, j-1, j);
                    j--;
                }else{
                    break;
                }
            }
        }
        for(int val: arr)
            System.out.print(val+" ");
    }
    static void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int arr[] = {3,2,4,1};
        sort(arr);
    }
}
