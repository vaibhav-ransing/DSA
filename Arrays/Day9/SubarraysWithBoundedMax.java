package Day9;

public class SubarraysWithBoundedMax {

    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int si = 0, ei = 0;
        int ans = 0;
        int prev = 0;
        while (ei < nums.length) {
            int cv = nums[ei];
            if (cv >= left && cv <= right) {
                ans += (ei - si + 1);
                prev = ei - si + 1;
            } else if (cv < left) {
                ans += prev;
            } else {
                si = ei + 1;
                prev = 0;
            }
            ei++;
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
