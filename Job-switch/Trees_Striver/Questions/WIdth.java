package Questions;
import java.util.*;

public class WIdth {

    public int widthOfBinaryTree(TreeNode root) {

        if (root == null)
            return 0;
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(root, 1));

        int maxWith = 1;
        while (queue.size() > 0) {
            int n = queue.size();
            int leftIndexOfStart = queue.peek().index;

            for (int i = 0; i < n; i++) {

                Pair peek = queue.remove();
                TreeNode currNode = peek.node;
                int currIndex = peek.index;

                if (currNode.left != null)
                    queue.add(new Pair(currNode.left, 2 * currIndex));

                if (currNode.right != null)
                    queue.add(new Pair(currNode.right, 2 * currIndex + 1));

                maxWith = Math.max(maxWith, currIndex - leftIndexOfStart + 1);
            }
        }
        return maxWith;
    }
}

class Pair {
    TreeNode node;
    int index;
    Pair(TreeNode node, int index) {
        this.node = node;
        this.index = index;
    }
}