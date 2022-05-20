import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class verticalView {
    
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

    static class pair implements Comparable<pair> {
        int h;
        int data;
        public int compareTo( pair o){
            return this.h - o.h;
        }
        pair(int data, int h){
            this.data = data;
            this.h =h;
        }
    }

    static int lowestLeft = Integer.MAX_VALUE;
    static void veritcalViews(Node root){
        HashMap<Integer, ArrayList<pair>> map = new HashMap<>();
        helper(root, 0,0, map);
        int v=lowestLeft;
        while(map.containsKey(v)){
            System.out.print(v+" -> ");
            ArrayList<pair> temp = map.get(v);
            Collections.sort(temp);
            for(pair p: temp){
                System.out.print(p.data+" ");
            }
            System.out.println();
            v++;
        }
    }
    static void helper(Node node, int v, int h, HashMap<Integer, ArrayList<pair>> map){
        if(node==null)
            return;
        lowestLeft = Math.min(lowestLeft, v);
        if(map.containsKey(v)){
            ArrayList<pair> al = map.get(v);
            pair p = new pair(node.data, h);
            al.add(p);
        }else{
            ArrayList<pair> al = new ArrayList<>();
            al.add(new pair(node.data, h));
            map.put(v, al);
        }
        helper(node.left, v-1, h+1, map);
        helper(node.right, v+1,h+1, map);
    }


    public static void main(String[] args) {
        Node lr = new Node(7, null, null);
        Node l = new Node(5, null, lr);
        Node r = new Node(20, null, null);

        Node root = new Node(10, l, r);
        veritcalViews(root);

    }
}
