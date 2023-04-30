package Course.Graph.Day10_ShortestPath_BFS.Questions;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;

public class Lc127_word_ladder {

    class Pair {
        int dist;
        String str;

        Pair(String str, int dist) {
            this.str = str;
            this.dist = dist;
        }
    }

    public boolean hasEdge(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i))
                diff++;
        }
        return diff == 1;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(beginWord, 1));
        HashMap<String, Boolean> map = new HashMap<>();

        while (queue.size() > 0) {
            Pair peek = queue.remove();

            if (peek.str.equals(endWord) || peek.str == endWord)
                return peek.dist;
            if (map.containsKey(peek.str))
                continue;

            map.put(peek.str, true);

            for (String nbr : wordList) {
                if(hasEdge(nbr, peek.str)){
                    queue.add(new Pair(nbr, peek.dist+1));
                }
            }
        }

        return 0;
    }
}
