import java.io.*;
import java.util.*;

public class iterativeDFS {
   static class Edge {
      int src;
      int nbr;

      Edge(int src, int nbr) {
         this.src = src;
         this.nbr = nbr;
      }
   }
   static class pair{
       String psf;
       int vertex;
       pair(int v, String psf){
           this.vertex = v;
           this.psf = psf;
       }
   }
   public static void BFSIterative(ArrayList<Edge>[] graph , int src){
    boolean visited[] = new boolean[graph.length];
    Stack<pair> stack = new Stack<>();
    pair p = new pair(src,""+src);
    stack.push(p);
    while(stack.size()>0) {
        pair peek = stack.pop();
        if(visited[peek.vertex])
            continue;
        visited[peek.vertex]=true;
        System.out.println(peek.vertex+"@"+peek.psf);
        for(Edge e: graph[peek.vertex]){
            if(!visited[e.nbr]){
                pair np = new pair(e.nbr, peek.psf+e.nbr);
                stack.push(np);
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

      // write your code here  
      BFSIterative(graph,src);
   }
}