import java.util.ArrayDeque;
import java.util.ArrayList;

public class bfs {
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
    static class pair{
        int v;
        String psf;
        pair(int v, String psf){
            this.v = v;
            this.psf =psf;
        }
    }
    static void bfsSoln(ArrayList<Edge>[] graph, int src){
        ArrayDeque<pair> queue = new ArrayDeque<>();
        queue.add(new pair(src, src+""));
        boolean visited[] = new boolean[graph.length];
        while(queue.size()>0){
            pair peek = queue.remove();
            if(visited[peek.v])
                continue;
            visited[peek.v] = true;
            System.out.println(peek.v +"@"+ peek.psf);
            for(Edge e: graph[peek.v]){
                if(visited[e.nbr]==false){
                    pair p = new pair(e.nbr, peek.psf+e.nbr);
                    queue.add(p);
                }
            }
        }
    }


    public static void main(String[] args) {
        
    }
}
