public class CountGoodNodesInBT {
    
    public int goodNodes(TreeNode root) {
        return rec(root, root.val);
    }

    public int rec(TreeNode node, int max) {
        if (node == null)
            return 0;
        int count = node.val >= max ? 1 : 0;

        count += rec(node.left, Math.max(max, node.val));
        count += rec(node.right, Math.max(max, node.val));

        return count;
    }
}