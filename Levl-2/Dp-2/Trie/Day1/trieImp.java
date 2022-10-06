package Trie.Day1;

public class trieImp {
    

    class Trie {

        class Node{
            boolean eno;
            Node arr[] = new Node[26];
        }
        Node root;
        public Trie() {
            root = new Node();            
        }
        
        public void insert(String word) {
            Node node = root;
            for(char ch: word.toCharArray()){
                if(node.arr[ch-'a']==null){
                    node.arr[ch-'a'] = new Node();
                }
                node = node.arr[ch-'a'];
            }
            node.eno = true;
        }
        
        public boolean search(String word) {
            Node node = root;
            for(char ch: word.toCharArray()){
                if(node.arr[ch-'a']==null){
                   return false;
                }
                node = node.arr[ch-'a'];
            }
            return node.eno;
        }
        
        public boolean startsWith(String prefix) {
            Node node = root;
            for(char ch: prefix.toCharArray()){
                if(node.arr[ch-'a']==null){
                   return false;
                }
                node = node.arr[ch-'a'];
            }
            return true;
        }
    }

}
