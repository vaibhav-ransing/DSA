package ZRandom.Tree;

import java.util.HashMap;

public class HeightOfBTAfterSubTreeremovalquers {

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

    public int[] treeQueries(TreeNode root, int[] queries) {
        buildMap(root, root);
        ht(root);

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            TreeNode curr = valueNodeMap.get(queries[i]);
            TreeNode par = childToParent.get(curr);
            while (curr != par) {
                
            }

        }
    }

    int ht(TreeNode node) {
        if (node == null)
            return 0;
        int lh = ht(node.left);
        int rh = ht(node.right);
        leftRightHeightMap.put(node.val, new int[] { lh, rh });
        return 1 + Math.max(lh, rh);
    }

    HashMap<TreeNode, TreeNode> childToParent;
    HashMap<Integer, TreeNode> valueNodeMap;

    HashMap<Integer, int[]> leftRightHeightMap;

    public void buildMap(TreeNode node, TreeNode parent) {
        if (node == null) {
            return;
        }
        childToParent.put(node, parent);
        valueNodeMap.put(node.val, node);

        buildMap(node.left, node);
        buildMap(node.right, node);
    }
}
