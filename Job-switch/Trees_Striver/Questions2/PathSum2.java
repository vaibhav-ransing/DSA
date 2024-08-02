import java.util.*;

public class PathSum2 {

    List<Integer> singlePath = new ArrayList<>();
    List<List<Integer>> allPaths = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if (root == null)
            return allPaths;
        helper(root, target);
        return allPaths;
    }

    void helper(TreeNode root, int target) {
        if (root == null)
            return; // Base case

        singlePath.add(root.val);

        // Check if it's a leaf node and the target is met
        if (root.left == null && root.right == null && target == root.val) {
            allPaths.add(new ArrayList<>(singlePath)); // Add a copy of singlePath to allPaths
        }

        helper(root.left, target - root.val);
        helper(root.right, target - root.val);

        singlePath.remove(singlePath.size() - 1); // Backtrack to explore other paths
    }

}
