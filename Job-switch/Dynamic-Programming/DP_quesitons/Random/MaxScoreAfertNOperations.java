import java.util.Arrays;
import java.util.HashMap;

public class MaxScoreAfertNOperations {

    public int maxScore(int[] nums) {
        Arrays.sort(nums); // Sorting is not necessary, removed if you don't need it
        boolean[] picked = new boolean[nums.length];
        HashMap<String, Integer> map = new HashMap<>();
        int ans = helper(0, nums, picked, 1, map);
        return ans;
    }

    public int helper(int idx, int[] nums, boolean[] picked, int operations, HashMap<String, Integer> map) {
        if (operations == (nums.length / 2) + 1) // Corrected base case
            return 0;
        String key = idx + "-" + Arrays.toString(picked);
        if (map.containsKey(key))
            return map.get(key);
        int ans = 0;
        for (int i = idx; i < nums.length; i++) { // Start from idx
            if (!picked[i]) {
                for (int j = i + 1; j < nums.length; j++) { // Ensure valid pair selection
                    if (!picked[j]) {
                        int gcd = gcd(nums[i], nums[j]);

                        picked[i] = true;
                        picked[j] = true;
                        int val = operations * gcd + helper(0, nums, picked, operations + 1, map); // Start from 0
                        ans = Math.max(val, ans);
                        picked[i] = false;
                        picked[j] = false;
                    }
                }
            }
        }
        // (n -> n-2 -> n-4 ... ) * 2^n (without memoization) = n! * 2^n
        // n^2 * 2^n * log(m) (with memozation) (log(m) is gcd)
        map.put(key, ans);
        return ans;
    }

    public int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {

    }
}