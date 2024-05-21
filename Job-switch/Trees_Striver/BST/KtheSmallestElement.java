package BST;

public class KtheSmallestElement {

    public int kthSmallest(TreeNode root, int k) {
        globalK = 0;
        ans = -1;
        helper(root, k);
        return ans;
    }

    int globalK = 0;
    int ans = -1;

    public void helper(TreeNode node, int k) {
        if (node == null)
            return;

        helper(node.left, k);
        globalK++;
        if (globalK == k) {
            ans = node.val;
            return;
        }
        helper(node.right, k);
    }

}
