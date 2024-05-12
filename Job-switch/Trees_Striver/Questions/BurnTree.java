import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;

public class BurnTree {

    public int amountOfTime(TreeNode root, int start) {

        TreeNode target = getNode(root, start);
        HashMap<TreeNode, TreeNode> parentMap = getParentMap(root);

        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        HashSet<TreeNode> set = new HashSet<>();
        queue.add(target);

        int distance = -1;  // distance++ will also increment for target node which we dont want
        while (queue.size() > 0) {
            
            int n = queue.size();
            for(int i=0; i<n; i++){
                
                root = queue.remove();
                set.add(root);
                if(root.left != null && !set.contains(root.left)){
                    queue.add(root.left);
                }
                if(root.right != null && !set.contains(root.right)){
                    queue.add(root.right);
                }
                if(parentMap.get(root) != null && !set.contains(parentMap.get(root))){
                    queue.add(parentMap.get(root));
                }
            }
            distance++;
        }
        return distance;
    }

    public TreeNode getNode(TreeNode node, int start){

        if(node == null) return null;
        if(node.val == start){
            return node;
        }

        TreeNode left = getNode(node.left, start);
        TreeNode right = getNode(node.right, start);

        return left == null ? right : left;
    }

    public HashMap<TreeNode, TreeNode> getParentMap(TreeNode root) {
        HashMap<TreeNode, TreeNode> parentMap = new HashMap<>();
        parentMap.put(root, null);
        //  A
        // / \
        // B  C
        // A : null | B : A | C : A (this will be hashmap)
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        TreeNode node;
        while (queue.size() > 0) {
            int n = queue.size();

            for (int i = 0; i < n; i++) {
                node = queue.remove();
                if (node.left != null) {
                    parentMap.put(node.left, node);
                    queue.add(node.left);
                }
                if (node.right != null) {
                    parentMap.put(node.right, node);
                    queue.add(node.right);
                }
            }
        }

        return parentMap;
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