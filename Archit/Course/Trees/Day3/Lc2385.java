import javax.swing.border.EtchedBorder;

public class Lc2385 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static int max;
    public static void dfs(TreeNode node, int time){
        if(node==null){
            return;
        }
        max = Math.max(max, time);
        dfs(node.left, time+1);
        dfs(node.right, time+1);
    }
    public static int helper(TreeNode node, int start){
        if(node==null){
            return 0;
        }
        if(node.val==start){
            dfs(node.left, 1);
            dfs(node.right, 1);
            return 1;
        }
        int left = helper(node.left, start);
        if(left>0){
            max = Math.max(max, left);
            dfs(node.right, left+1);
            return left+1;
        }
        int right = helper(node.right, start);
        if(right>0){
            max = Math.max(max, right);
            dfs(node.right, right+1);
            return right+1;
        }
        return -1;
    }

    public int amountOfTime(TreeNode root, int start) {
        max=0;
        helper(root, start);
        return max;
    }

}
