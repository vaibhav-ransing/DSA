import java.util.Arrays;

public class targetSumTriplet {
    
    static void printTriplet(int arr[], int target){
        
        Arrays.sort(arr);
        for(int i=0; i<arr.length;i++){
            int remTar = target - arr[i];
            int j=i+1;
            int k=arr.length-1;
            while(j<k){
                int sum = arr[j]+arr[k];
                if(sum==remTar){
                    System.out.println(arr[i]+" "+ arr[j]+" "+ arr[k]);
                    j++;
                    k--;
                }
                else if(sum<remTar) j++;
                else k--;
            }
        }   
    }

    public static void main(String[] args) {
        int arr[] = {1,9,6,4,8,12,14,24,10,15};
        printTriplet(arr, 25);

    }
}
