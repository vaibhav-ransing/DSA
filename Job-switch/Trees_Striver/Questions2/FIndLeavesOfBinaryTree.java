import java.util.ArrayList;
import java.util.List;

public class FIndLeavesOfBinaryTree {

    List<List<Integer>> ans;

    public int hit(TreeNode node) {
        if (node == null)
            return 0;
        return Math.max(hit(node.left), hit(node.right)) + 1;
    }

    public void soln(TreeNode node) {
        int h = hit(node);
        ans = new ArrayList<>();
        for (int i = 0; i < h; i++) {
            ans.add(new ArrayList<>());
        }
    }

    public int dfs(TreeNode node) {
        if (node == null)
            return 0;

        int lh = dfs(node.left);
        int rh = dfs(node.right);

        int myHt = Math.max(lh, rh);
        ans.get(myHt).add(node.val);

        return Math.max(lh, rh) + 1;
    }
}
