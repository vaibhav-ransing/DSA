package Traversal;

import java.util.ArrayList;
import java.util.List;

public class DFS_Traversals {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inorderDFS(root, ans);
        return ans;
    }

    public static void inorderDFS(TreeNode node, List<Integer> ans) {
        if (node == null)
            return;

        // if we add ans here then its pre order
        inorderDFS(node.left, ans);
        ans.add(node.val);
        inorderDFS(node.right, ans);
        // if we add ans here then it is post order
    }

    public static void main(String[] args) {
        Node n = new Node();
    }
}