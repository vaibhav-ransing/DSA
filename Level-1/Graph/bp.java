import java.io.*;
import java.util.*;

public class bp {
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
    static class pair{  
        int side;
        int vertex;
        pair(int vertex , int side){
            this.vertex = vertex;
            this.side = side;
        }
    }
    
    static void isBipartite(ArrayList<Edge>[] graph, int vtces){
        
        Boolean ans = true;
        boolean visited[] = new boolean[vtces];
        int oddEven[] = new int[vtces]; 
        for(int i=0;i<vtces;i++){
            if(visited[i]==false){
                pair p = new pair(i, 1);
                ArrayDeque<pair> queue = new ArrayDeque<>();
                queue.add(p);
                while(queue.size()>0){
                    pair peek = queue.pop();
                    int vertex = peek.vertex;

                    if(visited[vertex]){
                        if(oddEven[vertex]!= peek.side){
                            System.out.println("false");
                            return;
                        }
                    }
                    oddEven[vertex] = peek.side;
                    visited[vertex] = true;
                    for(Edge e: graph[vertex]){
                        int nbr = e.nbr;
                        if(visited[nbr]==false){
                            int val = 1;
                            if(peek.side==1)
                                val = 2;
                            pair np = new pair(e.nbr, val);
                            queue.push(np);
                        }
                    }
                }
            }
        }
        System.out.println("true");
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
      isBipartite(graph, vtces);
      
   }
}