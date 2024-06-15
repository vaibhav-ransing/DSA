package Impl;
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

class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;

    public TrieNode() {
        children = new TrieNode[26];
        isEndOfWord = false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */