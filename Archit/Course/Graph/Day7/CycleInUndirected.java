package Course.Graph.Day7;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class CycleInUndirected {

    public class Pair {
        int src;
        int par;

        Pair(int src, int par) {
            this.par = par;
            this.src = src;
        }
    }

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {

        boolean[] visited = new boolean[V];
        
        for(int i=0; i<V; i++){
            if(visited[i]==false){
                if(bfs(i, adj, visited)) return true;
            }
        }
        return false;
    }

    public boolean bfs(int src, ArrayList<ArrayList<Integer>> adj, boolean[] visited){

        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(0, -1));

        while (queue.size() > 0) {
            Pair peek = queue.remove();
            
            // if(visited[peek.src]) return true;
            visited[peek.src] = true;

            for(int nbr : adj.get(peek.src)){
                if(nbr == peek.par) continue;
                if( visited[nbr] ) return true;
                queue.add(new Pair(nbr, peek.src));
            }
        }
        return false;
    }
    public static void main(String[] args) {

    }
}
