package Questions;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestor {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q)
            return root;
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left == null){
            return right;
        }else if(right == null){
            return left;
        }else{
            return root;
        }
    }

    public TreeNode lowestCommonAncestorMySoln(TreeNode root, TreeNode p, TreeNode q) {
        
        List<TreeNode> list1P = new ArrayList<>();
        List<TreeNode> list2Q = new ArrayList<>();
        rootToNoe(root, list1P, p);
        rootToNoe(root, list2Q, q);

        int minLen = Math.min(list1P.size(), list2Q.size());

        int idx = 0;
        for(int i=0; i<minLen; i++){
            if(list1P.get(i) == list2Q.get(i))
                idx++;
            else break;
        }
        idx = idx == 0 ? 0 : idx - 1;
        return list1P.get(idx);
    }

    
    public boolean rootToNoe(TreeNode node, List<TreeNode> list, TreeNode myNode){
        if(node == null){
            return false ;
        }

        if(node == myNode){
            list.add(node);
            return true;
        }
        boolean left = rootToNoe(node.left, list, myNode);
        boolean right = rootToNoe(node.right, list, myNode);

        if(left || right){
            list.add(0,node);
        }
        return left || right;
    }



}
