package Picking;

import java.util.*;

public class MakeArrIncresing {

    HashMap<String, Integer> map;

    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        Arrays.sort(arr2);
        map = new HashMap<>();
        int ops = helper(arr1, arr2, 0, -1);
        return ops == Integer.MAX_VALUE ? -1 : ops;
    }

    public int helper(int[] arr1, int[] arr2, int idx, int prev) {
        if (idx == arr1.length) {
            return 0;
        }

        String key = idx + "-" + prev;
        if (map.containsKey(key))
            return map.get(key);

        int r1 = Integer.MAX_VALUE;
        if (prev < arr1[idx]) {
            r1 = helper(arr1, arr2, idx + 1, arr1[idx]);
        }

        // Find just greater value of prev from arry2
        // pass that just greater value for next iteration
        int ubOfCurr = upper_bound(prev, arr2);
        int r2 = Integer.MAX_VALUE;
        if (ubOfCurr != arr2.length)
            r2 = helper(arr1, arr2, idx + 1, arr2[ubOfCurr]);

        if (r2 == Integer.MAX_VALUE) {// adding 1 to max will give -ve overflow
            map.put(key, r1);
            return r1;
        } else {
            map.put(key, Math.min(r1, r2 + 1));
            return Math.min(r1, 1 + r2);
        }
    }

    public int upper_bound(int prev, int[] arr) {
        int low = 0, high = arr.length - 1;
        // 1,2,3,4 prev = 1
        while (low <= high) {
            int mid = (low + high) / 2;
            if (prev >= arr[mid]) {
                low = mid + 1;
            } else { // prev < arr[mid]
                high = mid - 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4 };
        int prev = 2;
    }
}