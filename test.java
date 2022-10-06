public class test{

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
    public static TreeNode pruneTree(TreeNode root) {
        helper(root);
        return root;
    }
    static boolean helper(TreeNode node){
        if(node==null){
            return false;
        }
        boolean left = helper(node.left);
        boolean right = helper(node.right);
        if(node.left==false){
            node.left =null;
        }
        if(node.right==false){
            node.right = null;
        }
        return node.val==1||left||right;
    }
    

    public static void main(String[] args) {
        System.out.println("hello");
    }
}