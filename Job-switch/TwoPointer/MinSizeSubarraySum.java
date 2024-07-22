public class MinSizeSubarraySum {

    public int minSubArrayLen(int target, int[] arr) {
        int l = 0, r = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        while (r < arr.length) {
            sum += arr[r];
            while (sum >= target) {
                ans = Math.min(ans, r - l + 1);
                sum -= arr[l++];
            }
            r++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
