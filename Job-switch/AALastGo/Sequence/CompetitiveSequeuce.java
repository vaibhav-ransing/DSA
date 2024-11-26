package AALastGo.Sequence;

import java.util.Stack;

public class CompetitiveSequeuce {
    public int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            // Input: nums = [2,4,3,3], k = 4
            // Output: [2,3,3,4]
            // we can remove elemnts
            while (stack.size() > 0 && stack.peek() > val && (stack.size() - 1 + nums.length - i) >= k) {
                stack.pop();
            }

            if (stack.size() < k) {
                stack.push(val);
            }
        }
        int[] ans = new int[k];
        int idx = ans.length - 1;
        while (stack.size() > 0) {
            ans[idx--] = stack.pop();
        }
        return ans;
    }
}
