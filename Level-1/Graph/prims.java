import java.io.*;
import java.lang.management.ThreadInfo;
import java.util.*;

public class prims {
   static class Edge {
      int src;
      int nbr;
      int wt;

      Edge(int src, int nbr, int wt) {
         this.src = src;
         this.nbr = nbr;
         this.wt = wt;
      }
   }

   static class pair implements Comparable<pair>{ 
        int vertex;
        int pv;
        int wt;
        pair(int v,int pv, int wt){
            this.vertex = v;
            this.pv = pv;
            this.wt = wt;
        }
        public int compareTo(pair o){
            return this.wt - o.wt;
        }
   }
   static void primsAlgo(ArrayList<Edge>[] graph, int src){ 
        boolean visited[] = new boolean[graph.length];
        ArrayDeque<pair> queue = new ArrayDeque<>();
        queue.add(new pair(0, -1, 0));
        while(queue.size()>0){
            pair peek = queue.pop();
            if(visited[peek.vertex])
                continue;
            visited[peek.vertex] = true;
            if(peek.pv !=-1)
                System.out.println("["+peek.vertex+"-"+peek.pv+"@"+peek.wt+"]");
            for(Edge e: graph[peek.vertex]){
                if(visited[e.nbr]==false){
                    queue.add(new pair(e.nbr, peek.vertex, e.wt));
                }
            }
        }
    }

   


   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }

      // write your code here
      
   }
}