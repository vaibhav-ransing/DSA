public class climbStairVariable {
    
    static int recSoln(int arr[], int index){
        
        if(index==arr.length)
            return 1;
        if(index>arr.length)
            return 0;

        int ans=0;
        for(int i=1;i<=arr[index]; i++){
             ans+= recSoln(arr, index+i);
        }
        return ans;
            
    }

    public static void main(String[] args) {
    // int arr[] = {3,3,0,2,1,2,4,2,0,0};
    int arr[] = {3,3,0,2,1,2,4,2,0,0};
    System.out.println(recSoln(arr, 0));
    }
}
