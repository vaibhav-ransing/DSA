package QuestionsCSWMIK.BruteForce;
            
import java.util.*;

public class FindCrticalAndPseudoCriticalEdges {

    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        ans.add(new ArrayList<>());
        int globalMin = primsAlgo(n, edges, -1);

        for (int i = 0; i < edges.length; i++) {
            int currMST = primsAlgo(n, edges, i);
            if (currMST > globalMin) {
                ans.get(0).add(i);
            } else {
                int keepEdge = primsAlgoMustInclude(n, edges, i);
                if (keepEdge == globalMin) {
                    ans.get(1).add(i);
                }
            }
        }

        return ans;
    }

    public int primsAlgoMustInclude(int n, int[][] edges, int includeIdx) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        int cost = 0;
        DSU ds = new DSU(n);
        cost += ds.union(edges[includeIdx][0], edges[includeIdx][1], edges[includeIdx][2]);

        for (int i = 0; i < edges.length; i++) {
            if (i != includeIdx) {
                pq.add(edges[i]);
            }
        }

        while (!pq.isEmpty()) {
            int[] edge = pq.poll();
            cost += ds.union(edge[0], edge[1], edge[2]);
        }

        return ds.count == 1 ? cost : Integer.MAX_VALUE;
    }

    public int primsAlgo(int n, int[][] edges, int skipIdx) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        for (int i = 0; i < edges.length; i++) {
            if (i != skipIdx) {
                pq.add(edges[i]);
            }
        }

        int cost = 0;
        DSU ds = new DSU(n);
        while (!pq.isEmpty()) {
            int[] edge = pq.poll();
            cost += ds.union(edge[0], edge[1], edge[2]);
        }

        return ds.count == 1 ? cost : Integer.MAX_VALUE;
    }

    class DSU {
        int[] par;
        int n;
        int count;

        DSU(int n) {
            this.n = n;
            this.par = new int[n];
            this.count = n;
            for (int i = 0; i < n; i++) {
                par[i] = i;
            }
        }

        int find(int x) {
            if (par[x] == x)
                return x;
            return par[x] = find(par[x]);
        }

        int union(int x, int y, int cost) {
            if (find(x) == find(y))
                return 0;
            par[find(x)] = find(y);
            count--;
            return cost;
        }
    }
}
