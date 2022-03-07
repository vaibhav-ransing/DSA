
public class radixSort2 {

    static void radixSort(int arr[], int count){
        // count is length of maxnumber in arr
        int ans[] = new int[arr.length];
        for(int k=0;k<count;k++){
            
            int freqArr[] = new int[10];
        
        for(int i=0;i<arr.length;i++){
            int ind = (arr[i]/(1* (int)(Math.pow(10, k))))%10;
            freqArr[ind]+=1;
            }
        for(int i=1;i<freqArr.length;i++){
            freqArr[i]+=freqArr[i-1];
        }
        for(int i=arr.length-1; i>=0;i--){
            int val = (arr[i]/(1* (int)(Math.pow(10, k))))%10;
            int pos = freqArr[val];
            ans[pos-1]=  arr[i];
            freqArr[val]--;
            }
        }
        for(int i=0;i<ans.length;i++)
            System.out.print(ans[i]+" ");
    }
    public static void main(String[] args) {
        
        int arr[] = {12,14,47,7,49};
        int max=0;
        for(int i=0;i<arr.length;i++)
            max = Math.max(max, arr[i]);
        int count=0;
        while(max!=0){
            count+=1;
            max=max/10;
        }
        radixSort(arr,count);
    }
}

// import java.io.*;
// import java.util.*;

// class radix {

//   public static void radixSort(int[] arr) {
//       int max = Integer.MIN_VALUE;
//       for(int i=0;i<arr.length;i++)
//         max = Math.max(max, arr[i]);
//       int range= 0;
//       while(max!=0){
//         range++;
//         max = max/10;
//       }
//       for(int i=0;i<range;i++){
//         countSort(arr, i);
//       }
//   }

//   public static void countSort(int[] arr, int exp) {

//     int freqArr[] = new int[10];
//     for(int i=0;i<arr.length;i++){
//       int digit = (arr[i]/((int) Math.pow(10, exp)))%10;
//       freqArr[digit]++;
//     }
//     for(int i=1;i<freqArr.length;i++)
//       freqArr[i]+=freqArr[i-1];

//     int ans[] = new int[arr.length];
//     for(int i=arr.length-1;i>=0;i--){
//         int digit = (arr[i]/((int) Math.pow(10, exp)))%10;
//         ans[freqArr[digit]-1] = arr[i];
//         freqArr[digit]--;
//     }
//     for(int i=0;i<arr.length;i++)
//       arr[i] = ans[i];

//     System.out.print("After sorting on " + (exp+1) + " place -> ");
//     print(arr);
//   }

//   public static void print(int[] arr) {
//     for (int i = 0; i < arr.length; i++) {
//       System.out.print(arr[i] + " ");
//     }
//     System.out.println();
//   }

//   public static void main(String[] args) throws Exception {
//     // Scanner scn = new Scanner(System.in);
//     // int n = scn.nextInt();
//     // int[] arr = new int[n];
//     // for (int i = 0; i < n; i++) {
//     //   arr[i] = scn.nextInt();
//     // }
//     // int arr[] = {12,24,47,7};
//     int arr[] = {7 ,2,22, 621,2222,4 ,1 ,3};
//     radixSort(arr);
//     print(arr);
//   }

// }