package AALastGo.Heap;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Stack;

public class TaskScheduler {

    public int leastInterval(char[] tasks, int k) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]); // character, count
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int ch : tasks) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (int ch : map.keySet()) {
            pq.add(new int[] { ch, map.get(ch) });
        }

        int ans = 0;
        while (pq.size() > 0) {
            int ck = k + 1;
            Stack<int[]> stack = new Stack<>();
            while (pq.size() > 0 && ck > 0) {
                ans++;
                ck--;
                pq.peek()[1]--;
                stack.push(pq.remove());
            }
            while (stack.size() > 0) {
                if (stack.peek()[1] > 0) {
                    pq.add(stack.pop());
                } else {
                    stack.pop();
                }
            }
            if (ck != 0 && !pq.isEmpty())
                ans += ck;
            System.out.println(ans + " | " + ck + " | " + stack.size());
        }
        return ans;
    }
}
