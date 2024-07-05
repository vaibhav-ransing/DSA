public class t {
    public boolean predictTheWinner(int[] nums) {
        // 1, 5, 233, 7
        int ans = rec(0, nums.length - 1, nums);
        return ans > 0;
    }

    public int rec(int left, int right, int[] nums) {

        if (left == right)
            return nums[left];
        return Math.max(-rec(left + 1, right, nums) + nums[left], -rec(left, right - 1, nums) + nums[right]);
    }
}
