package BST;

import java.util.*;

public class RecoverBst {

    TreeNode firstViolation;
    TreeNode secondViolation;
    public void recoverTree(TreeNode root) {
        firstViolation = null;
        fixBst(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public void fixBst(TreeNode node, Long minRange, Long maxRange){
        if(node == null) return;

        if(node.val < minRange || node.val > maxRange){
            System.out.println(node.val);
            if(firstViolation == null){
                firstViolation = node;
            }else{
                secondViolation = node;
                
                // int temp = node.val;
                // node.val = firstViolation.val;
                // firstViolation.val = temp;
                // return;
            }
        }
        fixBst(node.left, minRange, (long) node.val);
        fixBst(node.right, (long) node.val, maxRange);
    }


    public List<Integer> inorder;
    public void recoverTree2(TreeNode root) {
        inorder = new ArrayList<>();
        fillInorder(root);
        Collections.sort(inorder);
        int[] idx = new int[1];
        fixInorder(root, idx);
    }

    public void fixInorder(TreeNode node, int[] idx) {
        if (node == null)
            return;

        fixInorder(node.left, idx);
        if (node.val != inorder.get(idx[0]))
            node.val = inorder.get(idx[0]++);
        fixInorder(node.right, idx);
    }

    public void fillInorder(TreeNode node) {
        if (node == null)
            return;

        fillInorder(node.left);
        inorder.add(node.val);
        fillInorder(node.right);
    }

}