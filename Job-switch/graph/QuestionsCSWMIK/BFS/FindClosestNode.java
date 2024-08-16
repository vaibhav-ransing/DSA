package QuestionsCSWMIK.BFS;

import java.util.ArrayDeque;
import java.util.Arrays;

public class FindClosestNode {

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] dis1 = new int[n];
        int[] dis2 = new int[n];
        Arrays.fill(dis1, Integer.MAX_VALUE);
        Arrays.fill(dis2, Integer.MAX_VALUE);

        fillDisBFS(edges, node1, dis1);
        fillDisBFS(edges, node2, dis2);
        int minMaxDistance = Integer.MAX_VALUE;
        int ans = -1;
        for (int i = 0; i < n; i++) {
            if (dis1[i] == Integer.MAX_VALUE || dis2[i] == Integer.MAX_VALUE) 
                continue;
            
            int maxDistance = Math.max(dis1[i], dis2[i]);
            if (maxDistance < minMaxDistance) {
                ans = i;
                minMaxDistance = maxDistance;
            }
        }
        return ans;
    }

    public void fillDisBFS(int[] edges, int node, int[] dis) {
        ArrayDeque<int[]> queue = new ArrayDeque<>(); // curr_idx, dis
        queue.add(new int[]{ node, 0 });
        dis[node] = 0;
        while (!queue.isEmpty()) {
            int[] peek = queue.remove();
            int curr_idx = peek[0];
            int curr_dis = peek[1];
            int next = edges[curr_idx];
            if (next == -1) 
                continue;
            if (dis[next] > curr_dis + 1) {
                dis[next] = curr_dis + 1;
                queue.add(new int[]{ next, curr_dis + 1 });
            }
        }
    }
}