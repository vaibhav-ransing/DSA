
public class Solution {

    public static int floorInBST(TreeNode<Integer> root, int x) {
        //    Write your code here.
        int ans = floorHelper(node, x);
        // Write your code here
        return ans == Integer.MIN_VALUE ? -1 : ans;
    }

    public static int floorHelper(TreeNode<Integer> node, int x) {
        if (node == null)
            return Integer.MIN_VALUE;
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