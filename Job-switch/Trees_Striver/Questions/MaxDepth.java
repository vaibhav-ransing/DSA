package Questions;

public class MaxDepth {
    
    public int diameterOfBinaryTree(TreeNode root) {
        int diameter[] = new int[1];
        helper(root, diameter);
        return diameter[0];
    }
    
    public int helper(TreeNode node, int diameter[]){
        if(node == null) return 0;

        int left = helper(node.left, diameter);
        int right = helper(node.right, diameter);
        diameter[0] = Math.max(diameter[0], left + right);

        return 1 + Math.max(left, right);
    }
}
