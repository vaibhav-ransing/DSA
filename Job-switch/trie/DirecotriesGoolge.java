import java.util.*;

public class DirecotriesGoolge {

    static class Node {
        HashMap<String, Node> map;
        int count;
        String prefix;

        Node() {
            this.map = new HashMap<>();
            this.count = 0;
        }

        Node(String prefix) {
            this.map = new HashMap<>();
            this.count = 0;
            this.prefix = prefix;
        }
    }

    static class Trie {
        Node root;

        Trie() {
            this.root = new Node("");
        }

        void insert(String str) {
            Node temp = root;
            // "" a a b
            String[] childs = str.split("/");
            String nextPrefix = "";
            for (String child : childs) {
                if (temp.map.containsKey(child) == false) {
                    temp.map.put(child, new Node(nextPrefix));
                }
                nextPrefix += child;
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

    // class Node {

    // HashMap<String, Node> map;
    // int count;

    // Node() {
    // map = new HashMap<>();
    // this.count = 0;
    // }
    // }

    // class Trie {
    // Node root;

    // Trie() {
    // root = new Node();
    // }

    // void insert(String s) {
    // String[] arr = s.split("/");
    // Node temp = root;
    // for (String str : arr) {
    // if (!temp.map.containsKey(str)) {
    // temp.map.put(str, new Node());
    // }
    // temp = temp.map.get(str);
    // temp.count++;
    // }
    // temp.count++;
    // }

    // void delete(String s) {
    // String[] arr = s.split("/");
    // Node temp = root;
    // for (String str : arr) {
    // if (!temp.map.containsKey(str)) {
    // return;
    // }
    // temp = temp.map.get(str);
    // temp.count--;
    // }
    // temp.count--;
    // }
    // }

}
