import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class Traversal {
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

    public class Pair{
        TreeNode node;
        int height;
        Pair(TreeNode node, int height){
            this.height = height;
            this.node = node;
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        Pair p = new Pair(root, 0);
        List<List<Integer>> ans = new ArrayList<>();
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        queue.add(p);
        while(queue.size()>0){
            Pair peek = queue.pop();
            if(peek.node == null){
                continue;
            }
            if(peek.node.left!=null){
                queue.add(new Pair(peek.node.left, peek.height+1));
            }
            if(peek.node.right!=null){
                queue.add(new Pair(peek.node.right, peek.height+1));
            }
            if(ans.size()<=peek.height){
                ans.add(new ArrayList<>());
                ans.get(ans.size()-1).add(peek.node.val);
            }else{
                ans.get(peek.height).add(peek.node.val);
            }
        }
        return ans;
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while(queue.size()>0){
            ArrayList<Integer> list = new ArrayList<>();
            for(int i=queue.size(); i>=0; i--){
                root = queue.remove();
                list.add(root.val);

                if(root.left!=null) queue.add(root.left);
                if(root.right!=null) queue.add(root.right);
            }
            ans.add(list);
        }
        return ans;
    }
}
