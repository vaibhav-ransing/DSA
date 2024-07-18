package Questions2;

import java.util.*;

public class DeleteNodeReturnForest {
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

    HashSet<Integer> to_del = new HashSet<>();
    List<TreeNode> ans = new ArrayList<>();

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        for (int val : to_delete) {
            to_del.add(val);
        }
        TreeNode r = dfs(root);
        if(r != null)
            ans.add(r);
        return ans;
    }

    public TreeNode dfs(TreeNode node) {
        if (node == null)
            return null;

        node.left = dfs(node.left);
        node.right = dfs(node.right);
        System.out.println(node.val + " " + (node.left == null ? "null" : node.left.val)
                + (node.right == null ? "null" : node.right.val));

        if (to_del.contains(node.val)) {
            if (node.left != null) {
                ans.add(node.left);
            }
            if (node.right != null) {
                ans.add(node.right);
            }
            return null;
        } else {
            return node;
        }
    }
}
