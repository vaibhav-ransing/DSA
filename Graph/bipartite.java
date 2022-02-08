import java.io.*;
import java.util.*;

public class bipartite {
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
        int visitSide;
        int vertex;
        pair(int vertex , int visitSide){
            this.vertex = vertex;
            this.visitSide = visitSide;
        }
    }
    static boolean isCyclic(ArrayList<Edge>[] graph, boolean visited[], int index){
        if(visited[index])
            return true;
        visited[index]=true;
        boolean ans = false;
        for(Edge e: graph[index]){
            ans = isCyclic(graph, visited, e.nbr);
        }
        return ans;
    }
    static void isBipartite(ArrayList<Edge>[] graph, int vtces){
        boolean cyclic = false;
        boolean visitedTemp[] = new boolean[vtces];
        for(int i=0;i<vtces;i++){
            if(visitedTemp[i]==false){
                if(isCyclic(graph, visitedTemp, i)){
                    cyclic = true;
                    break;
                }
            }
        }

        if(cyclic==false)
            System.out.println("is bipartite");
        else{
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
                        int position = peek.visitSide;
                        if(oddEven[vertex]==0)
                            oddEven[vertex]=position;
                        else if(oddEven[vertex]!=position){
                            System.out.println("Not bipartite");
                            return;
                        }
                        for(Edge e: graph[vertex]){
                            int nbr = e.nbr;
                            if(visited[nbr]==false){
                                int val = 1;
                                if(peek.visitSide==1)
                                    val = 2;
                                pair np = new pair(vertex, val);
                                queue.push(np);
                            }
                        }
                    }
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