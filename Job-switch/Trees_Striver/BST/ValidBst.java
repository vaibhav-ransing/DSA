package BST;

public class ValidBst {

    public boolean isValidBST(TreeNode root) {
        Pair ans = helper(root);
        return ans.ans;
    }

    public boolean rangeHelper(TreeNode node, int minVal, int maxVal) {
        if (node == null)
            return true;

        if (minVal > node.val || maxVal < node.val)
            return false;
        boolean left = rangeHelper(node.left, minVal, node.val);
        boolean right = rangeHelper(node.right, node.val, maxVal);
        return left && right;
    }

    public Pair helper(TreeNode node) {

        if (node.left == null && node.right == null)
            return new Pair(node.val, node.val, true);

        Pair left = null;
        Pair right = null;
        if (node.left != null)
            left = helper(node.left);
        if (node.right != null)
            right = helper(node.right);

        boolean ans = true;
        int max = node.val;
        int min = node.val;

        if (left != null) {
            ans = ans && (left.max < node.val) && left.ans;
            min = Math.min(min, left.min);
            max = Math.max(max, left.max);
        }
        if (right != null) {
            ans = ans && (right.min > node.val) && right.ans;
            min = Math.min(min, right.min);
            max = Math.max(max, right.max);
        }
        return new Pair(max, min, ans);
    }

    class Pair {
        int max;
        int min;
        boolean ans;

        Pair(int max, int min, boolean ans) {
            this.max = max;
            this.min = min;
            this.ans = ans;
        }

        Pair() {
        }
    }
}
