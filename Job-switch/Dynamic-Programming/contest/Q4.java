import java.util.HashMap;
import java.util.HashSet;

public class Q4 {

    public long countSubarrays(int[] nums, int k) {
        HashMap<Integer, Integer> prevMap = new HashMap<>();
        long ans = 0;

        for (int i = 0; i < nums.length; i++) {
            int cv = nums[i];
            if (cv == k)
                ans++;
            HashMap<Integer, Integer> currMap = new HashMap<>();

            for (int key : prevMap.keySet()) {
                int andVal = key & cv;
                if (andVal == k) {
                    ans += prevMap.get(key);
                }
                currMap.put(andVal, currMap.getOrDefault(andVal, 0) + prevMap.get(key));
            }
            currMap.put(cv, currMap.getOrDefault(cv, 0) + 1);
            prevMap = currMap;
        }
        return ans;
    }

    // public long countSubarrays(int[] nums, int k) {
    //     HashMap<Integer, Integer> map = new HashMap<>();
    //     long ans = 0;

    //     for (int i = 0; i < nums.length; i++) {
    //         int cv = nums[i];
    //         HashMap<Integer, Integer> newMap = new HashMap<>(map); // Use a new map for updates

    //         if (cv == k)
    //             ans++;

    //         for (int key : map.keySet()) {
    //             int andVal = key & cv;
    //             if (andVal == k) {
    //                 ans += map.get(key);
    //             }
    //             newMap.put(andVal, newMap.getOrDefault(andVal, 0) + map.get(key));
    //         }
    //         newMap.put(cv, newMap.getOrDefault(cv, 0) + 1);

    //         map = newMap; // Update the original map with the new values
    //     }
    //     return ans;
    // }

}
