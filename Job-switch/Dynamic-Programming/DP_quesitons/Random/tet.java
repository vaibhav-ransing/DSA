
class Solution {
    public int maxScore(int[] nums) {
        Arrays.sort(nums); // Sorting is not necessary, removed if you don't need it
        boolean[] picked = new boolean[nums.length];
        int ans = helper(0, nums, picked, 1);
        return ans;
    }

    public int helper(int idx, int[] nums, boolean[] picked, int operations) {
        if (operations == (nums.length / 2) + 1) // Corrected base case
            return 0;

        int ans = 0;
        for (int i = idx; i < nums.length; i++) { // Start from idx
            if (!picked[i]) {
                for (int j = i + 1; j < nums.length; j++) { // Ensure valid pair selection
                    if (!picked[j]) {
                        int gcd = gcd(nums[i], nums[j]);

                        picked[i] = true;
                        picked[j] = true;
                        int val = operations * gcd + helper(0, nums, picked, operations + 1); // Start from 0
                        ans = Math.max(val, ans);
                        picked[i] = false;
                        picked[j] = false;
                    }
                }
            }
        }
        return ans;
    }

    public int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
}