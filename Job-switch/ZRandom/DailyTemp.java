package ZRandom;

import java.util.Stack;

public class DailyTemp {
    public int[] dailyTemperatures(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<int[]> stack = new Stack<>();
        stack.add(new int[] { arr[n - 1], n - 1 });

        for (int i = n - 2; i >= 0; i--) {
            int cv = arr[i];
            while (stack.size() > 0 && stack.peek()[0] < cv) {
                stack.pop();
            }
            if (stack.size() != 0) {
                ans[i] = stack.peek()[1] - i;
            }
            stack.add(new int[] { cv, i });
        }
        return ans;
    }
}
