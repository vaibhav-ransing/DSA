package DoLastWeek.Repeating;

import java.util.TreeMap;
import java.util.TreeSet;

public class StreamInputCheck3Pair {
    // We need to find a set of 3 values which satisfy condition - |a - b| <= D, |b
    // - c| <= D, |a - c| <= D, assuming a,b,c are 3 float values. Print these 3
    // values and remove them and continue ....

    // Constraints -
    // All values in stream will be unique.
    // D -> [0, inf)

    // Eg:
    // Input stream - [1,10,7,-2,8,....], d = 5
    // Output - (when 8 comes, then print "7 8 10" and remove them and continue)

    // class Solution {
    // private int D;
    // void init(int d) {
    // this.D = d;
    // void func(float item) {
    // // implement
    // }
    // }
    // What data structure should be used here, and what approach can be applied?

    // public static void soluion(int[] arr, int d) {
    // TreeSet<Integer> set = new TreeSet<>();
    // for (int val : arr) {
    // int ceil = -1;
    // int floor = -1;
    // if (set.ceiling(Math.abs(val - d)) != null) {
    // ceil = set.ceiling(Math.abs(val - d));
    // }
    // if (set.floor(Math.abs(val - d)) != null) {
    // floor = set.floor(Math.abs(val - d));
    // }
    // if (ceil != -1 && floor != -1) {
    // System.err.println(val + " ceil " + ceil + " floor " + floor);
    // set.remove(ceil);
    // set.remove(floor);
    // } else {
    // set.add(val);
    // }
    // }
    // }
    public static void solution(int[] arr, int d) {
        TreeSet<Integer> set = new TreeSet<>();

        for (int val : arr) {
            // Find potential values within the range [val - D, val + D]
            Integer ceil = set.ceiling(val - d); // First value >= val - d
            Integer floor = set.floor(val + d); // First value <= val + d

            if (ceil != null && floor != null) {
                // Check if both ceil and floor are within the range of D
                if (Math.abs(val - ceil) <= d && Math.abs(val - floor) <= d && Math.abs(ceil - floor) <= d) {
                    // We have a valid triplet (val, ceil, floor)
                    System.out.println("Triplet: " + val + " " + ceil + " " + floor);
                    set.remove(ceil);
                    set.remove(floor);
                    continue; // Don't add 'val' since it's part of a valid triplet
                }
            }

            // No valid triplet, so add the current value to the set
            set.add(val);
        }
    }

    // Suggested Solution
    class Solution {
        private int D;
        // tree set will help to maintain ordered list of items
        TreeSet<Float> nums;

        // TC - O(1)
        void init(int d) {
            this.D = d;
            nums = new TreeSet<>();
        }

        // TC - O(logN) where N is current items count
        void func(float item) {
            // item is middle elt in triplet
            Float a = nums.floor(item);
            Float c = nums.ceiling(item);

            if (a != null && c != null && item - a <= D && c - item <= D) {
                nums.remove(a);
                nums.remove(c);
                return;
            }

            // item is 1st elt in triplet
            a = nums.ceiling(item);
            c = a != null ? nums.ceiling(a) : null;
            if (a != null && c != null && a - item <= D && c - a <= D) {
                nums.remove(a);
                nums.remove(c);
                return;

            }

            // item is 3rd elt in triplet
            a = nums.floor(item);
            c = a != null ? nums.floor(a) : null;
            if (a != null && c != null && item - c <= D && c - a <= D) {
                nums.remove(a);
                nums.remove(c);
                return;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 10, 7, -2, 8 };
        int d = 5;
        solution(arr, d);
    }
}
