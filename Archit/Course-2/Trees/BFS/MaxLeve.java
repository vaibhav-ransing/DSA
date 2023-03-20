import java.util.ArrayDeque;

public class MaxLeve {
    
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int maxLevelSum(TreeNode root) {
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int maxSum = Integer.MIN_VALUE, maxLevel = 0;
        int currSum=0, currLevel=0;
        while(queue.size()>0){
            currLevel++;
            currSum = 0;
            for(int i=queue.size(); i>0; i--){
                root = queue.remove();
                currSum+=root.val;
                if(root.left!=null) queue.add(root.left);
                if(root.right!=null) queue.add(root.right);
            }
            if(currSum>maxSum){
                maxSum = currSum;
                maxLevel = currLevel;
            }
        }
        return maxLevel;
    }
}
