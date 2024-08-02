public class MaxProductOfSplittedBT {

    public int maxProduct(TreeNode root) {
        sum = sum(root);
        prod = 0;
        dfs(root);
        return prod;
    }

    int MOD = 1000000007;
    int sum;
    int prod = 0;

    int dfs(TreeNode node) {
        if (node == null)
            return 0;
        int left = dfs(node.left);
        int right = dfs(node.right);

        int currSum = (left + right + node.val) % MOD;
        int rem = (sum - currSum + MOD) % MOD; // Adding MOD to ensure non-negative
        prod = Math.max(prod, (int) (((long) rem * currSum) % MOD));

        return currSum;
    }

    int sum(TreeNode node) {
        if (node == null)
            return 0;
        return (node.val + sum(node.left) % MOD + sum(node.right) % MOD) % MOD;
    }

}
