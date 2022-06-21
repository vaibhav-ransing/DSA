import java.util.ArrayDeque;
import java.util.Arrays;

public class bipartite {
    
    static class pair{
        int len;
        int vertex;
        pair(int len, int vertex){
            this.len = len;
            this.vertex = vertex;
        }
    }
    public boolean isBipartite(int[][] graph) {
        int visited[] = new int[graph.length];
        Arrays.fill(visited, -1);
        ArrayDeque<pair> queue = new ArrayDeque<>();
        
        for(int v=0; v<graph.length; v++){
            if(visited[v]==-1){
                queue.add(new pair(1, v));
                boolean temp = helper(graph, queue, visited);
                if(temp==false){
                    return false;
                }
            }
        } 
        return true;
    }

    static boolean helper(int graph[][], ArrayDeque<pair> queue, int[] visited){
        while(queue.size() >0){
            pair peek = queue.pop();
            if(visited[peek.vertex]!=-1){
                if(peek.len != visited[peek.vertex]){
                    System.out.println("falsed "+ peek.vertex+" "+peek.len+" "+queue.size());
                    return false;
                }
                System.out.println("inside "+ peek.vertex+" "+peek.len);
                continue;
            }
            System.out.println(peek.vertex+" "+peek.len);

            visited[peek.vertex] = peek.len;
            for(int i=0; i<graph[peek.vertex].length; i++){
                int vertex = graph[peek.vertex][i];
                if(visited[vertex]==-1){
                    queue.add(new pair(peek.len+1, vertex));
                }
            }
        }
        return true;
    }





    public static void main(String[] args) {
        
    }
}
