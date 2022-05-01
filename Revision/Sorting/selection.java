public class selection {
    

    static void sort(int arr[]){
        int i=0, min=0;
        while(i!=arr.length-1){
            for(int j=i; j<arr.length; j++){
                if(arr[j]< arr[min]){
                    min = j;
                }
            }
            swap(arr, i, min);
            i++;
            min = i;
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
        int arr[] = {4,2,6,1};
        sort(arr);
    }
}
