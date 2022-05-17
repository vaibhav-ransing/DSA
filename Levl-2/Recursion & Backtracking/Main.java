import java.io.*;
import java.util.*;

public class Main {

    static void soln(int arr[]){
        int dp[] = new int[arr.length];
        // 5 6 1 7 4
        for(int i=1; i<dp.length; i++){
            int val =0;
            boolean hasSmaller = false;
            for(int j=0; j<i; j++){
                if(arr[j]>arr[i]){
                    // val+=1;
                    System.out.println(arr[j]+" "+arr[i]);
                    hasSmaller = true;
                    dp[i]+=1;
                }
            }
            dp[i] = hasSmaller? Math.min(dp[i-1]+1, dp[i]): dp[i-1];
        }
        for(int val: dp)
            System.out.print(val+" ");
    }

    public static void main(String[] args) {
        // int arr[] = {5,6,1,7,4};
        int arr[] = {6, 23, 49, 49, 21, 41, 30, 13, 17};
        soln(arr);
    }
}