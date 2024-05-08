package Traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativeTravesalPepcoding {

    public static List<List<Integer>> getTreeTraversal(TreeNode root) {

        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, 1));

        List<Integer> preOrder = new ArrayList<>();
        List<Integer> inOrder = new ArrayList<>();
        List<Integer> postOrder = new ArrayList<>();

        while (stack.size() > 0) {

            Pair peek = stack.peek();
            root = peek.node;
            if (peek.state == 1) {
                preOrder.add(root.data);
                peek.state += 1;
                if (root.left != null)
                    stack.push(new Pair(root.left, 1));
            } else if (peek.state == 2) {
                inOrder.add(root.data);
                peek.state += 1;
                if (root.right != null)
                    stack.push(new Pair(root.right, 1));
            } else {
                postOrder.add(root.data);
                stack.pop();
            }

        }

        List<List<Integer>> ans = new ArrayList<>();
        ans.add(inOrder);
        ans.add(preOrder);
        ans.add(postOrder);

        return ans;
    }
}

class Pair {

    TreeNode node;
    int state;

    Pair(TreeNode node, int state) {
        this.node = node;
        this.state = state;
    }
}

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode() {
        this.data = 0;
        this.left = null;
        this.right = null;
    }

    TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    TreeNode(int data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
};