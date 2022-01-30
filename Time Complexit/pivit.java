public class pivit {
    
    static void sort(int arr[], int piviot){
        int i=0,j=0;

        while(j<arr.length && i<arr.length){
            if(arr[j]>piviot)
                j++;
            else{
                int temp= arr[i];
                arr[i]= arr[j];
                arr[j]=temp;
                i++;
                j++;
            }
        }
        for(int k=0;k<arr.length;k++)
            System.out.print(arr[k]+" ");
    }

    public static void main(String[] args) {
        // int arr[] = {7,-2,4,1,3};
        int arr[] = {9,6,8,17};
        int n=17;
        sort(arr, n);
        System.out.println();

    }
}
