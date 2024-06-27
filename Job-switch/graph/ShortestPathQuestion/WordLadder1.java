package ShortestPathQuestion;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class WordLadder1 {

    class Pair {
        String word;
        int dist;

        Pair(String word, int dist) {
            this.word = word;
            this.dist = dist;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        HashSet<String> visited = new HashSet<>();

        ArrayDeque<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(beginWord, 0));

        while (queue.size() > 0) {
            Pair peek = queue.remove();
            if(visited.contains(peek.word))
                continue;
            visited.add(peek.word);
            if(peek.word.equals(endWord))
                return peek.dist;

            for(String nbr : wordList){
                if(hasEdge(peek.word, nbr)){
                    queue.add(new Pair(nbr, peek.dist + 1));
                }
            }
        }
        return 0;
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
