import java.util.ArrayList;
import java.util.List;

public class traversal {
    
     public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list;
    }
    public void helper(TreeNode node, List<Integer> list){
        if(node == null) return;
        
        helper(node.left, list);
        list.add(node.val);
        helper(node.right, list);
    }

}
