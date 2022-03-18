import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Microsoft {
    
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
        int min;
        int max;
        boolean ans = true;
        pair(int min, int max){
            this.min = min;
            this.max = max;
        }
    }

    static pair isBST(Node node){
        if(node==null){
            return new pair(Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        pair left = isBST(node.left);
        pair right = isBST(node.right);
        
        
        int min = Math.min(node.data, Math.min(left.min, right.min));

        int max = Math.max(node.data, Math.max(left.max, right.max));
        pair rp = new pair(min, max);


        rp.ans = left.ans && right.ans &&
                 (node.data>=left.max && node.data<=right.min);
        if(rp.ans==false){
            System.out.println(node.data +" "+min+" "+max);
        }
        rp.max = max;
        rp.min = min;
        return rp;
    }


    static void removeDuplicated(String str){
        // System.out.println( (char)('A'+32));  a
        // System.out.println( (char)('a'-32));  A 
        HashSet<Character> set = new HashSet<>();
        StringBuilder ans = new StringBuilder();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(set.contains(ch) || set.contains( (char)(ch-32)) 
                                || set.contains((char)(ch+32))){
                continue;
            }else{
                ans.append(ch);
                set.add(ch);
            }
        }
        System.out.println(ans.toString());
    }

    static int longestLenUniqueChar(List<String> arr, int index, String s){
        
        if(!isUnique(s.toString()))      
            return 0;
        int ans = s.length();
        if(index==arr.size())
            return ans;
        int a = longestLenUniqueChar(arr, index+1, s+arr.get(index));
        int b = longestLenUniqueChar(arr, index+1, s);
        return Math.max(a, b);
    }
    static boolean isUnique(String s){
        HashSet<Character> set = new HashSet<>();
        for(int i=0;i<s.length();i++){
            if(set.contains(s.charAt(i)))
                return false;
            set.add(s.charAt(i));
        }
        return true;
    }


    public static void main(String[] args) {
        Node lb = new Node(10, null, null);
        Node rb = new Node(25, null, null);
        Node tw = new Node(20, lb, rb);
        Node ft = new Node(40, null, null);
        Node root = new Node(30, tw, ft);
        pair p = isBST(root);

        // removeDuplicated("HappyNewYear");
        List<String> arr = new ArrayList<>();
        // {"cha", "r", "act", "ers"};
        // String arr[] = 
        int ans = 0;
        for(int i=0;i<arr.size();i++){
            ans = Math.max(longestLenUniqueChar(arr, 0, arr.get(i)), ans);
        }
        
        System.out.println(ans);
        // HapyNewr
        // HapyNewr
    }
}
