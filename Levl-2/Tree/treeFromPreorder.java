import java.util.Stack;

public class treeFromPreorder {
    
    static class pair{
        TreeNode node;
        int state=0;
        int depth;
        pair(TreeNode node, int state, int depth){
            this.node = node;
            this.state = state;
            this.depth = depth;
        }
    }
    public static  TreeNode recoverFromPreorder(String s) {
        // "1-2--3--4-5--6--7"
        Stack<pair> stack = new Stack<>();
        char c0 = s.charAt(0);
        TreeNode ans = new TreeNode(Integer.parseInt(c0+""));
        stack.push(new pair(ans, 0,0));
        int i=1;
        while(stack.size()>0){
            pair peek = stack.peek();
            int cd=0;
            int j=i;
            while(j<s.length() && s.charAt(j)=='-'){
                j++;
                cd++;
            }
            // System.out.println(j+" "+" ,cd=" + cd+" "+s.charAt(j)+" "+ " ,pd= "+peek.depth);
            if(peek.depth+1==cd){
                TreeNode n = new TreeNode(Integer.parseInt(s.charAt(j)+""));
                i=j+1;
                if(peek.state==0){
                    // System.out.println("inside "+peek.node.val+" "+ n.val+" "+i+" "+j);
                    peek.node.left = n;
                    stack.push(new pair(n, 0, cd));
                    peek.state++;
                }else if(peek.state==1){
                    // System.out.println("inside "+peek.node.val+" "+ n.val+" "+i+" "+j);
                    peek.node.right = n;
                    stack.push(new pair(n, 0, cd));
                    peek.state++;
                }else{
                    stack.pop();
                }
            }else{
                stack.pop();
            }
            // System.out.println(i);
            // System.out.println("------------");
        }   
        return ans;

    }

    public static void main(String[] args) {
        recoverFromPreorder("1-2--3--4-5--6--7");
    }
}
