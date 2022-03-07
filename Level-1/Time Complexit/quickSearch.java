import java.io.*;
import java.util.*;

public class quickSearch {

  public static int quickSelect(int[] arr, int lo, int hi, int k) {
    //write your code here
    if(lo==hi)
        return arr[lo];

    int pIndex= partition(arr, lo, hi, arr[hi]);
    if(pIndex==k)
        return arr[pIndex];
    else if(pIndex<k){
        return quickSelect(arr, pIndex+1, hi, k);
    }
    else return quickSelect(arr, lo, pIndex-1, k);
    
  }
  public static int partition(int arr[], int lo, int hi, int p){
        System.out.println("pivot -> " + p);
        int i=lo;
        int j=lo;
        while(j<=hi){
            if(arr[j]>p)
                j++;
            else{
                swap(arr, j, i);
                i++;
                j++;
            }
        }
        System.out.println("pivot index -> " + (i - 1));
        return i-1;
  }
  

  // used for swapping ith and jth elements of array
  public static void swap(int[] arr, int i, int j) {
    System.out.println("Swapping " + arr[i] + " and " + arr[j]);
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void print(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    int k = scn.nextInt();
    System.out.println(quickSelect(arr,0,arr.length - 1,k - 1));
    // int arr[] = {17,9,3,2,6,8,5};
    // int arr[] = {7,-2,4,1,3};
    // System.out.println(quickSelect(arr, 0, arr.length-1, 2));
  }

}
