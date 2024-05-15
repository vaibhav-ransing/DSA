package BST;

public class Search {

    public TreeNode searchBST(TreeNode node, int val) {
        if (node == null || node.val == val)
            return node;

        TreeNode next = val > node.val ? searchBST(node.right, val) : searchBST(node.left, val);
        return next;
    }
}
