import java.util.ArrayList;
import java.util.List;

public class N_Array {
    

    class Node {
        public int val;
        public List<Node> children;
    
        public Node() {}
    
        public Node(int _val) {
            val = _val;
        }
    
        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    List<Integer> ans;
    public List<Integer> preorder(Node root) {
        ans = new ArrayList<>();
        helper(root);
        return ans;
    }
    public void helper(Node node){
        if(node==null)
            return;
        
        for(Node child: node.children){
            helper(child);
        }   
        ans.add(node.val);
    }
}
