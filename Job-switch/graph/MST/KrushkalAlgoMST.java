package MST;
import java.util.*;

public class KrushkalAlgoMST {

    class Pair implements Comparable<Pair> {
        int u;
        int v;
        int wt;

        public Pair(int u, int v, int wt) {
            this.u = u;
            this.v = v;
            this.wt = wt;
        }

        public int compareTo(Pair o) {
            return this.wt - o.wt;
        }
    }

    class DSU {
        int n;
        int[] parent;
        int[] size;

        DSU(int n){
            this.n = n;
            parent = new int[n];
            size = new int[n];
        }
        
    }

    public static int getMinimumCost(int n, int m, int[][] connections) {
        n = n + 1;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
    }
}