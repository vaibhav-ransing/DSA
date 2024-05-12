
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;

public class BurnTreeUsingHeight {

    public int max = 0;

    public int amountOfTime(TreeNode root, int start) {
        DFS(root, start);
        return max;
    }

    public int DFS(TreeNode node, int start) {

        if (node == null)
            return 0;
        System.out.println("node.val = "+ node.val);
        if (node.val == start) {
            int leftOfStart = DFS(node.left, start);
            int rightOfStart = DFS(node.right, start);
            max = Math.max(max, Math.max(leftOfStart, rightOfStart));
            System.out.println( "node= "+ node.val +", leftOfStart= "+ leftOfStart +", rightOfStart=" + rightOfStart +" "+ max);
            return -1;
        }
        int left = DFS(node.left, start);
        int right = DFS(node.right, start);

        if (left < 0 || right < 0) {
            int lenBtwLeftRight = Math.abs(left) + Math.abs(right);
            max = Math.max(max, lenBtwLeftRight);
            return 1;
        }
        max = Math.max(max, 1 + Math.max(left, right));
        System.out.println( "node= "+ node.val +", left= "+ left +", right=" + right +" "+ max);
        return 1 + Math.max(left, right);
    }

    int distanceFromRootToStart(TreeNode root, int start) {
        if (root == null)
            return 99999;
        if (root.val == start)
            return 0;

        int left = distanceFromRootToStart(root.left, start);
        int right = distanceFromRootToStart(root.right, start);

        return 1 + Math.min(left, right);
    }

    int height(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}