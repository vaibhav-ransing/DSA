package Course.Graph.Day2;

import java.util.ArrayList;

import Course.Graph.Graph;

public class Representation {
    

    public static void main(String[] args) {
        
        Graph graph = new Graph(4);
        graph.add(0, 1);
        graph.add(2, 0);
        graph.add(2, 3);

        for(ArrayList<Integer> al: graph.adj){
            System.out.println(al);
        }
    }
}
