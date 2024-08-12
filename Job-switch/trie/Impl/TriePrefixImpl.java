package Impl;

public class TriePrefixImpl {

    // public static int countDistinctSubstrings(String str){
    // Trie trie = new Trie();

    // }

    class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = root;

            for (char ch : word.toCharArray()) {
                if (node.children[ch - 'a'] == null)
                    node.children[ch - 'a'] = new TrieNode();

                node.prefixCount++;
                node = node.children[ch - 'a'];

            }
            node.countWord++;

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
            return node.countWord > 0;

        }

        public boolean startsWith(String prefix) {

            TrieNode node = root;
            for (char ch : prefix.toCharArray()) {
                if (node.children[ch - 'a'] != null) {
                    node = node.children[ch - 'a'];
                } else {
                    return false;
                }
            }
            return true;

        }
    }

    class TrieNode {
        TrieNode[] children;
        int countWord;
        int prefixCount;

        public TrieNode() {
            children = new TrieNode[26];
            this.countWord = 0;
            this.prefixCount = 1;
        }
    }
}