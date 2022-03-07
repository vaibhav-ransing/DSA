import java.util.ArrayList;

class p{

    static class Edge{
        int v1;
        int v2;
        int wt;
        Edge(int v1, int v2, int wt){
            this.v1 = v1;
            this.v2 = v2;
            this.wt = wt;
        }
    }
    public static boolean path(ArrayList<Edge>[] arr , int src, int dest){
        if(src==dest)
            return true;

        for(int i=0; i<arr[src].size(); i++){
            Edge e = arr[src].get(i);
            int neighbour = e.v2;
            ArrayList<Edge> temp = arr[src];
            arr[src] = new ArrayList<>();
            boolean ans = path(arr, neighbour, dest);
            if(ans)
                return true;
            arr[src] = temp;
        }
        return false;
    }

    public static void printAllPath(ArrayList<Edge>[] arr ,boolean visited[] , int src, int dest, String ans){
        if(src==dest){
            System.out.println(ans);
            return;
        }
        visited[src] = true;
        for(int i=0; i<arr[src].size(); i++){
            Edge e = arr[src].get(i);
            int neighbour = e.v2;
            if(visited[neighbour]==false){
                printAllPath(arr, visited, neighbour, dest, ans+neighbour+" ");
            }
        }
        visited[src] = false;
    }

    public static void printConnectedPath(ArrayList<Edge>[] graph, ArrayList<ArrayList<Integer>> comps){
        
    }


    public static void main(String[] args) {

        ArrayList<Edge>[] arr = new ArrayList[4];

    }
}