package GoogleQuestion;

import java.util.stream.IntStream;

public class LongestCommonSufixQueries {

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {

        // Set the index of root node with lowest lenght string index in wordsContainer
        int minIndex = IntStream.range(0, wordsContainer.length)
                .boxed()
                .min((i, j) -> Integer.compare(wordsContainer[i].length(), wordsContainer[j].length()))
                .orElse(-1); // Return -1 if the array is empty

        Trie trie = new Trie(minIndex);
        for (int i = 0; i < wordsContainer.length; i++) {
            String str = wordsContainer[i];
            trie.add(str, i, wordsContainer);
        }
        int[] ans = new int[wordsQuery.length];
        int i = 0;
        for (String s : wordsQuery) {
            ans[i++] = trie.fetchSufix(s);
        }
        return ans;
    }

    class Node {
        Node[] arr;
        int idx;

        Node() {
            this.arr = new Node[26];
        }
    }

    class Trie {
        Node head;

        Trie(int minIndex) {
            this.head = new Node();
            this.head.idx = minIndex;
        }

        void add(String str, int idx_curr, String[] parentArr) {
            Node temp = head;
            StringBuilder sb = new StringBuilder(str);
            str = sb.reverse().toString();

            for (char ch : str.toCharArray()) {
                if (temp.arr[ch - 'a'] == null) {
                    temp.arr[ch - 'a'] = new Node();
                    temp.arr[ch - 'a'].idx = idx_curr;
                }
                temp = temp.arr[ch - 'a'];
                // update the index if the curr string is smaller than older string index
                if (parentArr[temp.idx].length() > parentArr[idx_curr].length()) {
                    temp.idx = idx_curr;
                }
            }
        }

        int fetchSufix(String str) {
            Node temp = head;
            StringBuilder sb = new StringBuilder(str);
            str = sb.reverse().toString();

            for (char ch : str.toCharArray()) {
                
                // go down untill we keep finding the nodes
                if (temp.arr[ch - 'a'] == null)
                    return temp.idx;
                temp = temp.arr[ch - 'a'];
            }
            return temp.idx;
        }

    }
}
