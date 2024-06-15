import java.util.*;

public class ArrayPairSumDivisiblityProblem {

    public static boolean canPair(int[] nums, int k) {
        int n = nums.length;
        if (n % 2 == 1)
            return false;

        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] % k;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int val : nums) {
            int rem = (k - val)%k;
            // System.out.println(val + " " + rem + " " + map.containsKey(rem));
            if (map.containsKey(rem)) {
                if (map.get(rem) == 1) {
                    map.remove(rem);
                } else {
                    map.put(rem, map.get(rem) - 1);
                }
                continue;
            }
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        return map.size() == 0;
    }

    public static void main(String[] args) {
        // int arr[] = { 6, 14, 12, 14 };
        // int k = 2;
        int arr[] = {6,6,6,6};
        int k = 6;

        System.out.println(canPair(arr, k));
    }
}
