public class sort012 {
    


    static void sort012Soln(int arr[]){
        // 1 0 2 1 0 1
        int i=0 ,j=0, k= arr.length-1;
        while(j<=k){
            if(arr[j]==1){
                j++;
            }else if(arr[j]==2){
                swap(arr, j, k);
                k--;
            }else{
                swap(arr, i, j);
                i++;
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
        int arr[] = {1,0,2,1,0,1};
        sort012Soln(arr);
    }
}
