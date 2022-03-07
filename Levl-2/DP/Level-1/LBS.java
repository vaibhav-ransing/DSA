// import java.io.*;
// import java.util.*;

// public class LBS {
//     static int[] dpInc(int arr[]){

//         int dp[] = new int[arr.length];
//         dp[0]=1;
//         for(int i=1;i<dp.length;i++){
//             for(int j=0;j<i;j++){
//                 if(arr[j]<=arr[i]){
//                     dp[i] = Math.max(dp[i], dp[j]);
//                 }
//             }
//             dp[i] += 1;
//         }
//         for(int i=0;i<dp.length;i++)
//             System.out.print(dp[i]+" ");
//         System.out.println();
//         return dp;
//     }

//     static int[] dpDec(int arr[]){

//         int dp[] = new int[arr.length];
//         dp[0]=1;
//         for(int i=1;i<dp.length;i++){
//             for(int j=0;j<i;j++){
//                 if(arr[j]>=arr[i]){
//                     dp[i] = Math.max(dp[i], dp[j]);
//                 }
//             }
//             dp[i] += 1;
//         }
//         for(int i=0;i<dp.length;i++)
//             System.out.print(dp[i]+" ");
//         System.out.println();
//         return dp;
//     }
//     public static void main(String[] args) throws Exception {

//         int arr[] = {10,22,9,33,21,50,41,60,80,1};
//         // int arr[] = {10,20,50,60,60,40,70,10};
//         int inc[] = dpInc(arr);
//         int dec[] = dpDec(arr);

//         int max=1;
//         for(int i=0;i<inc.length;i++)
//             max = Math.max(max, inc[i]+dec[i]);
//         System.out.println(max);
//     }

// }

import java.io.*;
import java.util.*;

 class f {

    public static void main(String[] args) throws Exception {
        
        // Scanner sc=new Scanner(System.in);
        // int n=sc.nextInt();

        // int arr[]=new int[n];

        // for(int i=0;i<n;i++)
        // arr[i]=sc.nextInt();
        int arr[] = {10,20,50,60,60,40,70,10};
        int n = arr.length;
        int lis[]=new int[n];

        for(int i=0;i<n;i++)
        {
            int max=0;

            for(int j=0;j<i;j++)
            {
                if(arr[i]>=arr[j])
                {
                    max=Math.max(max,lis[j]);
                }
            }

            lis[i]=max+1;
        }
        for(int i=0;i<n;i++)
            System.out.print(lis[i]+" ");
        System.out.println();
        int lds[]=new int[n];

        for(int i=n-1;i>=0;i--)
        {
            int max=0;

            for(int j=n-1;j>i;j--)
            {
                if(arr[i]>=arr[j])
                {
                    max=Math.max(max,lds[j]);
                }
            }

            lds[i]=max+1;
        }
        for(int i=0;i<n;i++)
            System.out.print(lds[i]+" ");
        System.out.println();
        int ans=0;

        for(int i=0;i<n;i++)
        ans=Math.max(ans,lds[i]+lis[i]);

        System.out.println(ans-1);
    }

}