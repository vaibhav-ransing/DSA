import java.io.*;
import java.util.*;

public class BFS {
   static class Edge {
      int src;
      int nbr;

      Edge(int src, int nbr) {
         this.src = src;
         this.nbr = nbr;
      }
   }

   static class pair{
       int vertex;
       String psf="";
       pair(int nbr , String psf){
           this.vertex = nbr;
           this.psf = psf;
       }
   }
   public static void printBSFwithPath(ArrayList<Edge>[] graph , int src){
        boolean visited[] = new boolean[graph.length];
        ArrayDeque<pair> queue = new ArrayDeque<>();
        pair p = new pair(src, "");
        queue.push(p);
        while(queue.size()>0){
            pair peek = queue.pop();
            if(visited[peek.vertex])
               continue;
            visited[peek.vertex] = true;
            System.out.println( peek.vertex+"@"+peek.psf+peek.vertex);

            for(Edge e: graph[peek.vertex]){
                int nbr = e.nbr;
                if(visited[nbr]==false){
                    pair temp = new pair(nbr, peek.psf+peek.vertex);
                    queue.add(temp);
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
         graph[v1].add(new Edge(v1, v2));
         graph[v2].add(new Edge(v2, v1));
      }

      int src = Integer.parseInt(br.readLine());
      printBSFwithPath(graph , src);
      // write your code here  
   }
}