import java.util.ArrayList;
import java.util.PriorityQueue;

public class DFS_multiSolver {
    
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

    static class Pair implements Comparable<Pair> {
        int wsf;
        String psf;
  
        Pair(int wsf, String psf){
           this.wsf = wsf;
           this.psf = psf;
        }
  
        public int compareTo(Pair o){
           return this.wsf - o.wsf;
        }
    }

    static String spath;
    static Integer spathwt = Integer.MAX_VALUE;
    static String lpath;
    static Integer lpathwt = Integer.MIN_VALUE;
    static String cpath;
    static Integer cpathwt = Integer.MAX_VALUE;
    static String fpath;
    static Integer fpathwt = Integer.MIN_VALUE;
    static PriorityQueue<Pair> pq = new PriorityQueue<>();


    public static void multisolver(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited, int criteria, int k, String psf, int wsf) {
        if(src==dest){
            if(wsf < spathwt){
                spath = psf;
                spathwt = wsf;
            }
            if(wsf> lpathwt){
                lpath = psf;
                lpathwt = wsf;
            }
            if(wsf> criteria && wsf<cpathwt){
                cpath = psf;
                cpathwt = wsf;
            }
            if(wsf<criteria && wsf > fpathwt){
                fpath = psf;
                fpathwt= wsf;
            }
            if(pq.size() <k){
                pq.add(new Pair(wsf, psf));
            }
            else{
                if(wsf > pq.peek().wsf){
                    pq.remove();
                    pq.add(new Pair(wsf, psf));
                }
            }
            return;
        }
        if(visited[src])
            return;
        visited[src] =true;
        for(Edge e: graph[src]){
            multisolver(graph, e.nbr, dest, visited, criteria, k, psf+e.nbr, wsf+e.wt);
        }
        visited[src] =false;
    }

    public static void main(String[] args) {
        
    }
}
