package Trie.Day1;

public class lc211 {

    class WordDictionary {

        class Node {
            boolean eno;
            Node arr[] = new Node[26];
        }

        Node root;

        public WordDictionary() {
            root = new Node();
        }

        public void addWord(String word) {
            Node node = root;
            for (char ch : word.toCharArray()) {
                if (node.arr[ch - 'a'] == null) {
                    node.arr[ch - 'a'] = new Node();
                }
                node = node.arr[ch - 'a'];
            }
            node.eno = true;
        }

        public boolean search(String word) {

            Node node = root;
            return helper(word, node);

        }

        public boolean helper(String word, Node node) {
           
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (ch == '.') {
                    for (Node n : node.arr) {
                        if (n != null) {
                            boolean remWord = helper(word.substring(i + 1, word.length()),n);
                            if (remWord) {
                                return true;
                            }
                        }
                    }
                } else {
                    if (node.arr[ch - 'a'] == null) {
                        return false;
                    }
                    node = node.arr[ch - 'a'];
                }

            }
            return node.eno;
        }
    }

    public static void main(String[] args) {

    }
}
