package Questions;

public class IsBalanced {

    boolean ans = true;

    public boolean isBalanced(TreeNode root) {
        heightCheck(root);
        System.out.println();
        return ans;
    }

    public int heightCheck(TreeNode node) {
        if (node == null)
            return 0;

        int left = heightCheck(node.left);
        int right = heightCheck(node.right);

        if (Math.abs(left - right) > 1)
            ans = false;

        return 1 + Math.max(left, right);
    }

    public int betterSoln(TreeNode node) {
        if (node == null)
            return 0;

        int left = betterSoln(node.left);
        int right = betterSoln(node.right);

        if(left < 0 || right < 0) return -1;

        if (Math.abs(left - right) > 1)
            return -1;

        return 1 + Math.max(left, right);
    }

}
