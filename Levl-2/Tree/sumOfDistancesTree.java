import java.util.ArrayList;
import java.util.HashSet;

public class sumOfDistancesTree {
    
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        HashSet<Integer> [] graph = new HashSet[n];
        for(int i=0; i<n; i++){
            graph[i] = new HashSet<>();
        }
        for(int vert[]: edges){
            int e1 = vert[0];
            int e2 = vert[1];
            graph[e1].add(e2);
            graph[e2].add(e1);
        }   
        int [] nodes  = new int[n];
        int [] res = new int[n];
        helper(graph, nodes, res, 0, -1);
        helper2(graph, nodes, res, 0, -1);
        return res;
    }
    static void helper(HashSet<Integer> [] graph, int[] nodes, int[] res, int src, int par){

        for(int nbr: graph[src]){
            if(nbr!=par){
                helper(graph, nodes, res, nbr, src);
                nodes[src]+=nodes[nbr];
                res[src] += res[nbr]+nodes[nbr];
            }
        }
        nodes[src]++;
    }
    static void helper2(HashSet<Integer> [] graph, int[] nodes, int[] res, int src, int par){

        for(int nbr: graph[src]){
            if(nbr!=par){
                res[nbr] = res[src]+ (nodes.length - nodes[nbr]) - nodes[nbr];
                helper2(graph, nodes, res, nbr, src);
            }
        }
    }





    public static void main(String[] args) {
        
    }
}
