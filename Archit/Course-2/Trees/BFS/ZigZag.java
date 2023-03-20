import java.util.ArrayDeque;
import java.util.*;

public class ZigZag {
    
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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        if(root==null)
            return ans;
        queue.add(root);
        boolean flag = false;
        while(queue.size()>0){
            ArrayList<Integer> list = new ArrayList<>();
            for(int i=queue.size(); i>0; i--){
                root = queue.remove();
                list.add(root.val);

                if(root.left!=null) queue.add(root.left);
                if(root.right!=null) queue.add(root.right);
            }
            if(flag)
                Collections.reverse(list);
            flag = !flag;
            ans.add(list);
        }
        return ans;
    }
}
