import java.util.*;

public class VerticalTraversal {
    
    class Node{
        int data;
        int hd;
        Node left, right;
    }
    public static class pair{
        int vertLevel;
        Node root;
        pair(int vertLevel, Node root){
            this.vertLevel = vertLevel;
            this.root = root;
        }
    }
    static ArrayList <Integer> verticalOrder(Node root)
    {
        // add your code here
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        ArrayDeque<pair> queue = new ArrayDeque<>();
        queue.add(new pair(0, root));
        while(queue.size()>0){
            pair p = queue.remove();

            map.putIfAbsent(p.vertLevel, new ArrayList<>());
            map.get(p.vertLevel).add(p.root.data);

            if(p.root.left!=null) queue.add(new pair(p.vertLevel-1, p.root.left));
            if(p.root.right!=null) queue.add(new pair(p.vertLevel+1, p.root.right));
            
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(int vl: map.keySet()){
            for(int val: map.get(vl)){
                ans.add(val);
            }
        }
        return ans;
    }

}
