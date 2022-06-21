public class BTToLinkedList{

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
    }

    // class Solution {
//     public TreeNode prev = null;
//     public void flatten(TreeNode root) {
//         prev = null;
//         helper( root);
//     }
//     public void helper(TreeNode node){
//         if(node==null) return;
//         helper(node.right);
//         helper(node.left);
        
//         node.left = null;
//         node.right = prev;
//         prev = node;
        
//     }
// }
    
    public void flatten(TreeNode root) {
        TreeNode ans = new TreeNode();
        ans.val = root.val;
        helper(node, ans, ans);
        root = ans;
    }
    public void helper(TreeNode node,TreeNode ans, TreeNode curr ){
        if(node==null)
            return;

        TreeNode temp = new TreeNode();
        temp.val= node.val;
        curr.right = temp;
        curr = temp;
        helper(node.left, ans, curr);
        helper(node.right, ans, curr);
        
    }

    public static void main(String[] args) {
        
    }
}