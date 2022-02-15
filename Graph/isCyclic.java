import java.io.*;
import java.util.*;

public class isCyclic {
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
   public static boolean cycle(ArrayList<Edge>[] graph){
        int[] visited = new int[graph.length];

       for(int i=0;i<graph.length;i++){
        if(visited[i]==0){
            if(helper(graph, visited, i))
                return true;
        }
       }
       return false;
   }
   public static boolean helper(ArrayList<Edge>[] graph,int[] visited, int vertex ){
        visited[vertex]++;
        boolean ans =false;
        for(Edge e: graph[vertex]){
            if(visited[e.nbr]==0){
                ans = helper(graph, visited, e.nbr);
            }else if(visited[e.nbr]==1){
                visited[e.nbr]++;
            }else 
                return true;
        }
        return ans;
   }
   public static boolean cycle3(ArrayList<Edge>[] graph){
    boolean[] visited = new boolean[graph.length];
    for(int i=0;i<graph.length;i++){
        if(visited[i]==false){
            ArrayDeque<Integer> queue = new ArrayDeque<>();
            queue.add(i);
            while(queue.size()>0){
                int peek = queue.pop();
                if(visited[peek])
                    return true;
                visited[peek] =true;
                for(Edge e: graph[peek]){
                    if(visited[e.nbr]==false){
                        queue.add(e.nbr);
                    }
                }
            }
        }
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
      boolean[] visited = new boolean[vtces];
      
      // write your code here
   }
}