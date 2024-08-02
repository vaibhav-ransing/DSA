public class MaxDiffBtwNodeAndAncestor {

    public int maxAncestorDiff(TreeNode root) {
        dfs(root);
        return ans;
    }

    public int ans = 0;

    public int[] dfs(TreeNode node) {
        if (node == null)
            return null;

        if (node.left == null && node.right == null) {
            return new int[] { node.val, node.val };
        }
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        int min = 9999999;
        int max = 0;

        if (left != null) {
            int lmin = left[0];
            int lmax = left[1];
            min = Math.min(min, lmin);
            max = Math.max(max, lmax);

            int diff = Math.max(Math.abs(node.val - lmax), Math.abs(node.val - lmin));
            ans = Math.max(ans, diff);
        }

        if (right != null) {
            int rmin = right[0];
            int rmax = right[1];
            min = Math.min(min, rmin);
            max = Math.max(max, rmax);

            int diff = Math.max(Math.abs(node.val - rmax), Math.abs(node.val - rmin));
            ans = Math.max(ans, diff);
        }

        return new int[] { Math.min(min, node.val), Math.max(max, node.val) };
    }
}
