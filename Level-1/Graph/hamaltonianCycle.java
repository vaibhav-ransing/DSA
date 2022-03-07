import java.util.*;
 
 public class hamaltonianCycle {
 
     public static void hamiltonianCycle(int N, int[][] graph) {
     	 //Write your code here
            boolean visited[][] = new boolean[N][N];
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    
                }
            }
     }
     public static void helper(int[][] graph, boolean[][] visited){

     }
 
     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         int N = sc.nextInt();
         int M = sc.nextInt();
         int[] edges = new int[2 * M];
         for (int i = 0; i < edges.length; i++) {
             edges[i] = sc.nextInt();
         }
         int[][] graph = new int[N][N];
         for (int i = 0; i < M; i++) {
 	     graph[edges[2 * i + 1]-1][edges[2 * i]-1] = 1;
             graph[edges[2 * i]-1][edges[2 * i + 1]-1] = 1;
         }
         hamiltonianCycle(N, graph);
     }
 }