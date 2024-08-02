import java.util.*;

public class CompletenessOfBT {

    class Solution {
        public boolean isCompleteTree(TreeNode root) {
            boolean end = false;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode cur = queue.poll();
                if (cur == null)
                    end = true;
                else {
                    if (end)
                        return false;
                    queue.add(cur.left);
                    queue.add(cur.right);
                }
            }
            return true;
        }

        boolean ans;

        public boolean isCompleteTreeDfs(TreeNode root) {
            int totalNodes = count(root);
            ans = true;
            helper(root, 0, totalNodes);
            return ans;
        }

        public void helper(TreeNode node, int index, int totalNodes) {
            if (node == null)
                return;
            if (index >= totalNodes)
                ans = false;
            helper(node.left, 2 * index + 1, totalNodes);
            helper(node.right, 2 * index + 2, totalNodes);
        }

        public int count(TreeNode node) {
            if (node == null)
                return 0;
            return 1 + count(node.left) + count(node.right);
        }

    }

    public boolean isCompleteTree(TreeNode root) {

        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        boolean prevCompleted = true;
        int h = 1;
        while (queue.size() > 0) {
            int size = queue.size();
            boolean nullFound = false;
            if (size != h) {
                prevCompleted = false;
            }
            if (!prevCompleted)
                return false;
            h = 2 * h;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                if (node.val == -1) {
                    nullFound = true;
                    continue;
                }
                if (nullFound)
                    return false;
                queue.add(node.left == null ? new TreeNode(-1) : node.left);
                queue.add(node.right == null ? new TreeNode(-1) : node.right);
            }
        }
        return true;
    }
}