import java.util.HashMap;

public class buildTreepreInorder {
    

    static class Node{
        int data;
        Node left;
        Node right;
    }

    static Node solution(int[] pre, int[] ino, int preStart, int preEnd, int inoStart, int inoEnd){
        // System.out.println(preStart+" "+preEnd+" "+ inoStart+" "+inoEnd);
        if(preStart > preEnd || inoStart> inoEnd)
            return null;

        Node n = new Node();
        n.data = pre[preStart];
        for(int i=inoStart; i<=inoEnd; i++){
            if(pre[preStart] == ino[i]){
                // System.out.println("-> "+ino[i]+" "+ pre[i]+" "+ i);
                n.left = solution(pre, ino, preStart+1,  i, inoStart, i-1);
                n.right = solution(pre, ino, i+1, preEnd, i+1, inoEnd);

            }
        }

        return n;
    }

    static Node postOrderTree(int[] post, int[] ino){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<ino.length; i++){
            map.put(ino[i], i);
        }
        return helper(post, ino, 0, post.length-1, 0, ino.length-1, map);
    }
    static Node helper(int[] post, int ino[], int postStart, int postEnd, int inoStart, int inoEnd, HashMap<Integer, Integer> map){
        if(postStart > postEnd || inoStart > inoEnd)
            return null;
        int val = post[postEnd];
        Node n = new Node();
        n.data = val;
        n.left = helper(post, ino, postStart, postEnd-map.get(val)-1, inoStart, map.get(val)-1, map);
        n.right = helper(post, ino, postEnd-map.get(val), postEnd-1, map.get(val)+1, inoEnd, map);
        return n;
    }

    static void display(Node n){
        if(n==null)
            return;
        System.out.println(n.data);
        display(n.left);
        display(n.right);
    }


    public static void main(String[] args) {
        int pre[] = {1,2,3,4,5,6,7};
        int ino[] = {3,2,4,1,6,7,5};    
        Node n = solution(pre, ino, 0, pre.length-1, 0, ino.length-1);
        // int [] post = {3,4,2,7,6,5,1};
        // Node n = postOrderTree(post, ino);
        display(n);
    }
}
