package ZRandom.Tree;

import Z_DailyLC.maxHeightTrainge;

public class BurnTree {
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

    public int amountOfTime(TreeNode root, int start) {
        rec(root, start);
        return ans;
    }

    int ans = 0;

    public int rec(TreeNode node, int start) {

        if (node == null)
            return 0;
        if (node.val == start) {
            int ht = ht(node);
            ans = Math.max(ans, ht);
            return -1;
        }
        int left = rec(node.left, start);
        int right = rec(node.right, start);

        if (left < 0 || right < 0) {
            ans = Math.max(ans, Math.abs(left) + Math.abs(right));
            return -1 + Math.min(left, right);
        } else {
            return Math.max(left, right) + 1;
        }

    }

    int ht(TreeNode node) {
        if (node == null)
            return 0;
        return 1 + Math.max(ht(node.left), ht(node.right));
    }
}
