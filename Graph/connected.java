import java.io.*;
import java.util.*;

import javax.swing.event.AncestorEvent;

public class connected {
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
   static boolean isConnected(ArrayList<Edge>[] graph){

    boolean[] visited = new boolean[graph.length];
    ArrayDeque<Integer> queue = new ArrayDeque<>();
    queue.add(0);
    while(queue.size()>0){
        int peek = queue.remove();
        if(visited[peek])
            continue;
        visited[peek] = true;
        for(Edge e: graph[peek]){
            if(visited[e.nbr]==false){
                queue.add(e.nbr);
            }
        }
    }
    for(int i=0;i<visited.length;i++){
        if(visited[i]==false)
            return false;
    }
    return false;
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