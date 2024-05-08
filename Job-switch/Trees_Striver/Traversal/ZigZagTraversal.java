package Traversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ZigZagTraversal {
    

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> ans = new ArrayList<>();

        if(root == null) return ans;
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        boolean flagLeftToRight = true;
        while (queue.size() > 0) {
            
            List<Integer> tempAns = new ArrayList<>();
            int n = queue.size();

            for(int i=0; i<n; i++){
                root = queue.pop();
                tempAns.add(root.val);
                
                if(root.left != null) queue.add(root.left);
                if(root.right != null) queue.add(root.right);
            }
            if(!flagLeftToRight) Collections.reverse(tempAns);
            flagLeftToRight = !flagLeftToRight;
            ans.add(tempAns);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("heello");
    }
}

class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    public BinaryTreeNode(T data) {
        this.data = data;
    }
}