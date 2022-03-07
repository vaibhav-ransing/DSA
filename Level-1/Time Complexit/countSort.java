// public class countSort {
    
//     static void cs(int arr[]){
//         int min= Integer.MAX_VALUE;
//         int max = Integer.MIN_VALUE;
//         for(int i=0;i<arr.length;i++){
//             min = Math.min(min, arr[i]);
//             max = Math.max(max, arr[i]);
//         }
//         int freqArr[] = new int[max-min+1];
//         for(int i=0;i<arr.length;i++){
//             freqArr[arr[i]-min]+=1;
//         }
//         for(int i=1;i<freqArr.length;i++){
//             freqArr[i]+=freqArr[i-1];
//         }
//         int ans[] = new int[arr.length];
//         for(int i=arr.length-1; i>=0;i--){
//             int index = freqArr[arr[i]-min]--;
//             ans[index-1]=arr[i];
//             // freqArr[arr[i]-min]--;
//         }
//         for(int i=0;i<ans.length;i++)
//             System.out.print(ans[i]+" ");
//     }

//     public static void main(String[] args) {
//         int arr[]  = {5,3,7,3,5,7,2,7,2,7,6,5,6};
//         cs(arr);
//     }   
// }
import java.io.*;
import java.util.*;

public class countSort {

  public static void countSort2(int[] arr, int min, int max) {
        int freqArr[] = new int[max-min+1];

        for(int i=0;i<arr.length;i++)
            freqArr[arr[i]-min]++;
        for(int i=1;i<freqArr.length;i++)
            freqArr[i]+=freqArr[i-1];
        int ans[] = new int[arr.length];
        for(int i=arr.length-1; i>=0;i--){
            int index = freqArr[arr[i]-min]--;
            ans[index-1] = arr[i];
        }
        arr = ans;
        // for(int i=0;i<ans.length;i++)   
        //     System.out.print(arr[i]+" ");

  }

  public static void print(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }

  public static void main(String[] args) throws Exception {
    // Scanner scn = new Scanner(System.in);
    // int n = scn.nextInt();
    // int[] arr = new int[n];
    // int arr[]  = {5,3,7,3,5,7,2,7,2,7,6,5,6};
    int arr[]  = {7,-2,4,1,3};
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < arr.length; i++) {
    //   arr[i] = scn.nextInt();
      max = Math.max(max, arr[i]);
      min = Math.min(min, arr[i]);
    }
    countSort2(arr,min,max);
    // print(arr);
  }

}