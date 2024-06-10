import java.util.HashMap;

class Solution {

    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int prefixSum = 0;
        int ans = 0;
        for (int val : nums) {
            prefixSum += val;
            int moudlo = prefixSum % k;
            moudlo = moudlo < 0 ? (moudlo + k) : moudlo;
            if(map.containsKey(moudlo)){
                ans += map.get(moudlo);
                map.put(moudlo, map.get(moudlo) + 1);
            }else{
                map.put(moudlo, 1);
            }
        }
        return ans;
    }
}