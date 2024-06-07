package Median;

public class MedianOfTwoSorted {

    public static double findMedianSortedArrays(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        if (n1 > n2)
            return findMedianSortedArrays(arr2, arr1);
        int low = 0, high = n1;
        int median = (n1 + n2) / 2;

        while (low <= high) {
            int mid1 = (low + high) / 2; // mid1 is r1 i.e. number of elements to be taken from arr1
            int mid2 = median - mid1; // mid2 is number of elemements to be taken from arr2
            
            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE;

            if(mid1 < n1) r1 = arr1[mid1];
            if(mid2 < n2) r2 = arr2[mid2];

            if(mid1 - 1 >= 0) l1 = arr1[mid1 - 1];
            if(mid2 - 1 >= 0) l2 = arr2[mid2 - 1];

            if(l1 <= r2 && l2 <= r1){
                if((n1 + n2) % 2 == 0){
                    return (Math.max(l1, l2) + Math.min(r1, r2))/2.0;
                }else{
                    return Math.min(r1, r2);
                }
            }else if(l1 > r2){
                high = mid1-1;
            }else{
                low = mid1+1;
            }
        }
        return -1;
    }
    // 1 2 3 3 4 5 5 6 7 8

    // int[] nums1 = { 2, 3, 5, 6 }; n1 = 4 -> mid1 = 2 (l1 = 3 , r1 = 5 )
    // int[] nums2 = { 1, 3, 4, 5, 7, 8 }; n2 = 6 -> mid2 = 3 (l2 = 4 , r2 = 5 )
    // median = 5
    // 6         -> n1=1 -> mid1=0   l1 = -infy 'idx=-1'     , r1=6
    // 1 2 3 4 5 -> n2=5 -> mid2=3   l2 = 3'idx=2'          , r2=4 'idx=3'
    // median = 3

    public static double findMedianSortedArraysLinear(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        int len = nums1.length + nums2.length;
        int mid = len / 2;
        int count = 0;
        int prev = -1, curr = -1;

        while (count <= mid) {
            prev = curr;
            if (i < nums1.length && (j == nums2.length || nums1[i] < nums2[j])) {
                curr = nums1[i];
                curr = nums1[i];
                i++;
            } else {
                curr = nums2[j];
                j++;
            }
            count++;
        }
        if (len % 2 == 0) {
            return (curr + prev) / 2.0;
        } else {
            return curr;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 3, 4, 5, 7, 8 };
        int[] nums2 = { 2, 3, 5 };
        // 1 2 3 3 4 5 5 7 8
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

}
