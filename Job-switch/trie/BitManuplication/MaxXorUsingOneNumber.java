package BitManuplication;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxXorUsingOneNumber {
    static class Node {
        Node[] child;
        boolean isEndOfWord;
        int num;

        Node() {
            this.child = new Node[2];
            this.isEndOfWord = false;
            this.num = -1;
        }
    }

    static class Trie {
        Node root;

        Trie() {
            this.root = new Node();
        }

        void insert(String str, int num) {
            Node node = root;
            for (char ch : str.toCharArray()) {
                if (ch == '0') {
                    if (node.child[0] == null)
                        node.child[0] = new Node();
                } else {
                    if (node.child[1] == null)
                        node.child[1] = new Node();
                }
                node = node.child[ch == '0' ? 0 : 1];
            }
            node.num = num;
        }

        int traverseOpposite(String str) {
            Node node = root;
            for (char ch : str.toCharArray()) {
                if (ch == '0' && node.child[1] != null) {
                    node = node.child[1];
                } else if (ch == '1' && node.child[0] != null) {
                    node = node.child[0];
                } else {
                    node = node.child[0] != null ? node.child[0] : node.child[1];
                }
            }
            return node.num;
        }
    }

    public static int maxXorVal(int arr[], int x) {
        Trie trie = new Trie();
        for (int val : arr) {
            String binaryStringWithZeros = String.format("%32s", Integer.toBinaryString(val)).replace(' ', '0');
            trie.insert(binaryStringWithZeros, val);
        }

        String binaryStringWithZeros = String.format("%32s", Integer.toBinaryString(x)).replace(' ', '0');

        // System.out.println();
        return trie.traverseOpposite(binaryStringWithZeros);
    }

    public static int maxXOR(int n, int m, ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
        Trie trie = new Trie();
        for (int val : arr1) {
            String binaryStringWithZeros = String.format("%32s", Integer.toBinaryString(val)).replace(' ', '0');
            trie.insert(binaryStringWithZeros, val);
        }
        int max = 0;
        for( int val : arr2){
            String binaryStringWithZeros = String.format("%32s", Integer.toBinaryString(val)).replace(' ', '0');
            System.out.println(val + " | "+ trie.traverseOpposite(binaryStringWithZeros));
            max = Math.max(max, trie.traverseOpposite(binaryStringWithZeros));
        }
        return max;
    }

    public static void main(String[] args) {


        ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(6, 6, 0, 6, 8, 5, 6));
        ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList(1, 7, 1, 7, 8, 0, 2));

        System.out.println(maxXOR(0, 0, arr1, arr2));

        // int arr[] = { 0, 1, 2, 3, 6, 8, 9 };
        // for (int val : arr) {
        //     System.out.print(val + "= " + (val ^ 5) + " | ");
        // }
        // System.out.println();
        // maxXorVal(arr, 5);

        // Trie trie = new Trie();
        // int[] arr = { 4, 5, 6, 7 };
        // for (int val : arr) {
        // trie.insert(Integer.toBinaryString(val), val);
        // }
        // System.out.println(trie.traverseOpposite(Integer.toBinaryString(4)));
    }
}
