public class TreePruning {

    public TreeNode pruneTree(TreeNode root) {
        if (helper(root)) {
            return root;
        }
        return null;
    }

    public boolean helper(TreeNode node) {
        if (node == null)
            return false;

        boolean flag = node.val == 1 ? true : false;
        boolean left = helper(node.left);
        boolean right = helper(node.right);

        if (left == false)
            node.left = null;
        if (right == false)
            node.right = null;

        return flag || left || right;
    }
}