package Traversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class RightView {
    

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightView = new ArrayList<>();
        if(root == null) return rightView;
        
        List<Integer> leftView = new ArrayList<>();
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (queue.size() > 0) {
            
            int n = queue.size();

            for(int i = 0; i<n; i++){
                root = queue.remove();
                if(i == n-1){
                    rightView.add(root.val);
                }
                if( i == 0){
                    leftView.add(root.val);
                }
                if(root.left != null) queue.add(root.left);
                if(root.right != null) queue.add(root.right);
            }
        }
        System.out.println(leftView);
        return rightView;
    }   

    static class Pair{
        int col;
        int data;

        Pair(int col, int data){
            this.col = col;
            this.data = data;
        }
    }


}
