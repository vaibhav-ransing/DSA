import javax.swing.RootPaneContainer;

public class binaryTree{


    static class Node{
        int data;
        Node left;
        Node right;
    }

    static void preorderTraversal(Node root){
        System.out.println(root.data);
        if(root.left!=null)
            preorderTraversal(root.left);
        if(root.right!=null)
            preorderTraversal(root.right);
        return;
    }

    static Node construct(int arr[]){
        Node root = new Node();


        return root;
    }

    public static void main(String[] args) {
        Node root = new Node();
        root.data = 20;
        Node lNode = new Node();
        Node rNode = new Node();
        root.left = lNode;
        root.right = rNode;
        lNode.data=10;
        rNode.data = 30;

        int arr[] = {20,10,-1,30,-1,-1};
        preorderTraversal(root);

    }
}