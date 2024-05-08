package Questions;

import java.util.ArrayDeque;

public class WIdth {

    public int diameterOfBinaryTree(TreeNode root) {

        if (root == null)
            return 0;
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int ans = 1;

        while (queue.size() > 0) {

            int n = queue.size(); // we must declare n and then use it in loop
            int temp = 0;
            for (int i = 0; i < n; i++) { // if we do i<queue.size here then when we append it will run extra loops
                root = queue.remove();

                if ((root.left == null || root.right == null) && (i == n - 1)) {
                    temp += root.right == null ? 1 : 2;
                } else {
                    temp += 2;
                }

                if (root.left != null)
                    queue.add(root.left);
                if (root.right != null)
                    queue.add(root.right);
            }
            System.out.println(temp);
            ans = Math.max(ans, temp);
        }

        return ans;
    }
}
