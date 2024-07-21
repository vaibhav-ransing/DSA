package Questions2;
import java.util.*;

public class DeleteNodeReturnForest {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    HashSet<Integer> to_del = new HashSet<>();
    List<TreeNode> ans = new ArrayList<>();

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        for (int val : to_delete) {
            to_del.add(val);
        }
        TreeNode r = dfs(root);
        if (r != null)
            ans.add(r);
        return ans;
    }

    public TreeNode dfs(TreeNode node) {
        if (node == null)
            return null;

        node.left = dfs(node.left);
        node.right = dfs(node.right);

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
