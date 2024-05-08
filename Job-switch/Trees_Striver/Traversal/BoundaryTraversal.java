package Traversal;

import java.util.*;

public class BoundaryTraversal {

    public static List<Integer> traverseBoundary(TreeNode root) {
        // Write your code here.

        List<Integer> ans = new ArrayList<>();

        TreeNode node = root;
        Stack<TreeNode> stackLeft = new Stack<>();
        while (true) {
            if (node.left == null && node.right == null) {
                break;
            }
            stackLeft.push(node);
            // if left is null then go right.
            node = node.left == null ? node.right : node.left;
        }
        addLeafNode(root, stackLeft);


        Stack<TreeNode> stackRight = new Stack<>();
        node = root;
        while (true) {
            if (node.left == null && node.right == null) {
                break;
            }
            stackRight.push(node);
            node = node.right == null ? node.left : node.right;
        }

        while (stackRight.size() > 1) {
            System.out.println(stackRight.peek().data);
            stackLeft.push(stackRight.pop());
        }

        while (stackLeft.size() > 0) {
            ans.add(0, stackLeft.pop().data);
        }
        
        return ans;
    }

    public static void addLeafNode(TreeNode node, Stack<TreeNode> stackLeft) {
        if (node == null)
            return;

        if (node.left == null && node.right == null) {
            stackLeft.add(node);
            return;
        }

        addLeafNode(node.left, stackLeft);
        addLeafNode(node.right, stackLeft);
    }

    public static void main(String[] args) {

    }
}

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}