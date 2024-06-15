package String;
import java.util.HashSet;

public class CompleteString {

    public static String completeString(int n, String[] a) {
        HashSet<String> set = new HashSet<>();
        for (String val : a) {
            set.add(val);
        }

        String ans = "";
        for (String str : a) {
            boolean possible = true;
            for (int i = 0; i < str.length(); i++) {
                if(set.contains(str.substring(0, i+1)) == false ){
                    possible = false;
                    break;
                }
                if(possible && (str.length() > ans.length()))
                    ans = str;
            }
        }
        return ans == "" ? null : ans;
    }

    class TrieNode {
        TrieNode[] children;
        int count;

        TrieNode() {
            this.children = new TrieNode[26];
            this.count = 0;
        }
    }

    class Trie {
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

        public int countWordsEqualTo(String word) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                if (node.children[ch - 'a'] == null)
                    return 0;
                node = node.children[ch - 'a'];
            }
            return node.count;
        }

        public int countWordsStartingWith(String prefix) {

            TrieNode node = root;
            for (char ch : prefix.toCharArray()) {
                if (node.children[ch - 'a'] != null) {
                    node = node.children[ch - 'a'];
                } else {
                    return 0;
                }
            }
            return dfs(node);
        }

        public int dfs(TrieNode node) {
            int ct = 0;
            for (TrieNode cc : node.children) {
                if (cc != null) {
                    ct += dfs(cc);
                }
            }
            return ct + node.count;
        }

        public void erase(String word) {
            TrieNode node = root;

            for (char ch : word.toCharArray()) {
                if (node.children[ch - 'a'] == null)
                    node.children[ch - 'a'] = new TrieNode();
                node = node.children[ch - 'a'];
            }
            node.count--;

        }
    }
}