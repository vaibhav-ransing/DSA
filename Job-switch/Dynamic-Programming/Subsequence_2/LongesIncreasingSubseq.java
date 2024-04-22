package Subsequence_2;

import java.util.ArrayList;
import java.util.Arrays;

public class LongesIncreasingSubseq {

    public static int LisBinarySearch(int[] nums) {
        // [10,11,2,5,3,7,101,18]
        int[] tails = new int[nums.length];
        int len = 1;
        tails[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > tails[len - 1]) {
                tails[len++] = nums[i];
            } else {
                int idx = Arrays.binarySearch(tails, 0, len - 1, nums[i]);
                if (idx < 0) {
                    // idx < 0 in arrays.binarySearch means there was no nums[i] found in tails array
                    // it will return a -x index which mean if there was a value nums[i] where it should have been placed
                    // tail = [2, 4, 5, 0, 0]  and nums[i] = 3   -> binarySearch returns -3
                    idx = -idx;
                    idx = idx - 1;
                }
                tails[idx] = nums[i];
            }
        }
        return len;
    }


    public static int LIS_bnarry_search(int[] nums) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            // 3, 5, 6, 2, 5, 4, 19, 5, 6, 7, 12
            int binaryIdx = binar_search(arr, nums[i]);
            if (binaryIdx == arr.size()) {
                arr.add(nums[i]);
            } else if (binaryIdx == 0) {
                if (arr.get(0) < nums[i])
                    binaryIdx += 1;
                arr.set(binaryIdx, nums[i]);
            } else {
                arr.set(binaryIdx, nums[i]);
            }
            System.out.println(i + " " + arr);
        }
        System.out.println(arr.size());
        return 0;
    }


    public static int binar_search(ArrayList<Integer> arr, int val) {
        int left = 0, right = arr.size() - 1;
        int mid = (left + right) / 2;
        if (val > arr.get(right))
            return right + 1;

        while (left <= right) {
            if (arr.get(mid) == val) {
                return mid;
                // 1 3 5 8 9
                // 11
            } else if (arr.get(mid) > val) {
                right = mid - 1;
                if (mid - 1 >= 0 && arr.get(mid - 1) < val)
                    return mid - 1;
            } else {
                left = mid + 1;
                if (mid + 1 < arr.size() && arr.get(mid + 1) > val)
                    return mid + 1;
            }
            mid = (left + right) / 2;
        }
        return mid;
    }


    public static int LIS_beetter_approach(int nums[]) {
        int n = nums.length;
        int dp[] = new int[n];
        int hash[] = new int[n];
        Arrays.fill(hash, -1);
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                int pre_dp_i = dp[i];
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    if (pre_dp_i != dp[i]) // this is actually not needed.
                        hash[i] = j;
                }
            }
        }

        System.out.println(Arrays.toString(hash));
        System.out.println(Arrays.toString(dp));
        return Arrays.stream(dp).max().orElse(0);
    }


    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n][n + 1];
        Arrays.stream(dp).forEach(row -> Arrays.fill(row, -1));
        // int ans = recursion(n - 1, n, nums, dp);
        int ans = recursion_fron_0(0, -1, nums, dp);
        return ans;
    }

    
    // // starting from 0 -> n
    public static int recursion_fron_0(int currIdx, int prevIdx, int[] nums, int dp[][]) {

        if (currIdx == nums.length)
            return 0;
        if (prevIdx != -1 && dp[currIdx][prevIdx] != -1)
            return dp[currIdx][prevIdx];
        int take = 0;
        if (prevIdx == -1 || nums[prevIdx] < nums[currIdx]) {
            take = 1 + recursion_fron_0(currIdx + 1, currIdx, nums, dp);
        }
        int skip = recursion_fron_0(currIdx + 1, prevIdx, nums, dp);

        return dp[currIdx][prevIdx == -1 ? 0 : prevIdx] = Math.max(take, skip);
    }

    public static int tabulation0toN(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n + 1][n + 1];
        // int ans = helper(0, -1, nums, dp);
        // we are starting from 0, -1 we can increase the index of prevIdx by 1

        for (int currIdx = n - 1; currIdx >= 0; currIdx--) {
            for (int prevIdx = currIdx - 1; prevIdx >= -1; prevIdx--) {
                int take = 0;
                if (prevIdx == -1 || nums[prevIdx] < nums[currIdx]) {
                    // in this for row we are doing currIdx + 1
                    // We increase the cound of prev_idx by 1 and row resembles prevIdx
                    // so we do currIdx + 1
                    take = 1 + dp[currIdx + 1][currIdx + 1]; // here we did
                }
                int skip = dp[currIdx + 1][prevIdx + 1];
                dp[currIdx][prevIdx + 1] = Math.max(take, skip);
            }
        }
        return dp[0][-1 + 1];
    }

    // Strating from n -> 0
    public static int recursion(int idx, int next, int[] nums, int dp[][]) {
        if (idx < 0)
            return 0;
        if (dp[idx][next] != -1)
            return dp[idx][next];

        int take = 0;
        if (next == nums.length || nums[idx] < nums[next]) {
            // 2 5 3 7 11 9
            // if we take 9 and pass it further
            // then at 11 if wont fall into if condition
            // at 7 it will and if we take 7 then 7 is passed,
            // so all smaller to 7 will be selected.
            take = 1 + recursion(idx - 1, idx, nums, dp);
        }
        // we start next with infinity
        // so every element will get a chance to be picked.
        int skip = recursion(idx - 1, next, nums, dp);
        return dp[idx][next] = Math.max(take, skip);
    }

    public static int tabulation(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n + 1][n + 1];

        for (int idx = 0; idx < n; idx++) {
            int take = 0;

            for (int next = idx; next < n; next++) {
                if (nums[idx] < nums[next]) {
                    take = 1 + dp[idx - 1][idx];
                }
                int skip = dp[idx - 1][next];
            }

        }
        return 0;
    }

    public static void main(String[] args) {
        // int nums[] = { 11, 5, 3, 7, 11, 9, 2 };
        // System.out.println(lengthOfLIS(nums));
        // int nums[] = { 5, 4, 11, 1, 16, 18 };
        // LIS_bestSoln(nums);
        // ArrayList<Integer> arr = (ArrayList<Integer>) Arrays.asList(1, 3, 5, 8, 9);

        ArrayList<Integer> arr = new ArrayList<>();
        int nums[] = { 3, 5, 6, 2, 5, 4, 19, 5, 6, 7, 12 };
        arr.add(1);
        arr.add(3);
        arr.add(5);
        arr.add(8);
        arr.add(9);
        LIS_bnarry_search(nums);
    }

}