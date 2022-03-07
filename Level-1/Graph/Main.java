import java.io.*;
import java.util.*;

public class Main {
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
   public static void getConnectedComponenets(ArrayList<Edge>[] graph, ArrayList<ArrayList<Integer>> comps, int vtces){
        boolean visited[] = new boolean[vtces];
        for(int i=0;i<graph.length ; i++){
            if(!visited[i]){
                ArrayList<Integer> al = new ArrayList<>();
                helper(graph, i, visited, al);
                comps.add(al);
            }
        }
        System.out.println(comps);

   }
   public static void helper(ArrayList<Edge>[] graph ,int src , boolean visited[], ArrayList<Integer> al){

        visited[src] = true;
        al.add(src);
        for(int i=0; i<graph[src].size(); i++){
            Edge e = graph[src].get(i);
            int nbr = e.nbr;
            if(visited[nbr]==false){
                helper(graph, nbr, visited, al);
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

      ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
      
      // write your code here

      System.out.println(comps);

    //   ArrayList<Integer> arr = new ArrayList<>[vtcs];
      ArrayList<Integer>[] arr = new ArrayList[vtces];
      Scanner sc = new Scanner(System.in);
      for(int i=0 ;i<5;i++){
          int v1 = sc.nextInt();
          int v2 = sc.nextInt();
          arr[v1].add(v2);
          arr[v2].add(v1);
      }
    //   perfectFriends(arr, comps, vtces, k);
   }
}