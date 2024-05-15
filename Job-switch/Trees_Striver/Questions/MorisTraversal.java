import java.util.ArrayList;
import java.util.List;

public class MorisTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> inorder = new ArrayList<>();
        if (root == null)
            return inorder;

        TreeNode curr = root;

        while (curr != null) {
            if (curr.left == null) {
                inorder.add(curr.val);
                curr = curr.right;
            } else {
                TreeNode temp = curr.left;

                while (temp.right != null && temp.right !=curr) {
                    temp = temp.right;
                }
                if(temp.right == null){  // if the curr.left's right most is not pointed to curr 
                    temp.right = curr;
                    curr = curr.left;
                }else{  // if right most of curr.left is pointed to curr then we done with left traversal this should be the middle element
                    temp.right = null;
                    inorder.add(curr.val);
                    curr = curr.right;
                }
            }
        }

        return inorder;

    }

    public static void main(String[] args) {

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