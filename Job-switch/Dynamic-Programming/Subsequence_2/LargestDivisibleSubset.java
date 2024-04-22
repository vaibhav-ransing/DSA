package Subsequence_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LargestDivisibleSubset {

    public static List<Integer> divisibleSet(int[] arr) {

        return null;
    }

    static List<Integer> ans;

    public static List<Integer> largestDivisibleSubset(int[] nums) {
        ans = new ArrayList<>();
        List<Integer> dp[][] = new ArrayList[nums.length][nums.length];
        Arrays.sort(nums);
        sorted_recursion(0, -1, new ArrayList<>(), nums, dp);
        System.out.println(ans);
        return ans;
    }
    
 
    public static int LisBinarySearch(int[] nums) {
        // [10,11,2,5,3,7,101,18]
        int[] tails = new int[nums.length];
        int len = 0;
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

    public static List<Integer> sorted_recursion(int idx, int pre_idx, List<Integer> list, int[] nums,
            List<Integer> dp[][]) {

        if (idx == nums.length) {
            if (ans.size() < list.size())
                ans = new ArrayList<>(list);
            return list;
        }

        if (dp[idx][pre_idx + 1] != null)
            return dp[idx][pre_idx + 1];

        // 1, 2, 3
        List<Integer> skip = sorted_recursion(idx + 1, pre_idx, list, nums, dp);
        List<Integer> take = null;

        if (pre_idx == -1 || nums[idx] % nums[pre_idx] == 0) {
            list.add(nums[idx]);
            take = sorted_recursion(idx + 1, idx, list, nums, dp);
            list.remove(list.size() - 1);
        }
        return dp[idx][pre_idx + 1] = new ArrayList<>(take != null && take.size() > skip.size() ? take : skip);
    }

    public static List<Integer> recursion(int idx, int pre_idx, List<Integer> list, int[] nums) {
        if (idx == nums.length) {
            if (ans.size() < list.size())
                ans = new ArrayList<>(list);
            return list;
        }

        List<Integer> skip = recursion(idx + 1, pre_idx, list, nums);
        List<Integer> take = null;

        if (pre_idx == -1 || nums[idx] % nums[pre_idx] == 0 || nums[pre_idx] % nums[idx] == 0) {
            list.add(nums[idx]);
            take = recursion(idx + 1, idx, list, nums);
            list.remove(list.size() - 1);
        }
        return take != null && take.size() > skip.size() ? take : skip;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 4, 6, 8, 10 };
        largestDivisibleSubset(nums);
    }
}
