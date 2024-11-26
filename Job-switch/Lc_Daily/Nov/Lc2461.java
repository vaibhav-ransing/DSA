package Lc_Daily.Nov;

import java.util.*;

public class Lc2461 {

    public long maximumSubarraySum(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        int i = 0;
        int j = 0;
        long max = 0;
        long sum = 0;
        while (i + k <= nums.length) {
            System.out.println((j < nums.length) + " " + (set.size() < k));
            while (j < nums.length && set.size() < k) {
                int cj = nums[j];
                while (set.contains(cj)) {
                    sum -= nums[i];
                    set.remove(nums[i++]);
                }
                sum += cj;
                set.add(nums[j++]);
            }
            if (set.size() == k) {
                max = Math.max(max, sum);
            }
            System.out.println(i + " " + j + " " + set.size() + " | " + sum);
            sum -= nums[i];
            set.remove(nums[i++]);
        }
        return max;
    }
}
