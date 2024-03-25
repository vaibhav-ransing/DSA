import java.util.Arrays;

public class HouseRober2 {

    public static int rob(int[] nums) {
        // 2, 3, 2
        if (nums.length == 0 || nums.length == 1)
            return nums.length == 0 ? 0 : nums[0];
        if(nums.length == 2)
            return Math.max(nums[0], nums[1]);

        int startFrom0 = solutionTabulation(nums, 0, nums.length - 2);
        int startFrom1 = solutionTabulation(nums, 1, nums.length - 1);

        System.out.println(Math.max(startFrom0, startFrom1));
        return Math.max(startFrom0, startFrom1);
    }

    public static int solutionTabulation(int[] nums, int start, int end) {

        int[] dp = new int[nums.length];
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start], nums[start + 1]); // corrected line

        for (int i = 2; i <= end; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }

        System.out.println(Arrays.toString(dp));
        return dp[end];

    }

    public static void main(String[] args) {
        int[] arr = {4,1,2,7,5,3,1};
        rob(arr);
    }

}