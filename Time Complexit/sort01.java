public class sort01 {
    
    static void sort(int arr[]){
        int i=0,j=0;

        while(j<arr.length && i<arr.length){
            if(arr[j]==1)
                j++;
            else{
                // int temp= arr[i];
                // arr[i]= arr[j];
                // arr[j]= temp;
                arr[j]=1;
                arr[i]=0;
                i++;
                j++;
            }
        }
        for(int k=0;k<arr.length;k++)
            System.out.print(arr[k]+" ");
    }
    

    public static void main(String[] args) {
        int arr[] = {0,1,1,0,0,1,0};
        sort(arr);
        int arr3[] = {0,4,9,0,3,0};
        
    }

}
