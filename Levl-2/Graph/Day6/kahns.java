package Day6;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class kahns {
    
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> graph){
        // add your code here
        boolean[] visited = new boolean[V];
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for(int i=0 ;i<V; i++){
            DFS(graph, visited, i, map);
        }

        for(int v: map.keySet()){
            int degree = map.get(v);
            if(degree==0){
                queue.add(v);
            }
        }
        int count = 0;
        int ans[] = new int[V];
        while(queue.size()>0){
            int peek = queue.pop();
            ans[V++] = peek;
            for(int nbr: graph.get(peek)){
                int nbrDegree = map.get(nbr) -1;
                if(nbrDegree==0){
                    queue.add(nbr);
                }
                map.put(nbr, nbrDegree);
            }
        }
        return ans;
    }
    static void DFS(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int v, HashMap<Integer, Integer> map){
        if(visited[v]){ return;}
        visited[v] = true;

        for(int nbr: graph.get(v)){
            if(visited[nbr]==false){
                map.put(nbr, map.getOrDefault(nbr, 0)+1);
                DFS(graph, visited, nbr, map);
            }
        }
        visited[v] = false;

    }






    public static void main(String[] args) {
        
    }
}
