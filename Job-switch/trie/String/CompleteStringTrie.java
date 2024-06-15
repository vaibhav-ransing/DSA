package String;
public class CompleteStringTrie {

    public static String completeString(int n, String[] a) {

        Trie trie = new Trie();
        for (String str : a) {
            trie.insert(str);
        }
        String ans = "";
        for (String str : a) {
            if (trie.allSubStringPresent(str)) {
                if (ans.length() < str.length()) {
                    ans = str;
                }else if( ans.length() == str.length() && str.compareTo(ans) < 0){  // str < ans
                    ans = str;
                }
            }
        }
        return ans == "" ? "None" : ans;
    }

    static class TrieNode {
        TrieNode[] children;
        int count;

        TrieNode() {
            this.children = new TrieNode[26];
            this.count = 0;
        }
    }

    static class Trie {
        TrieNode root;

        Trie() {
            this.root = new TrieNode();
        }

        void insert(String word) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                if (node.children[ch - 'a'] == null)
                    node.children[ch - 'a'] = new TrieNode();
                node = node.children[ch - 'a'];
            }
            node.count++;
        }

        public boolean allSubStringPresent(String str) {
            TrieNode node = root;
            for (char ch : str.toCharArray()) {
                // we need to chek node.children[ch - 'a'].count and not node.cout 
                // because when we are adding "a" then we create a new node at 'a' and then add new node into it and in the end we increment count.
                if (node.children[ch - 'a'] == null || node.children[ch - 'a'].count <= 0) {
                    return false;
                }
                node = node.children[ch - 'a'];
            }
            return true;
        }
    }

    public static void main(String[] args) {
        String a[] = { "a", "ab", "abc", "dd" };
        System.out.println(completeString(0, a));
    }
}
