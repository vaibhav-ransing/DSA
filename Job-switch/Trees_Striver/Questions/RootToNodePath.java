package Questions;

import java.util.ArrayList;
import java.util.List;

public class RootToNodePath {
    

    public List<String> binaryTreePaths(TreeNode root) {
        
        List<String> list = new ArrayList<>();
        preorderTraversal(root, root.val+"->", list);
        return list;
    }

    public void preorderTraversal(TreeNode node, String str, List<String> list){
        if(node == null){
            return;
        }
        if(node.left == null && node.right == null){
            list.add(str+node.val);
            return;
        }
        preorderTraversal(node.left, str+"->"+node.val, list);
        preorderTraversal(node.right, str+"->"+node.val, list);
    }


    // Coding ninjas
    public static ArrayList<Integer> pathInATree(TreeNode root, int x) {
        // Write your code here..
        ArrayList<Integer> list = new ArrayList<>();
        helper(root, x, list);
        return list;
    }

    public static boolean helper(TreeNode node, int x, ArrayList<Integer> list){
        if(node == null) return false;

        if(node.val == x){
            list.add(node.val);
            return true;
        }

        boolean left = helper(node.left, x, list);
        boolean right = helper(node.right, x, list);

        if(left || right){
            list.add(0,node.val);
        }
        return left || right;
    }



}
