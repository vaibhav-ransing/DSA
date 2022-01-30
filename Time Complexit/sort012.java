public class sort012 {
    
    static void sort(int arr[]){

        int i=0,j=0,k=arr.length-1;
        while(j<=k){
            if(arr[j]==1)
                j++;
            if(arr[j]==0){
                int temp = arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                i++;
                j++;
            }
            if(arr[j]==2){
                int temp= arr[j];
                arr[j]= arr[k];
                arr[k]= temp;
                k--;
            }
            else{
                int temp= arr[j];
                arr[j]= arr[k];
                arr[k]= temp;
                k--;
            }
        }
        for(int f=0;f<arr.length;f++)
            System.out.print(arr[f]+" ");
    }

    public static void main(String[] args) {
        // int arr[]= {1,1,0,2,1,2,0};
        int arr[]= {2,1,0};
        sort(arr);
    }
}   
