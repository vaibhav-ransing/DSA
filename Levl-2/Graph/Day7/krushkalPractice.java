import java.util.*;
import java.io.*;

public class krushkalPractice {

    public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int v = Integer.parseInt(br.readLine());
    int e = Integer.parseInt(br.readLine());

    int[][] edges = new int[e][3];
    for (int i = 0; i < e; i++) {
        String[] st = br.readLine().split(" ");
        edges[i][0] = Integer.parseInt(st[0]);
        edges[i][1] = Integer.parseInt(st[1]);
        edges[i][2] = Integer.parseInt(st[2]);
    }

    System.out.println(minCostToSupplyWater(v, edges));
    }

    

    public static class Pair implements Comparable<Pair> {
        int u;
        int v;
        int wt;

        Pair(int u, int v, int wt) {
            this.u = u;
            this.v = v;
            this.wt = wt;
        }

        @Override
        public int compareTo(Pair o) {
            return this.wt - o.wt;
        }
    }

    static int[] parent;
    static int[] rank;

    public static int minCostToSupplyWater(int n, int[][] graph) {

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int i=0; i<graph.length; i++){
            pq.add(new Pair(graph[i][0], graph[i][1], graph[i][2]));
        }
        parent = new int[graph.length];
        rank = new int[graph.length];
        for(int i=0 ;i<parent.length; i++){
            parent[i] = i;
        }
        int count = 0;
        while(pq.size()>0){
            Pair peek = pq.remove();
            int lx = find(peek.u);
            int ly = find(peek.v);
            if(lx != ly){
                union(lx, ly);
                count+=peek.wt;
            }
        }   
        return count;
    }
    static void union(int x, int y){
        if(rank[x] > rank[y]){
            parent[y] = x;
        }else if(rank[x] < rank[y]){
            parent[x] = y;
        }else{
            parent[y] = x;
            rank[x]++;
        }
    }
    static int find(int x){
        if(parent[x]==x){
            return x;
        }else{
            int temp = find(parent[x]);
            parent[x] = temp;
            return temp;
        }
    }

}
