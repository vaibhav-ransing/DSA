import java.util.List;

public class TargetSum {
    
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
    
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return helper(root, targetSum, 0);
    }
    public boolean helper(TreeNode node, int targetSum, int currSum) {
        if(node==null)
            return false;
        if(node.left==null && node.right==null){
            return targetSum==currSum+node.val;
        }
        return (helper(node.left, targetSum, currSum+node.val) || 
        helper(node.right, targetSum, currSum+node.val));
    }

    // public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
    // }

}
