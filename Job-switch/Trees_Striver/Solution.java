/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int max = 0;

    public int amountOfTime(TreeNode root, int start) {
        DFS(root, start);
        return max;
    }

    public int DFS(TreeNode node, int start) {

        if (node == null)
            return 0;
        if (node.val == start) {
            System.out.println("node_started "+ node.val);

            int leftOfStart = DFS(node.left, start);
            int rightOfStart = DFS(node.right, start);

            max = Math.max(max, Math.max(leftOfStart, rightOfStart));

            System.out.println( "node= "+ node.val +", leftOfStart= "+ leftOfStart +", rightOfStart=" + rightOfStart +" max="+ max);

            return -1;
        }
        int left = DFS(node.left, start);
        int right = DFS(node.right, start);

        if (left < 0 || right < 0) {
            int lenBtwLeftRight = Math.abs(left) + Math.abs(right);
            left = left < 0 ? -left -1 : left;
            right = right < 0 ? -right-1 : right;
            max = Math.max(max, lenBtwLeftRight);
            System.out.println( "node= "+ node.val +", left= "+ left +", right=" + right +" max="+ max);
            return 1;
        }
        int lenBtwLeftRight = Math.abs(left) + Math.abs(right);
        max = Math.max(max, lenBtwLeftRight);
        max = Math.max(max, 1 + Math.max(left, right));
        System.out.println( "node= "+ node.val +", left= "+ left +", right=" + right +" max="+ max);
        return 1 + Math.max(left, right);
    }
    // node_started 4
    // node= 1, left= 0, right=0 max=1
    // node= 4, leftOfStart= 1, rightOfStart=0 max=1
    // node= 2, left= -1, right=0 max=1
    // node= 3, left= 0, right=0 max=1
    // node= 5, left= 1, right=1 max=2
}