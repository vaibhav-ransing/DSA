import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

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