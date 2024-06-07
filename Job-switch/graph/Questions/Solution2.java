package Questions;
import java.io.*;

import java.util.*;
import java.util.stream.IntStream;

public class Solution {

    static int time;
    static int[] discovered;
    static int[] low;
    static boolean[] visited;
    static HashSet<Integer> set;
    static ArrayList<Integer> ans;

    public static void printArticulationPoints(ArrayList<ArrayList<Integer>> graph) {

        int n = graph.size();
        time = 0;
        discovered = new int[n];
        low = new int[n];
        visited = new boolean[n];
        ans = new ArrayList<>();

        set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (!visited[i])
                dfs(i, -1, graph);
        }
        for(int i=ans.size() - 1; i>=0; i--){
            System.out.print(ans.get(i) +" ");
        }
        System.out.println();
    }

    public static void dfs(int src, int parent, ArrayList<ArrayList<Integer>> graph) {
        visited[src] = true;
        discovered[src] = low[src] = ++time;
        int children = 0;

        for (int nbr : graph.get(src)) {
            if (!visited[nbr]) {
                children++;
                dfs(nbr, src, graph);
                low[src] = Math.min(low[src], low[nbr]);

                if (parent != -1 && low[nbr] >= discovered[src]) {
                    if (!set.contains(src)) {
                        set.add(src);
                        ans.add(src);
                    }
                }
            } else if (nbr != parent) {
                low[src] = Math.min(low[src], discovered[nbr]);
            }
        }

    public static void main(String[] args) throws NumberFormatException, IOException {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int vertices = sc.nextInt();
            int ed = sc.nextInt();
            ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
            for (int i = 0; i < ed; i++) {
                List<Integer> edge = Arrays.asList(sc.nextInt(), sc.nextInt());
                edges.add(new ArrayList<>(edge));
            }
            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
            for (int i = 0; i <= vertices; i++)
                graph.add(new ArrayList<>());

            for (int i = 0; i < ed; i++) {
                graph.get(edges.get(i).get(0)).add(edges.get(i).get(1));
                graph.get(edges.get(i).get(1)).add(edges.get(i).get(0));
            }
            printArticulationPoints(graph);

        }
    }
}