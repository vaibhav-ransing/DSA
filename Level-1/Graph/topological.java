import java.io.*;
import java.lang.Thread.State;
import java.rmi.ConnectIOException;
import java.util.*;

public class topological {
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
       int nbr;
   }
   static void printTopolocial(ArrayList<Edge>[] graph){
        boolean visited[] = new boolean[graph.length];
        ArrayList<Integer> al = new ArrayList<>();
        for(int i=0;i<graph.length;i++){
            if(visited[i]==false){
                helper(graph, i, al,visited);
            }
        }
        while(al.size()>0)
            System.out.println(al.remove(al.size()-1));
   }
   static void helper(ArrayList<Edge>[] graph, int vertex, ArrayList<Integer> al, boolean visited[]){
        
        if(visited[vertex]){
            return;
        }
        visited[vertex] =true;
        
        for(Edge e: graph[vertex]){
            if(visited[e.nbr]==false){
                helper(graph, e.nbr, al, visited);
            }
        }
        al.add(vertex);
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
      }

      // write your code here
   }

}