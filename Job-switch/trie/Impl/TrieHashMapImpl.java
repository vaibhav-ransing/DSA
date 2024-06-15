package Impl;
import java.util.HashMap;

public class TrieHashMapImpl {

    static class TrieNode {
        HashMap<Character, TrieNode> children;
        boolean isEndOfWord;

        TrieNode() {
            this.children = new HashMap<>();
            this.isEndOfWord = false;
        }
    }

    static class Trie {
        TrieNode root;

        Trie() {
            root = new TrieNode();
        }

        void insert(String word) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                if (!node.children.containsKey(ch))
                    node.children.put(ch, new TrieNode());

                node = node.children.get(ch);

            }
            node.isEndOfWord = true;
        }

        boolean search(String word) {

            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                if (node.children.containsKey(ch)) {
                    node = node.children.get(ch);
                } else {
                    return false;
                }
            }
            return node.isEndOfWord;
        }
    }

    public static void main(String[] args) {
        Trie node = new Trie();
        node.insert("abc");
        System.out.println(node.search("abc"));
        System.out.println(node.search("abcd"));
        System.out.println(node.search("ab"));
    }
}
