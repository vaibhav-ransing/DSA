import java.io.*;
import java.util.*;

 class dateSort {

  public static void sortDates(String[] arr) {
    // write your code here
    // 11081987,   12041989
    // 11 08 1987, 12 04 1989
    countSort(arr, 1000000, 100, 2);
    countSort(arr, 10000, 100, 2);
    countSort(arr, 1, 10000, 4);
    
    for(int i=0;i<arr.length;i++)
        System.out.print(arr[i]+" ");
  }

  public static void countSort(String[] arr,int div, int mod, int range) {
    // write your code here   
    String ans[] = new String[arr.length];
    for(int k=0;k<range;k++){
            
        int freqArr[] = new int[10];
      
        for(int i=0;i<arr.length;i++){
            int ind = ((Integer.parseInt(arr[i])/div) /((int)(Math.pow(10, k)) ))%10;
            freqArr[ind]+=1;
        }
        for(int i=1;i<freqArr.length;i++){
            freqArr[i]+=freqArr[i-1];
        }
        // 11081987,   12041989
        for(int i=arr.length-1; i>=0;i--){
            int val = ((Integer.parseInt(arr[i])/div) /(1* (int)(Math.pow(10, k))))%10;
            int pos = freqArr[val]--;
            ans[pos-1]=  arr[i];
    }
    for(int i=0;i<arr.length;i++)
        arr[i] = ans[i];
        }
  }

  public static void print(String[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }

  public static void main(String[] args) throws Exception {
    // String arr[] = {"12041996","20101996","05061997","12041989","11081987"};
    // // String arr[] = {"1724","1963","1685"};
    // sortDates(arr);
    // // print(arr);
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    String[] arr = new String[n];
    for (int i = 0; i < n; i++) {
      String str = scn.next();
      arr[i] = str;
    }
    sortDates(arr);
  }

}