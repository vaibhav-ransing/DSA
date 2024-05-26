package MST;

import java.util.*;
import java.util.stream.IntStream;

public class MinCostToConnectAllPoints {

    class DSU {
        int[] parent;
        int[] size;

        DSU(int n) {
            parent = new int[n];
            size = new int[n];
            IntStream.range(0, n).forEach(i -> parent[i] = i);
            Arrays.fill(size, 1);
        }

        int findParent(int x) {
            if (parent[x] == x)
                return x;
            return parent[x] = findParent(parent[x]);
        }

        void unionNeeded(int x, int y) {

            int xx = findParent(x);
            int yy = findParent(y);
            if (xx == yy)
                return;

            if (size[xx] > size[yy]) {
                parent[yy] = xx;
                size[xx] += size[yy];
            } else {
                parent[xx] = yy;
                size[yy] += size[xx];
            }
        }

    }

    public int minCostConnectPoints(int[][] point) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        int n = point.length;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int cost = Math.abs(point[i][0]-point[j][0])+Math.abs(point[i][1]-point[j][1]);
                pq.add(new int[] {i, j, cost});
            }
        }
        DSU ds = new DSU(n);
        int ans = 0;
        while (pq.size() > 0) {
            int[] top = pq.remove();
            if(ds.parent[top[0]] != ds.parent[top[1]]){
                ans += top[2];
            }
            ds.unionNeeded(top[0], top[1]);
        }
        return ans;
    }
}