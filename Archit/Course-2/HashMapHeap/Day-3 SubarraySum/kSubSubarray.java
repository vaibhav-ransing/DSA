import java.util.HashMap;

public class kSubSubarray {
    public int subarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, count = 0;
        for (int val : nums) {
            sum+=val;
            
            count += map.getOrDefault(sum-k, 0);

            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return count;
    }
}
