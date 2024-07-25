package Z_DailyLC;
import java.util.*;

public class MaxTotalInportanceRoad {

    public long maximumImportance(int n, int[][] roads) {

        HashMap<Integer, Long> map = new HashMap<>();
        for (int[] edge : roads) {
            map.put(edge[0], map.getOrDefault(edge[0], 0L) + 1);
            map.put(edge[1], map.getOrDefault(edge[1], 0L) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]); // index, count
        for (int key : map.keySet()) {
            pq.add(new int[] { key, map.get(key).intValue() });
        }
        HashMap<Integer, Long> assignedMap = new HashMap<>();
        Long assVal = (long) n;
        while (pq.size() > 0) {
            int[] peek = pq.remove();
            assignedMap.put(peek[0], assVal--);
        }
        long ans = 0;
        for (int[] edge : roads) {
            ans += (long) assignedMap.get(edge[0]) + assignedMap.get(edge[1]);
        }
        return (int) ans;
    }
}
