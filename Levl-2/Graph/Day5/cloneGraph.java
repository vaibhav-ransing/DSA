package Day5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class cloneGraph {
    

    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        
    }



    public static void main(String[] args) {
        
    }
}
