package ZRandom.Tree;

public class HeightOfBTAfterSubtreeRemovalQueires {
    
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
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            if (root.val == queries[i])
                continue;
            ans[i] = ht(root, queries[i]);
        }
        return ans;
    }

    public int ht(TreeNode node, int rm) {
        if (node == null || node.val == rm) {
            return 0;
        }
        return 1 + Math.max(ht(node.left, rm), ht(node.right, rm));
    }

}
