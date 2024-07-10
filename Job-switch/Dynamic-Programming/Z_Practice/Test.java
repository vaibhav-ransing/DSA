import java.util.*;

public class Test {

    public int constrainedSubsetSum(int[] arr, int k) {
        int n = arr.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]); // dp -> int idx, int val
        int dp[] = new int[n];

        for (int i = 0; i < dp.length; i++) {
            while (pq.size() > 0 && (i - pq.peek()[0]) > k) {
                pq.remove();
            }
            dp[i] = arr[i];
            if (pq.size() > 0) {
                dp[i] = Math.max(dp[i], arr[i] + pq.peek()[1]);
            }
            pq.add(new int[] { i, dp[i] });
        }
        System.out.println(Arrays.toString(dp));
        int ans = Arrays.stream(dp).max().orElse(0);
        return ans;
    }

    public int constrainedSubsetSumTLE(int[] arr, int k) {
        int n = arr.length;
        int dp[] = new int[n];

        for (int i = 0; i < dp.length; i++) {
            for (int j = (i - k < 0 ? 0 : i - k); j < i; j++) {
                dp[i] = Math.max(dp[i], dp[i] + dp[j]);
            }
            dp[i] += arr[i];
        }
        int ans = Arrays.stream(dp).max().orElse(0);
        return ans;
    }

    public int minOperations(String[] logs) {

        Stack<String> stack = new Stack<>();
        for (String dir : logs) {
            if (stack.peek().equals(dir) || dir.equals("./")) {
                continue;
            } else if (dir.equals("../") && stack.size() > 0) {
                stack.pop();
            } else {
                if (!dir.equals("../"))
                    stack.push(dir);
            }
        }
        return stack.size() - 1;
    }

}