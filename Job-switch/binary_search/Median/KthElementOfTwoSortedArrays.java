package Median;

import java.util.ArrayList;
import java.util.Arrays;

public class KthElementOfTwoSortedArrays {

    public static int kthElement(ArrayList<Integer> list1, ArrayList<Integer> list2, int n, int m, int k) {

        int arr1[] = new int[list1.size()];
        for (int i = 0; i < n; i++) {
            arr1[i] = list1.get(i);
        }
        int arr2[] = new int[list2.size()];
        for (int i = 0; i < m; i++) {
            arr2[i] = list2.get(i);
        }

        int n1 = arr1.length;
        int n2 = arr2.length;
        // Handle invalid k
        if (k > n1 + n2) return -1;

        if (n1 > n2)
            return kthElement(list2, list1, m, n, k);

        // int low = 0, high = k;
        int low = Math.max(0, k - n2);  // if n1=5 and n2=4  and k=7   this means we must pick minimum of k-n2=3 elements from array1 in order to get correct answer.
        int high = Math.min(k, n1);   // if k is smaller than n1 then we can pick maximum of k elemtns from the array and not n1.
        int median = k;

        while (low <= high) {
            int mid1 = (low + high) / 2; // mid1 is r1 i.e. number of elements to be taken from arr1
            int mid2 = median - mid1; // mid2 is number of elemements to be taken from arr2
            
            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE;

            if(mid1 < n1 && mid1 >= 0) r1 = arr1[mid1];
            if(mid2 < n2 && mid2 >= 0) r2 = arr2[mid2];

            if(mid1 - 1 >= 0 && mid1 - 1 < n1) l1 = arr1[mid1 - 1];
            if(mid2 - 1 >= 0 && mid2 -1 < n2) l2 = arr2[mid2 - 1];

            if(l1 <= r2 && l2 <= r1){
                return Math.max(l1, l2);
            }else if(l1 > r2){
                high = mid1-1;
            }else{
                low = mid1+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }

}
