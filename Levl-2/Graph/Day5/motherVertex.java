package Day5;

import java.util.ArrayList;
import java.util.Stack;

public class motherVertex {
    

    
    public int findMotherVertex_BruteForce(int V, ArrayList<ArrayList<Integer>>adj){
        // Code here

        for(int i=0; i<V; i++){
            boolean[] visited = new boolean[V];
            DFS(adj, visited, i);
            boolean flag = true;
            for(boolean val: visited){
                if(val==false){
                    flag = false;
                }
            }
            if(flag){
                return i;
            }
        }
        return -1;
    }
    static void DFS(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int v){
        if(visited[v]){ return;}
        visited[v] = true;

        for(int nbr: graph.get(v)){
            if(visited[nbr]==false){
                DFS(graph, visited, nbr);
            }
        }
    }
    

    public int findMotherVertex(int V, ArrayList<ArrayList<Integer>> graph){
        // Code here
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<V; i++){
            if(visited[i]==false){
                DFS(graph, visited, i, stack);
            }
        }
        int peek = stack.pop();
        visited = new boolean[V];
        DFS2(graph, visited, peek);
        for(boolean val: visited){
            if(val==false){
                return -1;
            }
        }
        return peek;
    }
    static void DFS2(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int v){
        if(visited[v]){ return;}
        visited[v] = true;

        for(int nbr: graph.get(v)){
            if(visited[nbr]==false){
                DFS(graph, visited, nbr);
            }
        }
    }

    static void DFS(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int v, Stack<Integer> stack){
        if(visited[v]){ return;}
        visited[v] = true;

        for(int nbr: graph.get(v)){
            if(visited[nbr]==false){
                DFS(graph, visited, nbr, stack);
            }
        }
        stack.add(v);
    }

        

    public static void main(String[] args) {
    }
}
