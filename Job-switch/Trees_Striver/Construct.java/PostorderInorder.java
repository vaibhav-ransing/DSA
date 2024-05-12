import java.util.HashMap;

public class PostorderInorder {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return recursion(postorder, inorder, postorder.length - 1, 0, inorder.length - 1, inorderMap);
    }

    public TreeNode recursion(int[] postorder, int[] inorder, int postIdx, int inL, int inR,
            HashMap<Integer, Integer> inorderMap) {

        if (postIdx < 0 || inL > inR)
            return null;

        int val = postorder[postIdx];
        TreeNode node = new TreeNode(val);

        int inorderIdx = inorderMap.get(val);
        int rightSubTree = inR - inorderIdx; // Calculate the size of the right subtree

        // Recur for right subtree first, then left subtree
        node.right = recursion(postorder, inorder, postIdx - 1, inorderIdx + 1, inR, inorderMap);
        node.left = recursion(postorder, inorder, postIdx - rightSubTree - 1, inL, inorderIdx - 1, inorderMap);

        return node;
    }
}