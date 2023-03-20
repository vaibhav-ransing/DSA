public class BalancedTree {
    
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

    public static boolean ans;
    public static boolean isBalanced(TreeNode root) {
        ans = true;
        height(root);
        return ans;
    }
    public static int height(TreeNode node){
        if(node==null){
            return 0;
        }
        int left = height(node.left);
        int right = height(node.right);
        if(Math.abs(left-right)>1){
            ans = false;
        }
        return Math.max(left, right)+1;
    }

    public static void main(String[] args) {
        
    }
}
