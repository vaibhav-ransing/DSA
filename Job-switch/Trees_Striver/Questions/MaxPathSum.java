package Questions;

public class MaxPathSum {
    

    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        int val = betterSoln(root);
        ans = Math.max(val, ans);
        return ans;
    }

    public int betterSoln(TreeNode node){

        if(node == null) return 0;

        int left = Math.max(0, betterSoln(node.left));
        int right = Math.max(0, betterSoln(node.right));
        ans = Math.max(ans, left + right + node.val);
        
        return Math.max(left , right) + node.val;

    }
    public int helper(TreeNode node){

        if(node == null) return 0;

        int left = helper(node.left);
        int right = helper(node.right);

        int leftOnly = left + node.val;
        int rightOnly = right + node.val;
        int both = left + right + node.val;
        int none = node.val;

        int max = Math.max(both, Math.max(none, Math.max(leftOnly, rightOnly)));
        ans = Math.max(ans, max);
        
        return Math.max(left, right) < 0 ? node.val :  Math.max(left, right) + node.val;

    }


}
