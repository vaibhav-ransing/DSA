package ZRandom;

import java.util.HashMap;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        Trie trie = new Trie();
        for (String str : strs) {
            trie.add(str);
        }
        int totalStrs = strs.length;
        return trie.maxPrefix(totalStrs);
    }

    class Node {
        HashMap<Character, Node> map;
        int prefixCount;

        Node() {
            map = new HashMap<>();
            prefixCount = 0;
        }
    }

    class Trie {

        Node head;

        Trie() {
            head = new Node();
        }

        void add(String str) {
            Node temp = head;
            for (char ch : str.toCharArray()) {
                if (!temp.map.containsKey(ch))
                    temp.map.put(ch, new Node());
                temp.prefixCount++;
                temp = temp.map.get(ch);
            }
        }

        String maxPrefix(int totalStrs) {
            Node temp = head;
            String ans = "";
            while (temp.map.size() == 1 && temp.prefixCount == totalStrs) {

                for (Character key : temp.map.keySet()) {
                    ans += key;
                    temp = temp.map.get(key);
                }
            }
            return ans;
        }
    }

}
