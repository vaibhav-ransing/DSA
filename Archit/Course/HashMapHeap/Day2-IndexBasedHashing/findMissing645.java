
public class findMissing645 {

    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int val = nums[i] % (n + 1);
            nums[val - 1] += n + 1;
        }

        int ans[] = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int freq = nums[i] / (n + 1);
            if (freq > 1)
                ans[0] = i + 1;
            if (freq == 0)
                ans[1] = i + 1;
        }
        return ans;
    }
}
