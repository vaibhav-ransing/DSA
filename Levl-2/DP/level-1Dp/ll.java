public class ll{

    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data, Node left, Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    // Approah:
    static int ans =0;
    static Node consecutiveTrees(Node root){
        if(root==null)
            return null;

        Node left = consecutiveTrees(root.left);
        Node right = consecutiveTrees(root.right);

        boolean check = true;
        if(left!=null){
            // System.out.println("left check "+ left.data+" "+ root.data);
            if( left.data+1 ==  root.data){
                ans++;
            }
        }
        if(right!=null){
            // System.out.println("right check "+ right.data+" "+ root.data);
            if(right.data-1 == root.data){
                ans++;
            }
        }
        return root;
    }

    public static void main(String[] args) {

        Node one = new Node(1, null, null);
        Node three = new Node(3, null, null);
        Node two = new Node(2, one, three);
        consecutiveTrees(two);
        System.out.println(ans);
    }
}