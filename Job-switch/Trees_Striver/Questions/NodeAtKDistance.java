package Questions;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
// [0,1,null,3,2]
public class NodeAtKDistance {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        HashMap<TreeNode, TreeNode> parentMap = getParentMap(root);
        System.out.println(parentMap.size());
        for(TreeNode tn : parentMap.keySet()){
            System.out.println("child= "+tn.val +" | parent= " + (parentMap.get(tn)==null ? "null" : parentMap.get(tn).val));
        }
        List<Integer> ans = new ArrayList<>();
        HashSet<TreeNode> set = new HashSet<>();
        getDistanceNodeK(target, parentMap, k, ans, set);
        return ans;
    }

    public void getDistanceNodeK(TreeNode node, HashMap<TreeNode, TreeNode> parentMap, int k, List<Integer> ans, HashSet<TreeNode> set) {
        if (k == 0 || node == null) {
            if (node == null || set.contains(node))
                return;
            ans.add(node.val);
            return;
        }
        set.add(node);
        // we have 3 option go left right or to parent
        getDistanceNodeK(parentMap.get(node), parentMap, k-1, ans, set);
        getDistanceNodeK(node.left, parentMap, k-1, ans, set);
        getDistanceNodeK(node.right, parentMap, k-1, ans, set);
        set.remove(node);
    }

    public HashMap<TreeNode, TreeNode> getParentMap(TreeNode root) {
        HashMap<TreeNode, TreeNode> parentMap = new HashMap<>();
        parentMap.put(root, null);
        // A
        // / \
        // B C
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
