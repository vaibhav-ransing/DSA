import java.util.Arrays;

public class test {
    

    public static int splitArray(int[] nums, int k) {
        int[] kSizeArr = new int[k];

        return recursion(nums, nums.length-1, kSizeArr, k);
    }

    public static int recursion(int[] nums, int idx, int[] kSizeArr, int k) {
        if (idx < 0) {
            System.out.println(Arrays.toString(kSizeArr));
            return Arrays.stream(kSizeArr).max().orElse(Integer.MIN_VALUE);
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            kSizeArr[i] += nums[idx];
            int val = recursion(nums, idx - 1, kSizeArr, k);
            ans = Math.min(ans, val);
            kSizeArr[i] -= nums[idx];
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {7,2,5,10,8};
        int k = 2;

        splitArray(nums, k);
    }
}
