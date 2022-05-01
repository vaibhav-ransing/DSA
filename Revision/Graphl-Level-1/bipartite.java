import java.util.ArrayDeque;
import java.util.ArrayList;

public class bipartite {
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
        int count=0;
        int vertex;
        pair(int count, int vertex){
            this.count =count;
            this.vertex = vertex;
        }
    }
    
    static void soln(ArrayList<Edge>[] grph){

        boolean visited[] = new boolean[grph.length];
        
        for(int i=0;i<grph.length;i++){
            if(visited[i]==false){
                ArrayDeque<pair> queue = new ArrayDeque<>();
                pair p = new pair(1, i);
                queue.add(p);                                                                                                                                                            
                boolean ans = helper(grph, visited, queue);
                if(ans==false){
                    System.out.println(false);
                    return;
                }                                  

            }
        }
        System.out.println(true);
    }
    static boolean helper(ArrayList<Edge>[] grph, boolean visited[], ArrayDeque<pair> queue){

        while(queue.size()>0){
            pair peek = queue.remove();
            if(visited[peek.vertex]==true){
                if(peek.count%2==1)
                    return false;
            }
            visited[peek.vertex]=true;
            for(Edge e: grph[peek.vertex]){
                if(visited[e.nbr]==false){
                    queue.add( new pair(peek.count+1, e.nbr));
                }
            }

        }
        return true;
    }





        
    public static void main(String[] args) {
        
    }
}
