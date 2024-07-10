package PickNotPick;

/**
 * MaxDotProductTwoSubseq
 */
public class MaxDotProductTwoSubseq {

    Integer[][] memo; // Memoization table

    public int maxDotProduct(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        memo = new Integer[m][n]; // Initialize memoization table

        return rec(0, 0, nums1, nums2);
    }

    public int rec(int i, int j, int[] nums1, int[] nums2) {
        if (i == nums1.length || j == nums2.length) {
            return Integer.MIN_VALUE; // Base case: Out of bounds
        }

        if (memo[i][j] != null) {
            return memo[i][j]; // Return memoized result if available
        }

        // Calculate the maximum dot product starting from (i, j)
        int product = nums1[i] * nums2[j];
        int max = product;

        // Include the current product and continue recursively
        max = Math.max(max,
                product + (i + 1 < nums1.length && j + 1 < nums2.length ? rec(i + 1, j + 1, nums1, nums2) : 0));

        // Skip either element from nums1 or nums2
        max = Math.max(max, rec(i + 1, j, nums1, nums2));
        max = Math.max(max, rec(i, j + 1, nums1, nums2));

        // Memoize the result
        memo[i][j] = max;

        return max;
    }
}