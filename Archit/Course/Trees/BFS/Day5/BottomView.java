import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class BottomView {
    
    class Node{
        int data;
        int hd;
        Node left, right;
    }
    int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    public ArrayList <Integer> bottomView(Node root){
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        dfs(root, 0, map);
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=min; i<=max; i++){
            ArrayList<Integer> temp = map.get(i);
            ans.add(temp.get(temp.size()-1));
        }
        return ans;
    }
    public void dfs(Node node, int vert, HashMap<Integer, ArrayList<Integer>> map ){
        if(node==null)
            return;
        if(!map.containsKey(vert)){
            map.put(vert, new ArrayList<Integer>());
        }
        min = Math.min(min, vert);
        max = Math.max(max, vert);

        map.get(vert).add(node.data);
        dfs(node.left, vert-1, map);
        dfs(node.right, vert+1, map);
    }

    public class pair{
        int vertLevel;
        Node root;
        pair(int vertLevel, Node root){
            this.vertLevel = vertLevel;
            this.root = root;
        }
    }
    public ArrayList <Integer> bottomView2(Node node){
        TreeMap<Integer, Integer> map = new TreeMap<>();
        ArrayDeque<pair> queue = new ArrayDeque<>();
        queue.add(new pair(0, node));
        while(queue.size()>0){
            pair p = queue.remove();
            if(!map.containsKey(p.vertLevel))
                map.put(p.vertLevel, p.root.data);

            if(p.root.left!=null) queue.add(new pair(p.vertLevel-1, p.root.left));
            if(p.root.right!=null) queue.add(new pair(p.vertLevel+1, p.root.right));
            
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(int vl: map.keySet()){
            ans.add(map.get(vl));
        }
        return ans;
    }

}
