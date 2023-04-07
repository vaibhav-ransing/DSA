import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SumPath2 {
    
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

    // public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
    // }

    public static class Pair{
        TreeNode node;
        int count;
        Pair(TreeNode node, int count){
            this.node = node;
            this.count = count;
        }
    }
    public static void traversal(TreeNode root){
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, 0));
        List<Integer> list = new ArrayList<>();
        while(stack.size()>0){
            Pair peek = stack.peek();
            if(peek.node==null)
                continue;
            if(peek.count==0){
                // left
                if(peek.node.left!=null){
                    peek.count++;
                    stack.push(new Pair(peek.node.left, 0));
                }
            }else if(peek.count==1){
                // right
                peek.count++;
                stack.push(new Pair(peek.node.right, 0));
                list.add(peek.node.val);
            }else{
                stack.pop();
            }
        }
    }
}