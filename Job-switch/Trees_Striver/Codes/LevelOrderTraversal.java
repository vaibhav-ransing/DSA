package Codes;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class LevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();
        ArrayDeque<TreeNode> preQueue = new ArrayDeque<>();
        if (root == null) {
            return ans; // Return an empty list since the tree is empty
        }
        preQueue.add(root);
        while (preQueue.size() > 0) {
            // we will push all the **child nodes** of **preQueue nodes** while popping into currQueue
            ArrayDeque<TreeNode> currQueue = new ArrayDeque<>();  

            // we will push all the **preQueue nodes val** into tempAns while popping.
            List<Integer> tempAns = new ArrayList<>();

            while (preQueue.size() > 0) {
                TreeNode node = preQueue.remove();
                if (node.left != null)
                    currQueue.add(node.left);
                if (node.right != null)
                    currQueue.add(node.right);
                tempAns.add(node.val);
            }
            ans.add(tempAns);
            while (currQueue.size() > 0) {
                preQueue.add(currQueue.remove());
            }
        }
        return ans;
    }
}