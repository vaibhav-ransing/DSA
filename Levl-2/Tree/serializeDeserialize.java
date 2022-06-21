import java.util.Stack;


public class serializeDeserialize {
    
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){this.val = val;}
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    
    public static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        helperSerialize(root, sb);
        return sb.toString();
    }

    public static void helperSerialize(TreeNode node, StringBuilder sb){
        if(node==null){
            sb.append("null,");
        }
        sb.append(node.val+",");
        helperSerialize(node.left, sb);
        helperSerialize(node.right, sb);
    }

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
        TreeNode node = new TreeNode();

        if(arr.length==0 || arr[0]==null)
            return null;

        stack.push(new pair(new TreeNode(Integer.parseInt(arr[0])), 0));
        int i=1;
        while(stack.size()>0){
            pair peek = stack.peek();

            if(peek.state==0){
                if(arr[i]!="null"){
                    TreeNode left = new TreeNode(Integer.parseInt(arr[i]));
                    stack.push(new pair(left, 0));
                    peek.node.left = left;
                }
                peek.state++;
                i++;
            }else if(peek.state==1){
                if(arr[i]!="null"){
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

    static void peint(TreeNode node){
        if(node==null) return;
        System.out.println(node.val);
        peint(node.left);
        peint(node.right);
    }

    public static void main(String[] args) {
        String s = "8,3,1,null,null,6,null,null,10,null,null";
        TreeNode t = deserialize(s);
    }
}
