package Questions;

public class ChildrenSumProperty {

    public static void changeTree(BinaryTreeNode<Integer> root) {
        // Write your code here.
        getLeftRight(root);
    }

    public static int getLeftRight(BinaryTreeNode<Integer> node) {

        if (node == null)
            return 0;

        // return the leaf value
        if (node.left == null && node.right == null)
            return node.data;

        int left = getLeftRight(node.left);
        int right = getLeftRight(node.right);

        int diff =  (left + right) - node.data;

        System.out.println("Node= "+node.data +" "+ left + " "+ right +" diff="+diff);

        // -ve diff means currNode.val is greater than sum of left and right
        // so we need to add that difference in left of right till the root node to balance it out
        if (diff < 0) {
            if(node.left != null){
                addValueToNodes(node.left, Math.abs(diff));
            }else{
                addValueToNodes(node.right, Math.abs(diff));
            }
        }
        // +ve diff means left and right is greater sum than currNode.val so we increase currNode.val by the difference 
        else {
            node.data += diff;
        }

        System.out.println("NodeUpdate= "+ node.data);
        return node.data ;

    }

    public static void addValueToNodes(BinaryTreeNode<Integer> node, int absoluteDiff) {

        if (node == null)
            return;

        int pn = node.data; // for logs 
        node.data += absoluteDiff;
        // we only need one path to be updated so either left or right
        if (node.left != null) {
            addValueToNodes(node.left, absoluteDiff);
        } else {
            addValueToNodes(node.right, absoluteDiff);
        }
        System.out.println("pre="+pn + "NodeUpdating="+ node.data);
    }

}

class BinaryTreeNode<Integer> {
    int data;
    BinaryTreeNode<Integer> left;
    BinaryTreeNode<Integer> right;

    public BinaryTreeNode(int data) {
        this.data = data;
    }
}
