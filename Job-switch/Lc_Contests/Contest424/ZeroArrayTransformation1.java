package Lc_Contests.Contest424;

import java.util.Arrays;
import java.util.TreeMap;

public class ZeroArrayTransformation1 {

    public static boolean isZeroArray(int[] nums, int[][] queries) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int[] query : queries) {
            map.put(query[0], map.getOrDefault(query[0], 0) - 1);
            map.put(query[1] + 1, map.getOrDefault(query[1], 0) + 1);
        }

        int prev = 0;
        for (int i = 0; i < nums.length; i++) {
            prev += map.getOrDefault(i, 0);
            nums[i] += prev;
        }
        System.out.println(Arrays.toString(nums));
        boolean allZeros = Arrays.stream(nums).allMatch(val -> val <= 0);
        return allZeros;
    }

    

    public static void main(String[] args) {
        int[] nums = {1,6,6,7};
    }
}
