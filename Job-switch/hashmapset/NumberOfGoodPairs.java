import java.util.HashMap;

public class NumberOfGoodPairs {
    
    class Solution {
        public int numIdenticalPairs(int[] nums) {
            int count = 0;
            for(int i=0; i<nums.length; i++){
                for(int j=i+1; j<nums.length; j++){
                    if(nums[i] == nums[j]) count++;
                }
            }
            return count;
        }
    }

    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for(int val : nums){
            if(map.containsKey(val)){
                count += map.get(val);
            }
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        return count;
    }
}
