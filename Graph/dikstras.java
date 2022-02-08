import java.io.*;
import java.util.*;

public class dikstras {
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
   static class pair implements Comparable<pair> {
        String psf;
        int wt;
        int vertex;
        pair(int vertex, int wt, String psf){
            this.vertex = vertex;
            this.wt = wt;
            this.psf = psf;
        }
        public int compareTo(pair o){
            return this.wt-o.wt;
        }
    }
    static void dikstrasAlgo(ArrayList<Edge>[] graph, int vtces, int src){
        boolean visited[] = new boolean[vtces];
        String ans = "";
        for(int i=0; i<vtces;i++){
            if(visited[i]==false){
                PriorityQueue<pair> pq = new PriorityQueue<>();
                pair p =new pair(i, 0,""+i);
                pq.add(p);
                while(pq.size()>0){

                    pair peek = pq.remove();

                    if(visited[peek.vertex])
                        continue;   
                    visited[peek.vertex]=true;
                     System.out.println(peek.vertex+" via "+peek.psf+" @ "+peek.wt);

                    for(Edge e: graph[peek.vertex]){
                        int wt = peek.wt+ e.wt;
                        String psf = peek.psf+e.nbr;
                        pair np = new pair(e.nbr, wt, psf);
                        pq.add(np);
                    }
                }
            }
        }
        // System.out.println("No such path");
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

      int src = Integer.parseInt(br.readLine());
      // write your code here
      dikstrasAlgo(graph , vtces,src);
      
   }
}