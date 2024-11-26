package AALastGo.Trie;

import java.util.*;

public class GglTrie {

    static class Node {
        HashMap<String, Node> map;
        int count;

        Node() {
            this.map = new HashMap<>();
            this.count = 0;
        }
    }

    static class Trie {
        Node root;

        Trie() {
            this.root = new Node();
        }

        void insert(String str) {
            Node temp = root;
            String[] childs = str.split("/");
            for (String child : childs) {
                if (temp.map.containsKey(child) == false) {
                    temp.map.put(child, new Node());
                }
                temp.count++;
                temp = temp.map.get(child);
            }
            temp.count++;
        }

        void remove(String str) {
            Node temp = root;
            String[] childs = str.split("/");
            for (String child : childs) {

                temp.count--;
                // if (temp.map.get(child) != null)
                temp = temp.map.get(child);
            }
            temp.count--;
        }
    }

    static List<String> ans;

    static void helper(Node node, String dir) {
        if (node.count == 0) {
            ans.add(dir);
            return;
        }
        for (String child : node.map.keySet()) {
            helper(node.map.get(child), dir + "/" + child);
        }
    }

    public static void main(String[] args) {
        System.out.println();
        String[] dirs = { "/a/b/x.txt", "/a/b/p.txt", "/a/c", "/a/d/y.txt", "/a/d/z.txt" };
        String[] selectedDirs = { "/a/d/y.txt", "/a/d/z.txt", "/a/b/p.txt" };
        Trie trie = new Trie();
        for (String dir : dirs) {
            trie.insert(dir);
        }
        for (String rm : selectedDirs) {
            trie.remove(rm);
        }
        ans = new ArrayList<>();
        helper(trie.root, "");
        System.out.println();
        System.out.println(ans);
    }
}