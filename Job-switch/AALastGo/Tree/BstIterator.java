package AALastGo.Tree;

import java.util.ArrayList;
import java.util.Stack;

public class BstIterator {
    // O(n) space
    class BSTIterator1 {

        static ArrayList<Integer> inorder;
        int idx = 0;

        public BSTIterator1(TreeNode root) {
            inorder = new ArrayList<>();
            idx = 0;
            fillInOrder(root);
        }

        public static void fillInOrder(TreeNode node) {
            if (node == null)
                return;
            fillInOrder(node.left);
            inorder.add(node.val);
            fillInOrder(node.right);
        }

        public int next() {
            return inorder.get(idx++);
        }

        public boolean hasNext() {
            return idx < inorder.size();
        }
    }

    // O(H) space
    class BSTIterator {

        Stack<TreeNode> stack;

        public BSTIterator(TreeNode root) {
            stack = new Stack<>();
            TreeNode node = root;
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }

        public int next() {
            TreeNode top = stack.pop();
            if (top.right != null) {
                TreeNode temp = top.right;
                while (temp != null) {
                    stack.push(temp);
                    temp = temp.left;
                }
            }
            return top.val;
        }

        public boolean hasNext() {
            return stack.size() > 0;
        }
    }
}
