package Subsequence;

import java.util.Arrays;

public class temp{

    public static int minimumDifference(int[] arr) {

        int n = arr.length;
        return Math.abs(recursion(arr, n - 1, 0, 0));
    }

    public static int recursion(int[] arr, int idx, int v1, int v2) {

        if (idx < 0) {
            return (v1 - v2);
        }
            
        int t1 = recursion(arr, idx - 1, v1 + arr[idx], v2);
        int t2 = recursion(arr, idx - 1, v1, v2 + arr[idx] );

        int diff = Math.min(t1,t2);
        return diff;
    }


    public static void main(String[] args) {
        System.out.println("hello");
    }
}