
public class MaxRepeating {

    int maxRepeating(int[] nums, int n, int k) {
        // code here
        for (int i = 0; i < n; i++) {
            int val = nums[i] % (n + 1);
            nums[val] += (n + 1);
        }
        int maxfreq = 0, val = -1;
        for (int i = 0; i < nums.length; i++) {
            int freq = nums[i] / (n + 1);
            if (freq > maxfreq) {
                maxfreq = freq;
                val = i;
            }
        }
        return val;
    }
}
