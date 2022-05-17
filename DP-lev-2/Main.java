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

    static void answer(TreeNode root){
        HashMap<Integer, String> map = new HashMap<>();
        int height = solution(root, 0, map);
        for(int i=0; i<height; i++){
            System.out.println(map.get(i));
        }
    }

    static int solution(TreeNode node, int level, HashMap<Integer, String> map){
        if(node==null)
            return 0;
        
        if(map.containsKey(level)==false){
            map.put(level, node.val+"");
        }
        int left = solution(node.left, level+1, map);
        int right = solution(node.right, level+1, map);
        int h = Math.max(left, right);
        return h+1;
    }

    // input_section=================================================

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
        answer(root);
    }

    public static void main(String[] args) {
        // solve();
        ArrayList<Integer> al = new ArrayList<>();
    }
}