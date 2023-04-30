import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class BFS {
   
    
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here

        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();
        
        queue.add(0);

        boolean[] visited = new boolean[adj.size()];

        while(queue.size()>0){
            int src = queue.remove();

            if(visited[src]) continue;

            visited[src] = true;

            ans.add(src);

            for(int nbr : adj.get(src)){
                if(!visited[nbr]){
                    queue.add(nbr);
                }
            }
        }
        return ans;
    }

}
