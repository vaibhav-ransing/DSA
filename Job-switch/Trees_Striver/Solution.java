import java.util.*;

public class Solution {

    public static List<Integer> traverseBoundary(TreeNode root) {
        List<Integer> boundary = new ArrayList<>();
        if (root != null) {
            boundary.add(root.data);
            leftBoundary(root.left, boundary);
            leafNodes(root, boundary);
            rightBoundary(root.right, boundary);
        }
        return boundary;
    }
    private static void leftBoundary(TreeNode node, List<Integer> boundary) {
        if (node != null) { // handles the null case
            if (node.left != null || node.right != null) { // makes sure not a leaf node
                boundary.add(node.data);
                if (node.left != null) {
                    leftBoundary(node.left, boundary);
                } else {
                    leftBoundary(node.right, boundary);
                }
            }
        }
    }
    private static void rightBoundary(TreeNode node, List<Integer> boundary) {
        if (node != null) {
            if (node.left != null || node.right != null) {
                if (node.right != null) {
                    rightBoundary(node.right, boundary);
                } else {
                    rightBoundary(node.left, boundary);
                }
                boundary.add(node.data);
            }
        }
    }
    private static void leafNodes(TreeNode node, List<Integer> boundary) {
        if (node != null) {
            leafNodes(node.left, boundary);
            if (node.left == null && node.right == null) {
                boundary.add(node.data);
            }
            leafNodes(node.right, boundary);
        }
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
