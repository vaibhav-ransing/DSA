package Impl;

public class Implementaiton {

    static class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;

        public TrieNode() {
            children = new TrieNode[26];
            isEndOfWord = false;
        }
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

    public static void main(String[] args) {
        Trie root = new Trie();
        root.insert("abc");
        root.insert("vaibhav");
        System.out.println(root.search("abc"));
    }
}