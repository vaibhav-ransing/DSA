import java.util.ArrayList;
import java.util.HashMap;

public class diagonalTraversla {
    

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

    static void solution(Node root){
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        helper(root, 0, map);
        int i=0;
        while(map.containsKey(i)){
            System.out.print(i+" -> ");
            for(int val: map.get(i)){
                System.out.print(val+" ");
            }
            System.out.println();
        }
    }
    static void helper(Node node, int d, HashMap<Integer, ArrayList<Integer>> map){
        if(node==null)
            return;
        if(map.containsKey(d)==false){
            ArrayList<Integer> al = new ArrayList<>();
            al.add(node.data);
            map.put(d, al);
        }else{
            map.get(d).add(node.data);
        }
        helper(node.right, d, map);
        helper(node.left, d+1, map);
    }





    public static void main(String[] args) {
        
    }
}
