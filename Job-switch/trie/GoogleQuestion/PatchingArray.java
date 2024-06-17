package GoogleQuestion;

public class PatchingArray {

    public int minPatches(int[] nums, int n) {

        long k = 1;
        int i = 0, m = nums.length;
        int ans = 0;
        while (k < n) {

            if (i < m && k >= nums[i]) {
                i++;
                k += nums[i];
            } else {
                ans++;
                k += k;
            }
        }
        return ans;
    }

}