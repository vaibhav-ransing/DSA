import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class prims {
    
    static class Edge {
        int src;
        int nbr;
        int wt;
  
        Edge(int src, int nbr, int wt) {
           this.src = src;
           this.nbr = nbr;
           this.wt = wt;
        }
     }
    static class pair implements Comparable<pair>{
        int pv;
        int vertex;
        int wt;

        pair(int pv, int vertex, int wt){
            this.pv = pv;
            this.wt = wt;
            this.vertex = vertex;
        }

        public int compareTo(pair o){
            return this.wt - o.wt;
        }
    }

    static void solution(ArrayList<Edge>[] graph){

        PriorityQueue<pair> pq = new PriorityQueue<>();
        pq.add(new pair(-1, 0, 0));
        boolean[] visited = new boolean[graph.length];
        while(pq.size()>0){
            pair peek = pq.remove();
            
        }
    }


    public static void main(String[] args) {
        
    }
}
