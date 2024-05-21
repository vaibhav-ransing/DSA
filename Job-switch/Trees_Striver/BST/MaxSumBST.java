package BST;

public class MaxSumBST {

    int ans;
    public int maxSumBST(TreeNode root) {
        ans = 0;
        helper(root);
        return ans;
    }

    public Pair helper(TreeNode node){

        if(node.left == null && node.right == null){
            ans = Math.max(ans, node.val);
            return new Pair(node.val, node.val, true, node.val);
        }
        
        Pair left = null;
        Pair right = null;
        if (node.left != null)
            left = helper(node.left);
        if (node.right != null)
            right = helper(node.right);

        boolean isValid = true;
        int max = node.val;
        int min = node.val;
        int sum = node.val;

        if (left != null) {
            isValid = isValid && (left.max < node.val) && left.isValid;
            min = Math.min(min, left.min);
            max = Math.max(max, left.max);
            sum += left.sum;
        }
        if (right != null) {
            isValid = isValid && (right.min > node.val) && right.isValid;
            min = Math.min(min, right.min);
            max = Math.max(max, right.max);
            sum += right.sum;
        }
        if(isValid) ans = Math.max(ans, sum);
        return new Pair(min, max, isValid, sum);

    }

}

class Pair {

    int min;
    int max;
    boolean isValid;
    int sum;

    Pair(int min, int max, boolean isValid, int sum) {
        this.min = min;
        this.max = max;
        this.isValid = isValid;
        this.sum = sum;
    }
}
