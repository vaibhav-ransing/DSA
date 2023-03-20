import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class View {
    
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
    public List<Integer> rightSideView(TreeNode root) {
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        List<Integer> ans = new ArrayList<>();
        if(root==null){
            return ans;
        }
        queue.add(root);
        int tempAns = 0;
        while(queue.size()>0){
            for(int i=queue.size(); i>0; i--){
                root = queue.remove();
                tempAns = root.val;
                if(root.left!=null) queue.add(root.left);
                if(root.right!=null) queue.add(root.right);
            }
            ans.add(tempAns);
        }
        return ans;
    }

    class Node{
        int data;
        Node left, right;
        Node(int item){
            data = item;
            left = right = null;
        }
    }
    ArrayList<Integer> leftView(Node root){
        ArrayDeque<Node> queue = new ArrayDeque<>();
        ArrayList<Integer> ans = new ArrayList<>();
        if(root==null){
            return ans;
        }
        queue.add(root);
        while(queue.size()>0){
            boolean flag = true;
            for(int i=queue.size(); i>0; i--){
                root = queue.remove();
                if(flag){
                    ans.add(root.data);
                    flag = false;
                }
                if(root.left!=null) queue.add(root.left);
                if(root.right!=null) queue.add(root.right);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        
    }
}
