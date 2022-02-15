import java.io.*;
import java.util.*;
public class hamaltonianPath {

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
       public static void hamPathCycle(ArrayList<Edge>[] graph,int vtces, int src){  
            boolean[] visited = new boolean[vtces];
            printPath(graph, src, src, 1, visited, ""+src);
            
       }
       public static void printPath(ArrayList<Edge>[] graph, int start,int src , int count, boolean visited[], String ans){
            if(count==graph.length){
                for(Edge e: graph[src]){
                    if(e.nbr==start){
                        System.out.println(ans+"*");
                        return;
                    }
                }
                System.out.println(ans+".");
                return;
            }
            visited[src] = true;
            for(Edge e: graph[src]){
                if(!visited[e.nbr]){
                    printPath(graph, start, e.nbr, count+1, visited, ans+e.nbr);
                }
            }
            visited[src] = false;
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
          hamPathCycle(graph , vtces , src);
          // write all your codes here
       }
    
    
    
}
