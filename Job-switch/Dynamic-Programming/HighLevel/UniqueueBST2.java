import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.tree.TreeNode;

import org.w3c.dom.Node;

public class UniqueueBST2 {

    public List<TreeNode> generateTrees(int n) {
        int[] arr = new int[n];
        for (int i = 1; i <= n; i++) {
            arr[i - 1] = i;
        }
    }

    public List<TreeNode> rec(int[] arr, int left, int right) {

        List<TreeNode> all_tress = new ArrayList<>();
        if (left > right){
            all_tress.add(null);
            return all_tress;
        }
        for (int i = left; i <= right; i++) {
            List<Node> left_tress = new ArrayList<>();
            List<Node> right_tress = new ArrayList<>();
            
        }
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
