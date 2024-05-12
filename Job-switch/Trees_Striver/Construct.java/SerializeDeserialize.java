import java.util.*;

public class SerializeDeserialize {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        helper(root, sb);
        return sb.toString();
    }

    public void helper(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null,");
            return;
        }
        sb.append(root.val);
        helper(root.left, sb);
        helper(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        Stack<Pair> stack = new Stack<>();
        String[] arr = data.split(",");
        
        String rootVal = arr[0];
        if(rootVal == "null") return null;

        Pair root = new Pair(Integer.parseInt(rootVal) , 0);
        

        return null;
    }

}

class Pair {

    int val;
    int count;

    Pair(int val, int count) {
        this.val = val;
        this.count = count;
    }
}