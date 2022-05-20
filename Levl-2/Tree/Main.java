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

      static void inorderTraversal(TreeNode node){

        TreeNode temp = node;
        while(temp!=null){

            if(temp.left!=null){
                TreeNode iop = temp.left;
                while(iop.right !=null && iop.right!=temp){
                    iop = iop.right;
                }
                
                if(iop.right==null){
                    System.out.println(temp.val);
                    iop.right=temp;
                    temp = temp.left;
                }else{
                    iop.right = null;
                    // System.out.print(temp.val+" ");
                    temp = temp.right;
                }
            }else{
                System.out.print(temp.val+" ");
                temp = temp.right;
            }
        }
    }


  public static TreeNode createTree(int[] arr, int[] IDX) {
    if (IDX[0] > arr.length || arr[IDX[0]] == -1) {
      IDX[0]++;
      return null;
    }
    TreeNode Treenode = new TreeNode(arr[IDX[0]++]);
    Treenode.left = createTree(arr, IDX);
    Treenode.right = createTree(arr, IDX);

    return Treenode;
  }

  public static void solve() {
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++)
      arr[i] = scn.nextInt();

    int[] IDX = new int[1];
    TreeNode root = createTree(arr, IDX);
    inorderTraversal(root);

  }

  public static void main(String[] args) {
    solve();
  }
}