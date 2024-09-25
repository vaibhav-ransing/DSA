package BinaryIndexTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountSmallerNumberToRight {

    public static List<Integer> countSmaller(int[] nums) {
        int[][] arr = new int[nums.length][]; // val, idx
        for (int i = 0; i < nums.length; i++) {
            arr[i] = new int[] { nums[i], i };
        }
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        BIT bit = new BIT(nums.length);
        int[] temp = new int[nums.length];
        for (int[] a : arr) {
            bit.update(1, a[1]); // add 1 to index of a
            System.out.println(Arrays.toString(bit.arr));
            int count = bit.sum(temp.length - 1) - bit.sum(a[1]);
            System.out.println(bit.sum(a[1]) + " " + bit.sum(a[1]));
            temp[a[1]] = count;
        }

        List<Integer> ans = new ArrayList<>();
        for (int val : temp) {
            ans.add(val);
        }
        return ans;
    }

    public static List<Integer> countSmaller2(int[] nums) {
        // Step 1: Coordinate compression to map the values in nums to ranks.
        int[][] arr = new int[nums.length][]; // val, idx
        for (int i = 0; i < nums.length; i++) {
            arr[i] = new int[] { nums[i], i };
        }
        for (int[] a : arr) {
            System.out.print(Arrays.toString(a) + " | ");
        }
        // Sort the array by value (for rank mapping).
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        System.out.println();
        for (int[] a : arr) {
            System.out.print(Arrays.toString(a) + " | ");
        }

        // Map the ranks: smaller values will have smaller ranks.
        int[] rank = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            rank[arr[i][1]] = i + 1; // Ranks start from 1 in BIT.
        }
        System.out.println();
        System.out.println("Rank= " + Arrays.toString(rank));
        // Step 2: Use BIT to count smaller elements to the right.
        BIT bit = new BIT(nums.length);
        int[] temp = new int[nums.length];

        // Traverse from right to left in nums.
        for (int i = nums.length - 1; i >= 0; i--) {
            // Query how many elements are smaller than the current element (i.e., with a
            // smaller rank).
            temp[i] = bit.sum(rank[i] - 1); // Sum of all smaller elements.
            System.out.println(rank[i] - 1 + " temp[i]= " + temp[i]);
            // Update BIT with the current element's rank.
            bit.update(rank[i], 1);
            System.out.println(Arrays.toString(bit.arr));
        }

        // Convert the result to a list.
        List<Integer> ans = new ArrayList<>();
        for (int val : temp) {
            ans.add(val);
        }
        return ans;
    }

    // we will recieve 0 based index values as input
    static class BIT {
        int[] arr;

        BIT(int n) {
            arr = new int[n + 1];
        }

        // Add 'val' at index 'i' in BIT.
        void update(int i, int val) {
            while (i < arr.length) {
                arr[i] += val;
                i += (i & -i); // Move to parent.
            }
        }

        // Return prefix sum up to index 'i'.
        int sum(int i) {
            int sum = 0;
            while (i > 0) {
                sum += arr[i];
                i -= (i & -i); // Move to parent.
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        // int[] arr = new int[] { 5, 2, 6, 1 };
        int[] arr = new int[] { 30, 25, 18, 40 };
        System.out.println(countSmaller2(arr));
    }
}
