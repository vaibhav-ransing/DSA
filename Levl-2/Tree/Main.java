import java.util.*;

public class Main {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        helperSerialize(root, sb);
        return sb.toString();
    }

    public static void helperSerialize(TreeNode node, StringBuilder sb){
        if(node==null){
            sb.append("null,");
            return;
        }
        sb.append(node.val+",");
        helperSerialize(node.left, sb);
        helperSerialize(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public static class pair{   
        TreeNode node;
        int state=0;
        pair(TreeNode node, int state){
            this.node = node;
            this.state = state;
        }
    }
    public static TreeNode deserialize(String str) {
        String[] arr = str.split(",");
        Stack<pair> stack = new Stack<>();
        TreeNode node = new TreeNode(Integer.parseInt(arr[0]));

        if(arr.length==0 || arr[0]==null)
            return null;

        stack.push(new pair(node, 0));
        int i=1;
        while(stack.size()>0){
            pair peek = stack.peek();

            if(peek.state==0){
                if(arr[i].equals("null")==false){
                    TreeNode left = new TreeNode(Integer.parseInt(arr[i]));
                    stack.push(new pair(left, 0));
                    peek.node.left = left;
                }
                peek.state++;
                i++;
            }else if(peek.state==1){
                if(arr[i].equals("null")==false){
                    TreeNode right = new TreeNode(Integer.parseInt(arr[i]));
                    stack.push(new pair(right, 0));
                    peek.node.right = right;
                }
                peek.state++;
                i++;
            }else{
                stack.pop();
            }
        }
        return node;
    }



    // input_section=================================================

    public static void display(TreeNode node) {
        if (node == null)
            return;

        StringBuilder sb = new StringBuilder();
        sb.append((node.left != null ? node.left.val : "."));
        sb.append(" -> " + node.val + " <- ");
        sb.append((node.right != null ? node.right.val : "."));

        System.out.println(sb.toString());

        display(node.left);
        display(node.right);

    }

    public static TreeNode createTree(int[] arr, int[] IDX) {
        if (IDX[0] > arr.length || arr[IDX[0]] == -1) {
            IDX[0]++;
            return null;
        }
        TreeNode node = new TreeNode(arr[IDX[0]++]);
        node.left = createTree(arr, IDX);
        node.right = createTree(arr, IDX);

        return node;
    }

    public static void solve() {
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        int[] IDX = new int[1];
        TreeNode root = createTree(arr, IDX);

        String s = serialize(root);
        display(deserialize(s));
    }

    public static void main(String[] args) {
        solve();
    }
}