package Course.Graph.TopologicalSort.Applications;

import java.beans.Visibility;
import java.util.ArrayList;

import javax.imageio.plugins.tiff.FaxTIFFTagSet;

public class AlienDictionary {

    // Solution
    // Make a graph
    // Do comparison between side string and if any char is found different then add that edge and break 
    @SuppressWarnings("all")
    class Graph {

        int n;
        ArrayList<Character>[] adj;

        Graph(int n) {
            this.n = n;
            adj = new ArrayList[n];
        }

        void addEdge(char src, char dest) {
            adj[src - 'a'].add(dest);
        }
    }

    public String findOrder(String[] dict, int words, int letters) {
        // Write your code here
        Graph graph = new Graph(words);

        for (int w = 0; w < dict.length - 1; w++) {
            for (int i = 0; i < Math.min(dict[w].length(), dict[w + 1].length()); i++) {
                char c1 = dict[w].charAt(i);
                char c2 = dict[w + 1].charAt(i);

                if (c1 != c2) {
                    graph.addEdge(c1, c2);
                    break;
                }
            }
        }
        boolean[] visited = new boolean[letters];
        for(int i=0; i<letters; i++){
            if(visited[i] == false){
                dfs(graph, (char)(i+'a'), visited);
            }
        }
        return topo.reverse().toString();

    }
    StringBuilder topo = new StringBuilder();

    public String dfs(Graph graph, char src, boolean[] visited) {

        if (visited[src - 'a'])
            return "";

        visited[src - 'a'] = true;

        String ans = "";
        for (char nbr : graph.adj[src - 'a']) {
            if (!visited[nbr - 'a']) {
                ans = dfs(graph, nbr, visited);
            }
        }
        topo.append(src);
        ans += src;
        return ans;
    }

    public static void main(String[] args) {

    }
}
