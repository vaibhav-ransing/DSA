import java.util.ArrayList;
import java.util.Arrays;

public class burstBaloons {
    class Solution {
        public static int maxCoins(int[] nums) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(1);
            Arrays.stream(nums).forEach(val -> list.add(val));
            list.add(1);
    
            return recursion(1, list.size() - 2, list);
        }
    
        public static int recursion(int i, int j, ArrayList<Integer> nums) {
            
            System.out.println(i +" "+ j);
            if (i > j) {
                System.out.println("Returning "+ i +" "+ j);
                return 0;
            }
            int ans = Integer.MIN_VALUE;
            for (int idx = i; idx <= j; idx++) {
                int cost = nums.get(i - 1) * nums.get(idx) * nums.get(j + 1) +
                        recursion(i, idx - 1, nums) +
                        recursion(idx + 1, j, nums);
                ans = Math.max(ans, cost);
            }
            System.out.println(i +" "+ j + " ans= "+ ans);
            return ans;
        }
    }
}
