public class LongestSubarrayOf_1 {

    public int longestSubarray(int[] nums) {
        int prev_0 = -1;
        int i = 0, j = 0;
        int ans = 0;
        while (j < nums.length) {
            if (nums[j] == 0) {
                i = prev_0 + 1;
                prev_0 = j;
            }
            ans = Math.max(ans, j - i);
            j++;
        }
        int n = nums.length;
        return ans == n ? n - 1 : ans;
    }
}
