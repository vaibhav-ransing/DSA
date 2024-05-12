import java.util.HashMap;

public class PreordeInorder {

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        HashMap<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return recursion(preorder, inorder, 0, 0, inorder.length - 1, inorderMap);
    }

    public TreeNode recursion(int[] preorder, int[] inorder, int preIdx, int inL, int inR,
        HashMap<Integer, Integer> inorderMap) {

        if (preIdx >= preorder.length || inL > inR)
            return null;

        int val = preorder[preIdx];
        TreeNode node = new TreeNode(val);

        int inorderIdx = inorderMap.get(val);

        int leftSubTree = inorderIdx - inL;
        node.left = recursion(preorder, inorder, preIdx + 1, inL, inorderIdx - 1, inorderMap);
        node.right = recursion(preorder, inorder, preIdx + leftSubTree + 1, inorderIdx + 1, inR, inorderMap);

        return node;
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