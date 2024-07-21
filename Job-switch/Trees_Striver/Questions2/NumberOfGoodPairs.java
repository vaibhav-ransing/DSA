package Questions2;

import java.util.HashMap;
import java.util.HashSet;

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

public class NumberOfGoodPairs {
    class Solution {

        HashMap<TreeNode, TreeNode> child_to_parent = new HashMap<>();
        HashSet<TreeNode> leafNodes = new HashSet<>();

        public int countPairs(TreeNode root, int distance) {
            fillMap(root);
            fillLeafNodes(root);
            int count = 0;

            for (TreeNode ln : leafNodes) {
                HashSet<TreeNode> visited = new HashSet<>(); // Reset visited for each leaf node
                count += rec(ln, distance, ln, visited);
            }

            return count / 2; // Each pair is counted twice, so divide by 2
        }

        public int rec(TreeNode node, int dis, TreeNode startNode, HashSet<TreeNode> visited) {
            if (node == null || dis < 0)
                return 0;

            if (leafNodes.contains(node) && dis >= 0 && node != startNode) {
                return 1;
            }

            if (visited.contains(node))
                return 0;

            visited.add(node);
            int count = 0;
            count += rec(node.left, dis - 1, startNode, visited);
            count += rec(node.right, dis - 1, startNode, visited);
            TreeNode parent = child_to_parent.get(node);
            count += rec(parent, dis - 1, startNode, visited);

            return count;
        }

        public void fillLeafNodes(TreeNode node) {
            if (node == null)
                return;
            if (node.left == null && node.right == null) {
                leafNodes.add(node);
                return;
            }
            fillLeafNodes(node.left);
            fillLeafNodes(node.right);
        }

        public void fillMap(TreeNode node) {
            if (node == null)
                return;
            if (node.left != null) {
                child_to_parent.put(node.left, node);
            }
            if (node.right != null) {
                child_to_parent.put(node.right, node);
            }
            fillMap(node.left);
            fillMap(node.right);
        }

    }

}