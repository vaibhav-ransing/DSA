package Day5;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class kosarajuAlgo {
    
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> graph){

        boolean visited[] = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<V; i++){
            if(visited[i]==false){
                DFS(graph, visited, i, stack);
            }
        }
        ArrayList<ArrayList<Integer>> transpose = new ArrayList<>();
        for(int i=0; i<V; i++){
            transpose.add(i, new ArrayList<>());
        }
        for(int i=0; i<V; i++){
            ArrayList<Integer> Edge = graph.get(i);
            for(int nbr: Edge){
                transpose.get(nbr).add(i);
            }
        }
        Arrays.fill(visited, false);
        int count = 0;
        while(stack.size()>0){
            int peek = stack.pop();
            if(visited[peek]==false){
                count++;
                DFS2(transpose, visited, peek);
            }
        }
        return count;
    }
    static void DFS2(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int v){
        if(visited[v]){ return;}
        visited[v] = true;

        for(int nbr: graph.get(v)){
            if(visited[nbr]==false){
                DFS2(graph, visited, nbr);
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
