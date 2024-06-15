package String;
public class NumberOfDIstinctSubstring {

    public static int countDistinctSubstrings(String s) {
        Trie trie = new Trie();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                trie.insert(s.substring(i, j + 1));
            }
        }
        return trie.distinct() + 1;
    }

    static class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = root;

            for (char ch : word.toCharArray()) {
                if (node.children[ch - 'a'] == null)
                    node.children[ch - 'a'] = new TrieNode();

                node = node.children[ch - 'a'];
            }
            node.isEndOfWord = true;

        }

        public boolean search(String word) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                if (node.children[ch - 'a'] != null) {
                    node = node.children[ch - 'a'];
                } else {
                    return false;
                }
            }
            return node.isEndOfWord;

        }

        public int distinct() {
            TrieNode node = root;
            return dfs(node);
        }

        public int dfs(TrieNode node) {
            if (node == null)
                return 0;
            int count = node.isEndOfWord ? 1 : 0;
            for (TrieNode chil : node.children) {
                count += dfs(chil);
            }
            return count;
        }

        public boolean startsWith(String word) {

            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                if (node.children[ch - 'a'] != null) {
                    node = node.children[ch - 'a'];
                } else {
                    return false;
                }
            }
            return true;

        }
    }

    static class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;

        public TrieNode() {
            children = new TrieNode[26];
            isEndOfWord = false;
        }
    }

}
