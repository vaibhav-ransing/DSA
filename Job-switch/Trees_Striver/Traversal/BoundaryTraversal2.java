package Traversal;
import java.util.*;

public class BoundaryTraversal2 {

    public static List<Integer> traverseBoundary(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root != null) {
            ans.add(root.data);
            leftBoundary(root.left, ans);
            leafNodes(root, ans);
            rightBoundary(root.right, ans);
        }
        return ans;
    }
    
    public static void leftBoundary(TreeNode node, List<Integer> ans){
        // handles the null case and we dont add leaf node 
        if (node == null || (node.left == null && node.right == null)) 
            return;

        ans.add(node.data);
        if(node.left != null){
            leftBoundary(node.left, ans);
        }else{
            leftBoundary(node.right, ans);
        }
    }

    public static void rightBoundary(TreeNode node, List<Integer> ans){
        if (node == null || (node.left == null && node.right == null))
            return;

        if(node.right != null){
            rightBoundary(node.right, ans);
        }else{
            rightBoundary(node.left, ans);
        }
        ans.add(node.data);
    }


    public static void leafNodes(TreeNode node, List<Integer> ans) {
        if (node == null)
            return;

        leafNodes(node.left, ans);
        if (node.left == null && node.right == null) {
            ans.add(node.data);
            return;
        }
        leafNodes(node.right, ans);
    }

}

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}