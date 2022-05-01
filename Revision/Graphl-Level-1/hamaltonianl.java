import java.util.ArrayList;


public class hamaltonianl {
    
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
    
    static void haml(ArrayList<Edge>[] graph, int src){
        boolean visited[] = new boolean[graph.length];
        soln(graph, src, src, 1, visited, ""+src);
    } 

    static void soln(ArrayList<Edge>[] graph, int src,int currSrc, int count, boolean visited[], String path){
        
        if(count==graph.length){
            boolean fsrc = false;
            for(Edge e: graph[currSrc]){
                if(e.nbr==src){
                    fsrc = true;
                    break;
                }
            }
            if(fsrc){
                System.out.println(path+"*");
            }else{
                System.out.println(path+".");
            }
            return;
        }
        visited[currSrc] = true;
        for(Edge e: graph[currSrc]){
            if(visited[e.nbr]==false)
                soln(graph, src, e.nbr, count+1, visited, path+e.nbr);
        }
        visited[currSrc] =false;
    }   

    static boolean isCyclic(ArrayList<Edge>[] graph){

        int visited[] = new int[graph.length];
        for(int i=0;i<graph.length;i++){
            if(visited[i]==0){
                boolean  ans =cyclicHelper(graph, i, i, visited);
                if(ans)
                    return true;
            }
        }
        return false;
    }
    static boolean cyclicHelper(ArrayList<Edge>[] graph, int src,int currSrc, int visited[]){
        if(visited[currSrc]==1)
            return false;

        for(Edge e: graph[currSrc]){
            if(e.nbr==src){
                if(visited[src]==1){
                    visited[src]+=1;
                }else{
                    return true;
                }
            }
        }
        visited[src]=1;
        boolean ans = false;
        for(Edge e: graph[currSrc]){
            if(visited[e.nbr]==0){
                ans = cyclicHelper(graph, src, e.nbr, visited);
                if(ans)
                    return ans;
            }
        }
        return ans;
    }



    

    public static void main(String[] args) {
        
    }
}
