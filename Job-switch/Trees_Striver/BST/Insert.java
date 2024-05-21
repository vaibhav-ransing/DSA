package BST;

public class Insert {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);
        helper(root, val);
        return root;
    }

    public void helper(TreeNode node, int val) {

        if (node.val > val) {
            if (node.left == null)
                node.left = new TreeNode(val);
            else
                helper(node.left, val);
        } else {
            if (node.right == null)
                node.right = new TreeNode(val);
            else
                helper(node.right, val);
        }
    }
}
