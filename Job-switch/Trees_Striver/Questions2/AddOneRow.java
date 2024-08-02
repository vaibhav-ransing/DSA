public class AddOneRow {

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        TreeNode ans = dfs(root, val, depth);
        return ans;
    }

    public TreeNode dfs(TreeNode node, int val, int depth) {

        // If we reach leaf node
        if (node == null && depth == 1)
            return new TreeNode(val);

        if (node == null)
            return null;

        if (depth - 1 == 1) {
            // new Node that will come to left and right of current node
            TreeNode leftNodeNew = new TreeNode(val);
            TreeNode rightNodeNew = new TreeNode(val);

            // left and right of current node
            // left will go to newLeftNode and right to newRightNode
            TreeNode lft = node.left;
            TreeNode rgt = node.right;

            // left and right of new Nodes
            leftNodeNew.left = lft;
            rightNodeNew.right = rgt;

            node.left = leftNodeNew;
            node.right = rightNodeNew;

        } else {
            node.left = dfs(node, val, depth - 1);
            node.right = dfs(node, val, depth - 1);
        }
        return node;
    }
}
