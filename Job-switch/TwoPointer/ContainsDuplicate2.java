import java.util.HashSet;

public class ContainsDuplicate2 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        int i = 0, j = 0;
        while (j < nums.length) {
            if (set.contains(nums[j])) {
                return true;
            }
            set.add(nums[j]);
            j++;
            if (j - i > k) {
                set.remove(nums[i++]);
            }
        }
        return false;
    }
}
