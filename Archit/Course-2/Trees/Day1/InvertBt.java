public class InvertBt {

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

    public void helper(TreeNode node){
        if(node==null){
            return;
        }
        if(node.left!=null){
            int temp = node.left.val;
            node.left.val = node.right.val;
            node.right.val = temp; 
        }
        helper(node.left);
        helper(node.right);
    }

    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }
        // if(root.left!=null){
        //     TreeNode temp = root.left;
        //     root.left = root.right;
        //     root.right = temp; 
        // }
        TreeNode left =  invertTree(root.left);
        TreeNode right =  invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }



    public static void main(String[] args) {
        
    }
}
