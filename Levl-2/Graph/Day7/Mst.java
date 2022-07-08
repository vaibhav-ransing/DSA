import java.io.*;
import java.util.*;

import javax.swing.Painter;

public class Mst {
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

static class pair implements Comparable<pair>{
    int pv;
    int vetex;
    int distance;
    pair(){}
    pair(int pv, int vetex, int distance){
        this.pv = pv;
        this.vetex = vetex;
        this.distance = distance;
    }
    public int compareTo(pair o){
        return this.distance - o.distance;
    }
}
static void solution(ArrayList<Edge>[] graph ){
    int v = graph.length;
    PriorityQueue<pair> queue = new PriorityQueue<>();
    queue.add(new pair(-1, 0, -1));
    int count = 0;
    boolean[] visited = new boolean[v];
    while(queue.size()>0){
        pair peek = queue.remove();
        if(visited[peek.pv]) continue;
        if(peek.pv!=-1){
            count+= peek.distance;
            System.out.println(peek.vetex+"-"+peek.vetex+"@"+peek.distance);
        }
        visited[peek.vetex] = true;
        for(Edge e: graph[peek.vetex]){
            if(visited[e.nbr]==false){
                queue.add(new pair(peek.vetex, e.nbr, e.wt));
            }
        }
    }
}


public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int vtces = Integer.parseInt(br.readLine());
    ArrayList<Edge>[] graph = new ArrayList[vtces];
    for (int i = 0; i < vtces; i++) {
        graph[i] = new ArrayList<>();
    }

    int edges = Integer.parseInt(br.readLine());
    for (int i = 0; i < edges; i++) {
        String[] parts = br.readLine().split(" ");
        int v1 = Integer.parseInt(parts[0]);
        int v2 = Integer.parseInt(parts[1]);
        int wt = Integer.parseInt(parts[2]);
        graph[v1].add(new Edge(v1, v2, wt));
        graph[v2].add(new Edge(v2, v1, wt));
    }
    // write your code here
}

}