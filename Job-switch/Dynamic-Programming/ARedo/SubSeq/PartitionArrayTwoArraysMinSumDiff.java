import java.util.Arrays;

public class PartitionArrayTwoArraysMinSumDiff {

    public int minimumDifference(int[] nums) {
        int sum = nums.length
    }

    public int rec(int idx, int s1, int s2, int[] nums) {
        if (idx == nums.length) {
            return Math.abs(s1 - s2);
        }
        if (idx == nums.length)
            return Integer.MAX_VALUE;
        int add1 = rec(idx + 1, s1 + nums[idx], s2, nums);
        int add2 = rec(idx + 1, s1, s2 + nums[idx], nums);

        int min = Math.min(add1, add2);
        return min;
    }

    public class Solution {
        public static int minSubsetSumDifference(int[] arr, int n) {

            n = arr.length;
            int sum = Arrays.stream(arr).sum();
            boolean dp[][] = new boolean[n + 1][sum + 1];

            dp[0][0] = true;

            for (int i = 1; i < dp.length; i++) {
                for (int j = 0; j < dp[0].length; j++) {
                    if (j == 0) {
                        dp[i][j] = true;
                    } else {
                        boolean skip = dp[i - 1][j];
                        boolean take = false;
                        if (j - arr[i - 1] >= 0)
                            take = dp[i - 1][j - arr[i - 1]];
                        dp[i][j] = skip || take;
                    }
                }
            }
            int min = sum;
            for (int i = 0; i < dp[0].length; i++) {
                if (dp[dp.length - 1][i]) {
                    int rem = sum - i;
                    min = Math.min(min, Math.abs(rem - i));
                }
            }
            // [8,6,5]
            // true false false false false true true false true false false true false true
            // true false false false false true
            // 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19
            return min;
        }
    }

    public class SubsetSumDifference {

        public static int minSubsetSumDifference(int[] arr, int n) {
            int totalSum = 0;
            for (int num : arr) {
                totalSum += num;
            }
            return subsetDifference(arr, n, 0, 0, totalSum);
        }

        // Recursive function to calculate the minimum difference
        public static int subsetDifference(int[] arr, int i, int sum1, int sum2, int totalSum) {
            // Base case: if no elements are left
            if (i == arr.length) {
                return Math.abs(sum1 - sum2);
            }

            // Recur by including the current element in the first subset (sum1)
            int includeInFirstSubset = subsetDifference(arr, i + 1, sum1 + arr[i], sum2, totalSum);

            // Recur by including the current element in the second subset (sum2)
            int includeInSecondSubset = subsetDifference(arr, i + 1, sum1, sum2 + arr[i], totalSum);

            // Return the minimum difference obtained by both choices
            return Math.min(includeInFirstSubset, includeInSecondSubset);
        }

        public static void main(String[] args) {
            int[] arr = { 8, 6, 5 };
            int n = arr.length;
            System.out.println("Minimum Subset Sum Difference: " + minSubsetSumDifference(arr, n));
        }
    }

}
