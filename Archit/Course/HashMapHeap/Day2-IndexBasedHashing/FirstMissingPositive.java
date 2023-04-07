import java.util.HashMap;
import java.util.HashSet;

public class FirstMissingPositive {
    public int firstMissingPositive1(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int val : nums) {
            set.add(val);
        }
        for (int i = 1; i <= nums.length; i++) {
            if (i == nums.length && !set.contains(i))
                return i;
            if (!set.contains(i))
                return i;
        }
        return nums.length + 1;
    }

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int val = nums[i];
            if (val > n || val <= 0)
                nums[i] = 0;

            if(val > 0) nums[val -1] += (n+1);
        }

        for(int i = 0; i<nums.length; i++){
            int freq = nums[i]/(n+1);
            if(freq==0) return i+1;
        }
        return n+1;
    }

}