import java.util.ArrayList;
import java.util.List;

public class Lc863 {
    


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    
    public static List<Integer> ans;

    public static void dfs(TreeNode node,  int k){
        if(k<0 || node==null)
            return;

        if(k==0)
            ans.add(node.val);

        dfs(node.left, k-1);
        dfs(node.right, k-1);
    }

    public static int helper(TreeNode node, TreeNode target, int k){
        if(node==null){
            return 0;
        }
        if(node.val == target.val){
            dfs(node.left, k-1);
            dfs(node.right, k-1);
            return 1;
        }
        int left = helper(node.left, target, k);
        if(left>0){
            dfs(node.right, k-left-1);
            if(left==k) ans.add(node.val);
            return 1+left;
        }

        int right = helper(node.right, target, k);
        if(right>0){
            dfs(node.left, k-right-1);
            if(right==k) ans.add(node.val);
            return 1+right;
        }
        return -1;
    }

    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        ans = new ArrayList<>();
        helper(root, target, k);
        return ans;
    }


    public static void main(String[] args) {
        
    }
}
