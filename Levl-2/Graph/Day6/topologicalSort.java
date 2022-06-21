package Day6;

import java.util.ArrayList;
import java.util.Stack;

public class topologicalSort {
    
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> graph){
        // add your code here
        boolean visited[] = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<V; i++){
            if(visited[i]==false){
                DFS(graph, visited, i, stack);
            }
        }
        int [] ans = new int[V];
        int i=0;
        while(stack.peek()>0){
            ans[i++] = stack.pop();
        }
        return ans;
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
