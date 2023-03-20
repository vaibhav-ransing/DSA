import java.util.ArrayDeque;

public class Lc116 {
    
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;
    
        public Node() {}
        
        public Node(int _val) {
            val = _val;
        }
    
        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    public Node connect(Node root) {
        ArrayDeque<Node> queue = new ArrayDeque<>();
        if(root==null) return root;
        Node ans = root;
        queue.add(root);
        while(queue.size()>0){
            for(int i=queue.size(); i>0; i--){
                root = queue.remove();
                if(i==1){
                    root.next = null;
                }else{
                    root.next = queue.peek();
                }
                if(root.left!=null) queue.add(root.left);
                if(root.right!=null) queue.add(root.right);
            }
        }
        return ans;
    }
}
