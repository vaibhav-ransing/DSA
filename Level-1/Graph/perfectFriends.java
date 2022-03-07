import java.io.*;
import java.util.*;
                                
      // I have not used Edge class simply added edge integer in respective edges
              
public class perfectFriends {

public static void perfectFriends1(ArrayList<Integer>[] graph, ArrayList<ArrayList<Integer>> comps, int vtces){
    boolean visited[] = new boolean[vtces];
    for(int i=0;i <vtces;i++){
        if(!visited[i]){
            ArrayList<Integer> al = new ArrayList<>();
            pfHelper(graph, i, visited, al);
            comps.add(al);
        }
    }
    int val=  0;
    for(int i=0; i<comps.size();i++){
        for(int j=i+1; j<comps.size();j++){
            val+= comps.get(i).size() *comps.get(j).size();
        }
    }
    System.out.println(val);
}

public static void pfHelper(ArrayList<Integer>[] graph ,int src , boolean visited[], ArrayList<Integer> al){ 
    visited[src] = true;
    al.add(src);
    for(int i=0; i<graph[src].size(); i++){
        int nbr = graph[src].get(i);
        if(visited[nbr]==false){
            pfHelper(graph, nbr, visited, al);
        }
    }
}


public static void main(String[] args) throws Exception {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  int n = Integer.parseInt(br.readLine());
  int k = Integer.parseInt(br.readLine());

  ArrayList<Integer>[] graph = new ArrayList[n];
  for(int i=0;i<n;i++){
    graph[i] = new ArrayList<Integer>();
  }
  Scanner sc = new Scanner(System.in);

  for(int i=0 ;i<k;i++){
      int v1 = sc.nextInt();
      int v2 = sc.nextInt();
      graph[v1].add(v2);
      graph[v2].add(v1);
  }

  ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
  perfectFriends1(graph, comps, n);
  
}

}