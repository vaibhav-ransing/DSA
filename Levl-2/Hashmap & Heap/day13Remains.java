import java.util.Collections;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;

public class day13Remains {
    
    static class pair implements Comparable<pair>{
        char ch;
        int freq;
        pair(char ch, int freq){
            this.ch=ch;
            this.freq = freq;
        }
        public int compareTo(pair o){
            return this.freq - o.freq;
        }
    }
    static void reArangeString(String s){
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        PriorityQueue<pair> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(char key: map.keySet()){
            pair p = new pair(key, map.get(key));
            pq.add(p);
        }
        StringBuilder ans = new StringBuilder();
        pair prev = null;
        while(pq.size()>0){
            pair peek = pq.remove();
            ans.append(peek.ch);
            peek.freq--;
            if(prev!=null && prev.freq>0){
                pq.add(prev);
            }
            prev = peek;
        }
        ans= ans.length()==s.length()? ans: new StringBuilder();
        System.out.println(ans.toString());

    }

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
    static int ceilOfTree(Node node, int data, int ceil){
        if(node==null)
            return ceil;
        if(node.data>=data && ceil>node.data){
            ceil = node.data;
        }
        if(data>node.data){
            ceil = Math.min(ceil, ceilOfTree(node.right, data, ceil));
        }else
            ceil = Math.min(ceil, ceilOfTree(node.left, data, ceil));
        return ceil;
    }
    static void addNode(Node node, int data){

        if(data<node.data){
            if(node.left==null){
                node.left = new Node(data, null, null);
                return;
            }
            addNode(node.left, data);
        }
        else{
            if(node.right==null){
                node.right = new Node(data, null, null);
                return;
            }
            addNode(node.right, data);
        }
    }


    public static void main(String[] args) {
        Node l11 = new Node(5, null, null);
        Node r11 = new Node(15, null, null);
        Node l1 = new Node(10,l11,r11);
        Node r1 = new Node(30,null,null);
        Node root = new Node(20, l1, r1);
    }

}
