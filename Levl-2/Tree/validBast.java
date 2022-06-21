
public class validBast {
    
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

    static class pair{
        boolean ans = true;
        int min;
        int max;
        pair(int min, int max){
            this.min = min;
            this.max = max;
        }
    }

    static pair isvalidBST(Node node){
        if(node==null){
            return new pair(Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        pair left = isvalidBST(node.left);
        pair right = isvalidBST(node.right);
        int min = Math.min(left.max, right.max);
        int max = Math.max(right.min, left.min);
        pair np = new pair( Math.min(min, node.data) , Math.max(max, node.data));
        
        np.ans = left.ans && right.ans &&  (min==Integer.MAX_VALUE?true:min<node.data) && 
                                            (max==Integer.MIN_VALUE?true: max>node.data);
        System.out.println(node.data+" "+ min+" "+max+" "+np.ans);
        return np;
    }

    public static void main(String[] args) {
        Node lr = new Node(9, new Node(6, null, null), null);
        Node ll = new Node(2, null, null);
        Node r = new Node(7, null, null);
        Node l = new Node(5, ll, lr);

        Node root = new Node(10, l, r);
        System.out.println(isvalidBST(root).ans);
    }
}
