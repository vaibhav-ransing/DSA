package ShortestPathQuestion;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.IntStream;

public class WorLadder2 {

    class Pair {
        String word;
        int dist;
        ArrayList<String> list;

        Pair(String word, int dist, ArrayList<String> list) {
            this.word = word;
            this.dist = dist;
            this.list = list;
        }
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        HashSet<String> visited = new HashSet<>();
        List<List<String>> ans = new ArrayList<>();

        ArrayDeque<Pair> queue = new ArrayDeque<>();

        ArrayList<String> temp = new ArrayList<>();
        temp.add(beginWord);
        queue.add(new Pair(beginWord, 1, temp));

        int maxDist = Integer.MAX_VALUE;

        while (queue.size() > 0) {
            Pair peek = queue.remove();
            ArrayList<String> curr_list = peek.list;

            if (visited.contains(peek.word))
                continue;
            if (peek.word.equals(endWord)) {
                if (peek.dist <= maxDist) {
                    ans.add(curr_list);
                    maxDist = Math.min(maxDist, peek.dist);
                }
                continue;
            }

            for (String nbr : wordList) {
                if (hasEdge(peek.word, nbr)) {
                    ArrayList<String> new_list = new ArrayList<>();
                    IntStream.range(0, curr_list.size()).forEach(i -> new_list.add(curr_list.get(i)));
                    new_list.add(nbr);
                    queue.add(new Pair(nbr, peek.dist + 1, new_list));
                }
            }
            visited.add(peek.word);
        }
        return ans;
    }

    public boolean hasEdge(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i))
                diff++;
        }
        return diff == 1;
    }
}
