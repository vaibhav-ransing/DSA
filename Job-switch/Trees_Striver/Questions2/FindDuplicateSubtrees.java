import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class FindDuplicateSubtrees {

    HashMap<String, Integer> map = new HashMap<>();
    List<TreeNode> ans;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        ans = new ArrayList<>();
        dfs(root);
        return ans;
    }

    public StringBuilder dfs(TreeNode node) {
        if (node == null)
            return new StringBuilder("N");

        StringBuilder left = dfs(node.left);
        StringBuilder right = dfs(node.right);

        String str = node.val + "," + left.toString() + "," + right.toString();

        if (map.getOrDefault(str, 0) == 1) {
            ans.add(node);
        }
        map.put(str, map.getOrDefault(str, 0) + 1);
        return new StringBuilder(str);
    }

}
