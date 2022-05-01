import java.util.*;

public class perfectFriend {
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

    static void soln(ArrayList<Edge>[] graph){
        
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        boolean visited[] = new boolean[graph.length];
        for(int i=0; i<graph.length;i++){
            if(visited[i]==false){
                ArrayList<Integer> temp = new ArrayList<>();
                helper(graph, i, temp, visited);
                al.add(temp);
            }
        }
        int ans = 0;
        for(int i=0;i<al.size();i++){
            for(int j=i+1;j<al.size();j++){
                int val = al.get(i).size()*al.get(j).size();
                ans+=val;
            }
        }

        System.out.println(ans);
    }
    static void helper(ArrayList<Edge>[] graph, int src, ArrayList<Integer> temp,  boolean visited[]){
        
        if(visited[src])
            return;
        visited[src] = true;
        temp.add(src);
        for(Edge e: graph[src]){
            helper(graph, e.nbr, temp, visited);
        }
    }

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine();
        ArrayList<Edge>[] graph = new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i] = new ArrayList<Edge>();
        }
        for(int i=0;i<k;i++){
            String inp = sc.nextLine();
            int v1 = Integer.parseInt(inp.split(" ")[0]);
            int v2 = Integer.parseInt(inp.split(" ")[1]);

            graph[v1].add(new Edge(v1, v2, 10));
            graph[v2].add(new Edge(v2, v1, 10));
        }
        soln(graph);
    }
}
