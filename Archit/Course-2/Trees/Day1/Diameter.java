public class Diameter {
    
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

    public int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 0;
        helper(root);
        return ans;
    }
    public int helper(TreeNode node){
        if(node==null)
            return 0;
        int left = helper(node.left);
        int right = helper(node.right);
        ans = Math.max(ans, left+right);
        return Math.max(left, right)+1;
    }

}
