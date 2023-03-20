public class SubtreeOfAnoterTree {
    
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

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null){
            return false;
        }
        boolean temp = false;
        if(root.val == subRoot.val){
            temp = isSameTree(root, subRoot);
        }
        if(temp)
            return temp;
        return (isSameTree(root.left, subRoot) || isSameTree(root.right, subRoot));
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if((p==null && q!=null) || (q==null && p!=null))
            return false;
        if(p==null && q==null)
            return true;
        if(p.val!=q.val)
            return false;
        boolean left =  isSameTree(p.left, q.left);
        boolean right = isSameTree(p.right, q.right);
        return left&right;
    }

}
