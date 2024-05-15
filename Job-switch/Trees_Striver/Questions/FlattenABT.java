import java.util.Stack;

public class FlattenABT {

    public void flatten(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if (root == null)
            return;

        stack.push(root);
        while (stack.size() > 0) {
            TreeNode curr = stack.pop();
            if (curr.right != null) {
                stack.push(curr.right);
            }
            if (curr.left != null) {
                stack.push(curr.left);
            }
            if (stack.size() > 0) {
                curr.right = stack.peek();
            }
            curr.left = null;
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}