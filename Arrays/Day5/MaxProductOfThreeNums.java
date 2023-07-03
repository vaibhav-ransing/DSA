import java.util.Arrays;

public class MaxProductOfThreeNums {

    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        int m1 = nums[0];
        int m2 = nums[1];

        int max = nums[n - 1];

        int secMax = nums[n - 2];
        int thirdMax = nums[n - 3];

        int maxNegative = m1*m2*max;
        int maxPositive = max*secMax*thirdMax;

        return Math.max(maxNegative, maxPositive);
    }
}
