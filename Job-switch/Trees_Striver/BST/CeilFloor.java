package BST;

public class CeilFloor {

    public static int findCeil(TreeNode<Integer> node, int x) {
        int ans = ceilHelper(node, x);
        // Write your code here
        return ans == Integer.MIN_VALUE ? -1 : ans;
    }

    public static int ceilHelper(TreeNode<Integer> node, int x) {
        if (node == null)
            return Integer.MIN_VALUE;
        int val;
        if (node.data < x) {
            val = ceilHelper(node.right, x);
        } else {
            val = ceilHelper(node.left, x);
        }
        int curr = node.data >= x ? node.data : Integer.MIN_VALUE;
        if (curr != Integer.MIN_VALUE && val != Integer.MIN_VALUE) {
            return Math.min(curr, val);
        }
        return Math.max(curr, val);
    }

    public static int floorHelper(TreeNode<Integer> node, int x) {
        if (node == null)
            return Integer.MAX_VALUE;
        // x=7 ans=6
        int val;
        if (x < node.data) {
            val = floorHelper(node.left, x);
        } else {
            val = floorHelper(node.right, x);
        }
        int curr = node.data <= x ? node.data : Integer.MIN_VALUE;
        if (curr != Integer.MIN_VALUE && val != Integer.MIN_VALUE) {
            return Math.min(curr, val);
        }
        return Math.max(curr, val);
    }
}

class TreeNode<T> {
    T data;
    TreeNode<T> left;
    TreeNode<T> right;

    TreeNode(T data) {
        this.data = data;
        left = null;
        right = null;
    }
};