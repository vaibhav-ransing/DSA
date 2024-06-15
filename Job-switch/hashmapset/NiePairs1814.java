import java.util.HashMap;

public class NiePairs1814 {

    public static int countNicePairs(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int MOD = 1000000007;
        for (int val : nums) {
            int rev = rev(val);
            int key = (val -rev)%MOD;
            if(map.containsKey(key)){
                count += map.get(key);
            }
            map.put(key, map.getOrDefault(key, 0)+1);
        }
        return count;
    }

    public static int rev(int num) {
        int ans = 0;
        while (num != 0) {
            ans = (ans * 10) + (num % 10);
            num = num / 10;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(rev(1230));
    }
}
