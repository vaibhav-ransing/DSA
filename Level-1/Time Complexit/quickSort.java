import java.io.*;
import java.util.*;

public class quickSort {

  public static void quickSort(int[] arr, int lo, int hi) {
    //write your code here\
    if(lo>hi)
        return;
    int pivot = arr[hi];
    int index = partition(arr, pivot, lo, hi);
    quickSort(arr, index+1, hi);
    quickSort(arr, lo, index-1);
  }

  public static int partition(int[] arr, int pivot, int lo, int hi) {
    System.out.println("pivot -> " + pivot);
    int i=lo;
    int j=lo;

    while(j<=hi){
        if(arr[j]>pivot)
            j++;
        else{
            swap(arr, i, j);
            i++;
            j++;
        }
    }
    System.out.println("pivot index -> " + (j - 1));
    return j-1;
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
    quickSort(arr, 0, arr.length - 1);
    print(arr);
  }

}