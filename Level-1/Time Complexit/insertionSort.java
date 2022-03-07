public class insertionSort {
    



    public static void main(String[] args) {
        int arr[] = {20,10,90,40,30};
        // 10,20,90, 15
        for(int i=1;i<arr.length;i++){
            for(int j=i-1;j>=0;j--){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;

                }else{
                    break;
                }
            }
        }
        
        for (int i : arr) {
            System.out.print(i+" ");
        }

    }
}
