public class maxOfArray {
    
    static int maxArr(int arr[], int max,int index){

        if(index==arr.length)
            return max;
        if(arr[index] > max)   
            return maxArr(arr, arr[index], index+1);
        else
            return maxArr(arr, max, index+1);

    }

    // static int ar(int[]arr,int n,int max){
    //     if(n==-1)
    //         return max;

    //     if(max<arr[n])
    //         max=arr[n];

    //     return ar(arr,n-1,max);
    // }

    public static void main(String[] args) {
        int arr[] = {15,2,3,6,1,6,8,3};    
        System.out.println(maxArr(arr, 0,0));
    }
}
