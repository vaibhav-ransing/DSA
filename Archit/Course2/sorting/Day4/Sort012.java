public class Sort012 {
    
    public static void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
    
    public static void sortColors(int[] arr){
        int i=0, j=0, k=arr.length-1;
        while(j <= k){
            if(arr[j] == 0){
                swap(arr, i, j);
                i++;
                j++;
            }else if(arr[j] == 1){
                j++;
            }else{
                swap(arr, j, k);
                k--;
            }
        }
    }


    public static void main(String[] args) {
        
    }
}
