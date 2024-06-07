package Questions;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

public class BFSCycleDetection {
    
    public int[] findRedundantConnection(int[][] edges) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int n = edges.length + 1;

        IntStream.range(0, n).forEach(i -> graph.add(new ArrayList<>()));

        for(int [] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        for(ArrayList<Integer> ars : graph){
            Collections.sort(ars);
        }

        ArrayDeque<Integer> queue = new ArrayDeque<>();  // node, parent

        boolean[] visisted = new boolean[n];
        queue.add(1);  // node, parent
        
        int[] ans = new int[2];

        while (queue.size() > 0) {
            
            int node = queue.remove();

            visisted[node] = true;

            for(int nbr : graph.get(node)){
                if(visisted[nbr]){
                    ans[0] = node;
                    ans[1] = nbr;
                }else{
                    queue.add(nbr);
                }
            }
        }
        Arrays.sort(ans);
        return ans;
    }
}
