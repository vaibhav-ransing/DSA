
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.function.ToIntBiFunction;

public class MinEdgeReverseToReachDest {
    // https://www.codingninjas.com/codestudio/problems/reverse-edges_1200162

    public static class Pair implements Comparable<Pair>{
        int src;
        int wt;
        int currWt;
        Pair(int src, int wt) {
            this.src = src;
            this.wt = wt;
        }
        Pair(int src, int wt, int currWt) {
            this.src = src;
            this.wt = wt;
            this.currWt = currWt;
        }

        @Override
        public int compareTo(Pair o) {
            
            return o.currWt - this.currWt;
        }
    }

    public static int reverseEdges(int n, int start, int end, ArrayList<ArrayList<Integer>> edgeList) {

        ArrayList<Pair>[] graph = new ArrayList[n];
        
        for(int i=0; i<n; i++){
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    if(edgeList.get(i).contains(j)){
                        graph[j].add(new Pair(i, 1));
                        graph[i].add(new Pair(j, 0));
                    }
                    if(edgeList.get(j).contains(i)){
                        graph[i].add(new Pair(j, 1));
                        graph[j].add(new Pair(i, 0));
                    }
                }
            }
        }

        PriorityQueue<Pair> queue = new PriorityQueue<>();
        queue.add(new Pair(start, 0));
        boolean[] visited = new boolean[n];

        while(queue.size() > 0){
            
            Pair peek = queue.remove();
            if(peek.src == end) return peek.currWt;

            if(visited[peek.src]) continue;
            visited[peek.src] = true;

            for(Pair nbr : graph[peek.src]){
                if(!visited[nbr.src]){
                    queue.add(new Pair(nbr.src, nbr.wt, peek.currWt + nbr.wt));
                }
            }
        }
        return -1;
    }
}
