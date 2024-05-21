package BST;

public class ConstructFromPreorder {

    public TreeNode bstFromPreorder(int[] preorder) {
        // 1 <= preorder[i] <= 1000
        return helper(0, preorder, Integer.MAX_VALUE);
    }

    public TreeNode helper(int idx, int[] preorder, int bound) {
        if (idx == preorder.length || preorder[idx] > bound)
            return null;
        TreeNode node = new TreeNode(preorder[idx]);
        node.left = helper(idx + 1, preorder, preorder[idx]);
        node.right = helper(idx + 1, preorder, bound);
        return node;
    }
}