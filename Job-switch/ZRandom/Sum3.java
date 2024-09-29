package ZRandom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Sum3 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int left = 0;
        while (left < nums.length - 1) {
            if (left > 0 && nums[left] == nums[left - 1]) {
                left++;
                continue; // Skip this iteration if the current 'left' is a duplicate
            }
            int i = left + 1, j = nums.length - 1;
            int target = -(nums[left]);
            while (i < j) {
                while (i < j && nums[i + 1] == nums[i]) {
                    i++;
                }
                while (j > i && nums[j - 1] == nums[j]) {
                    j--;
                }
                int sum = nums[i] + nums[j];
                if (sum == target) {
                    ans.add(new ArrayList<>(Arrays.asList(nums[left], nums[i], nums[j])));
                    i++;
                } else if (sum > target) {
                    j--;
                } else {
                    i++;
                }
            }
            left++;
        }
        return ans;
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> found = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int cv = nums[i];
            int rem = target - cv;
            if (found.containsKey(rem)) {
                return new int[] { i, found.get(rem) };
            }
            found.put(cv, i);
        }
        return new int[] { -1, -1 };
    }

    public List<List<Integer>> threeSumRec(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        HashSet<String> set = new HashSet<>();
        rec(0, nums, new ArrayList<>(), 0, 3, ans, "", set);
        return ans;
    }

    void rec(int idx, int[] nums, List<Integer> currList, int sum, int k, List<List<Integer>> ans, String str,
            HashSet<String> set) {
        if (k == 0) {
            if (sum == 0 && !set.contains(str)) {
                ans.add(new ArrayList<>(currList));

                set.add(str);
            }
            return;
        }
        if (idx == nums.length)
            return;
        rec(idx + 1, nums, currList, sum, k, ans, str, set);
        currList.add(nums[idx]);
        rec(idx + 1, nums, currList, sum + nums[idx], k - 1, ans,
                (str.length() == 0 ? str + nums[idx] : str + ", " + nums[idx]), set);
        currList.remove(currList.size() - 1);
    }
}
