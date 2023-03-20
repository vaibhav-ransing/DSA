import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativeTraversal {
    
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

    public class pair{
        TreeNode node;
        int state;
        pair(TreeNode node){
            this.node = node;
            this.state = 1;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        pair p = new pair(root);
        Stack<pair> stack = new Stack<>();
        stack.push(p);
        List<Integer> ans = new ArrayList<>();
        while(stack.size()>0){
            pair peek = stack.peek();
            
            if(peek.state==1){
                if(peek.node.left!=null){
                    stack.push(new pair(peek.node.left));
                }
                peek.state++;
            }else if(peek.state==2){
                if(peek.node.right!=null){
                    stack.push(new pair(peek.node.right));
                }
                ans.add(peek.node.val);
                peek.state++;
            }else{
                stack.pop();
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        
    }
}
