package BST;

public class LCA {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return helper(root, Math.min(p.val, q.val), Math.max(p.val, q.val));
    }

    public TreeNode helper(TreeNode node, int minNode, int maxNode) {

        if (minNode <= node.val && maxNode >= node.val) {
            return node;
        }else if(maxNode < node.val){
            return helper(node.left, minNode, maxNode);
        }else{
            return helper(node.right, minNode, maxNode);
        }
    }
}