public class depth {
    
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

    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int lef = maxDepth(root.left);
        int rig = maxDepth(root.right);

        return Math.max(lef+1, rig+1);
    }

    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        if(root.left==null){
            return minDepth(root.right)+1;
        }
        if(root.right==null){
            return minDepth(root.left)+1;
        }
        int lef = minDepth(root.left);
        int rig = minDepth(root.right);
        return Math.min(lef+1, rig+1);
    }
}
