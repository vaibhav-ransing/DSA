import java.beans.Visibility;
import java.util.ArrayList;
import java.util.HashMap;

public class graph {
    
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

    static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean visited[]){
        if(src==dest ){
            return true;
        }
        if(visited[src])
            return false;
        visited[src] = true;
        ArrayList<Edge> temp = graph[src];
        for(Edge e: graph[src]){
            boolean nbrHp = hasPath(graph, e.nbr, dest, visited);
            if(nbrHp)
                return true;
        }
        return false;
    }

    static void printAllPath(ArrayList<Edge>[] graph, int src, int dest, boolean visited[], String path){
        if(src==dest){
            System.out.println(path+dest);
            return;
        }
        if(visited[src])
            return;
        visited[src] = true;
        path+=src;
        for(Edge e: graph[src]){
            printAllPath(graph, e.nbr, dest, visited, path);
        }
        visited[src] =false;
    }

    static void getConnectedComponents(ArrayList<Edge>[] graph){
        boolean[] visited = new boolean[graph.length];
        
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int i=0;i<graph.length;i++){
             ArrayList<Integer> temp = new ArrayList<>();
             if(visited[i]==false){
                gccHelper(graph, temp, i, visited);
                ans.add(temp);
             }

        }
        System.out.println(ans);
    }
    static void gccHelper(ArrayList<Edge>[] graph, ArrayList<Integer> temp, int src, boolean[] visited){

        if(visited[src])
            return;
        visited[src] = true;
        temp.add(src);
        for(Edge e: graph[src]){
            gccHelper(graph, temp, e.nbr, visited);
        }
    }

    static void numberOfIsland(int[][] arr){

        boolean visited[][] = new boolean[arr.length][arr.length];
        int count=0;
        
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j]==0 && visited[i][j]==false){
                    noiHelper(arr, i,j, visited);
                    count++;
                }
            }
        }

        System.out.println(count);
    }
    static void noiHelper(int[][] arr, int i,int j, boolean[][] visited){
        if(i<0 || j<0 || i>=arr.length || j>=arr.length || arr[i][j]==1 || visited[i][j]){
            return;
        }
        visited[i][j]=true;

        noiHelper(arr, i+1, j, visited);
        noiHelper(arr, i-1, j, visited);
        noiHelper(arr, i, j+1, visited);
        noiHelper(arr, i, j-1, visited);
    }


    public static void main(String[] args) {
        int vertices = 7;
        ArrayList<Edge>[] graph = new ArrayList[vertices];
        for(int i=0; i<graph.length;i++){
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 3, 40));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 2, 10));

        graph[2].add(new Edge(2, 1, 10));
        graph[2].add(new Edge(2, 3, 10));

        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 10));
        graph[3].add(new Edge(3, 4, 2));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 3));
        graph[4].add(new Edge(4, 6, 8));

        graph[5].add(new Edge(5, 4, 3));
        graph[5].add(new Edge(5, 6, 3));

        graph[6].add(new Edge(6, 5, 3));
        graph[6].add(new Edge(6, 4, 8));

        boolean visited[] = new boolean[vertices];

        printAllPath(graph, 0, 6, visited, "");
        

    }
}
