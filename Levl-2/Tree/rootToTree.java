
public class rootToTree {
    
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

    // root to leaf max sum
    static int rootToNodeMaxSum(Node root){
        if(root==null)
            return Integer.MIN_VALUE;
        
        int left = rootToNodeMaxSum(root.left);
        int right = rootToNodeMaxSum(root.right);
        boolean temp = left==Integer.MIN_VALUE && right==Integer.MIN_VALUE;
        return root.data + ((temp==true)? 0: Math.max(left, right));
    }

    // root to leaf max sum and path
    static class pair{
        int val;
        String asf;
        pair(int val, String asf){
            this.val = val;
            this.asf = asf;
        }
    }
    static void NodeToLeafPath(Node root){
        
        pair p = NLP_Path(root);
        System.out.println(p.val+" "+p.asf);
    }
    static pair NLP_Path(Node node){
        if(node==null){
            return new pair(Integer.MIN_VALUE, "");
        }

        pair left = NLP_Path(node.left);
        pair right = NLP_Path(node.right);
        boolean temp = left.val==Integer.MIN_VALUE && right.val==Integer.MIN_VALUE;
        if(temp){
            return new pair(node.data, node.data+"");
        }else if(left.val==Integer.MIN_VALUE){
            return new pair(right.val+node.data, node.data+" "+ right.asf);
        }else{
            boolean lg = left.val > right.val;
            return new pair(node.data+ (lg?left.val:right.val) , node.data+" "+(lg?left.asf:right.asf));
        }
    }

    // root to Node path 
    static void NodeToNode(Node root){
        pair p = rootToNodeHelper(root);
        System.out.println(p.val+" "+p.asf);
    }
    static pair rootToNodeHelper(Node node){
        if(node==null){
            return new pair(Integer.MIN_VALUE, "");
        }

        pair left = rootToNodeHelper(node.left);
        pair right = rootToNodeHelper(node.right);
        boolean temp = left.val==Integer.MIN_VALUE && right.val==Integer.MIN_VALUE;
        if(temp || left.val<0 && right.val<0){
            return new pair(node.data, node.data+"");
        }else{
            boolean lg = left.val > right.val;
            return new pair(node.data+ (lg?left.val:right.val) , node.data+" "+(lg?left.asf:right.asf));
        }
    }


    // Node to Node max sum
    static int sum =0;
    static int ntnHelper(Node node){
        if(node==null)  
            return Integer.MIN_VALUE;
        
        int left = ntnHelper(node.left);
        int right = ntnHelper(node.right);
        boolean temp = left==Integer.MIN_VALUE && right==Integer.MIN_VALUE;
        int total = node.data + ((temp==true)? 0: Math.max(left, right));
        sum = Math.max(total, Math.max(left, right));
        return total;
    }


    public static void main(String[] args) {
        Node lr = new Node(2, null, null);
        Node r = new Node(-20, null, null);
        Node l = new Node(5, null, lr);

        Node root = new Node(-10, l, r);
        System.out.println(ntnHelper(root));
        System.out.println(sum);
        // pair p = rootToNodeHelper(root);
        // System.out.println(p.val+" "+p.asf);
    }
}
