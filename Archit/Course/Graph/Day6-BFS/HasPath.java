import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class HasPath {
    

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0; i<n; i++){
            graph.add(i, new ArrayList<>());
        }
        for(int[] edge: edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n];

        queue.add(source);

        while(queue.size() > 0){

            int peek = queue.remove();
            
            if(peek == destination) return true;
            if(visited[peek]) continue;

            visited[peek] = true;

            for(int nbr : graph.get(peek)){
                if(!visited[nbr]){
                    queue.add(nbr);
                }
            }
        }

        return false;
    }

}
