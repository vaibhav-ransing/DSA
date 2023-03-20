package Day2;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class HufmanEncoding {
    

    class Node implements Comparable<Node> {
        int freq;
        char ch='#';
        Node left, right;
        Node(){}
        Node(int freq, char ch){
            this.freq = freq;
            this.ch = ch;
        }
        public int compareTo(Node o){
            // Min heap 
            if(this.freq < o.freq) return -1;
            return 1;
        }

    }
    
    public void traversal(Node node, String asf, ArrayList<String> ans){
        if(node.ch!='#'){
            ans.add(asf);
            return;
        }
        traversal(node.left, asf+"0", ans);
        traversal(node.right, asf+"1", ans);
    }

    public ArrayList<String> huffmanCodes(String S, int f[], int N){
        PriorityQueue<Node> queue = new PriorityQueue<>();
        for(int i=0; i<N; i++){
            queue.add(new Node(f[i], S.charAt(i)));
        }
        while(queue.size()>1){
            Node root = new Node();
            root.left = queue.remove();
            root.right = queue.remove();
            root.freq = root.left.freq + root.right.freq;
            queue.add(root);
        }

        ArrayList<String> ans = new ArrayList<>();
        traversal(queue.peek(), "", ans);

        return ans;
    }

}
