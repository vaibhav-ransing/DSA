import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    String[] words = br.readLine().split(" ");

    System.out.println(alienOrder(words));
  }

  // public static String alienOrder(String[] words) {

  // }
  public static String alienOrder(String [] dict)
    { 
        int N = dict.length;
        int K = dict.length;
        // Write your code here
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0; i<K; i++){
            graph.add(i, new ArrayList<>());
        }
        for(int i=0; i<N-1; i++){
            String curr = dict[i];
            String other = dict[i+1];
            int minLen = Math.min(curr.length(), other.length());
            int idx = 0;
            while(idx<minLen ){
                if(curr.charAt(idx) != other.charAt(idx)){
                    graph.get(curr.charAt(idx)-'a').add(other.charAt(idx)-'a');
                    break;
                }
                idx++;
            }
        }
        boolean[] visited = new boolean[K];
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<K; i++){
            if(visited[i]==false){
                DFS(graph, visited, i, stack);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(stack.size()>0){

            sb.append((char) ('a'+stack.pop()));
        }
        return sb.toString();
    }

    static void DFS(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int v, Stack<Integer> stack){
        if(visited[v]){ return;}
        visited[v] = true;

        for(int nbr: graph.get(v)){
            if(visited[nbr]==false){
                DFS(graph, visited, nbr, stack);
            }
        }
        stack.add(v);
    }

}
