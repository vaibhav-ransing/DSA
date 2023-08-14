package Day5;

import java.util.Arrays;

public class CountSort {

    public static void countSortStable(int[] arr){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int val : arr){
            min = Math.min(min, val);
            max = Math.max(max, val);
        }
        int d = max-min+1;
        int[] preFixArr = new int[d];
        
        for(int val : arr){
            preFixArr[val-min]++;
        }
        for(int i=1; i<arr.length; i++){
            preFixArr[i] += preFixArr[i-1];
        }

    }

    public static void countSort(int[] arr){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int val : arr){
            min = Math.min(min, val);
            max = Math.max(max, val);
        }
        int d = max-min+1;
        int[] freqArr = new int[d];
        
        for(int val : arr){
            freqArr[val-min]++;
        }

        int idx = 0;
        for(int i=0; i<freqArr.length; i++){
            int currFreq = freqArr[i];
            while(currFreq>0){
                arr[idx++] = min+i;
            }
        }
    }


    public static void main(String[] args) {
        
    }
}
