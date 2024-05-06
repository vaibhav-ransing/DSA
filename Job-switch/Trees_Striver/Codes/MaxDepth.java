package Codes;

public class MaxDepth {
    

    public int maxDepth(TreeNode root) {
        return helper(root);
    }
    
    public int helper(TreeNode node){
        if(node == null) return 0;

        int left = helper(node.left);
        int right = helper(node.right);

        return 1 + Math.max(left, right);
    }
}
