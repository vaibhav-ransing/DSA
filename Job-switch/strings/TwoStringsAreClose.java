import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class TwoStringsAreClose {

    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length())
            return false;

        // Check if both strings contain the same unique characters
        HashSet<Character> set1 = new HashSet<>();
        HashSet<Character> set2 = new HashSet<>();
        for (char ch : word1.toCharArray()) {
            set1.add(ch);
        }
        for (char ch : word2.toCharArray()) {
            set2.add(ch);
        }
        if (!set1.equals(set2))
            return false;

        // Create frequency maps
        HashMap<Character, Integer> freqMap1 = new HashMap<>();
        HashMap<Character, Integer> freqMap2 = new HashMap<>();
        for (char ch : word1.toCharArray()) {
            freqMap1.put(ch, freqMap1.getOrDefault(ch, 0) + 1);
        }
        for (char ch : word2.toCharArray()) {
            freqMap2.put(ch, freqMap2.getOrDefault(ch, 0) + 1);
        }

        // Create priority queues
        PriorityQueue<Pair> pq1 = new PriorityQueue<>((a, b) -> a.freq - b.freq);
        PriorityQueue<Pair> pq2 = new PriorityQueue<>((a, b) -> a.freq - b.freq);

        for (HashMap.Entry<Character, Integer> entry : freqMap1.entrySet()) {
            pq1.add(new Pair(entry.getKey(), entry.getValue()));
        }
        for (HashMap.Entry<Character, Integer> entry : freqMap2.entrySet()) {
            pq2.add(new Pair(entry.getKey(), entry.getValue()));
        }

        // Compare the frequency distributions
        while (!pq1.isEmpty() && !pq2.isEmpty()) {
            if (pq1.poll().freq != pq2.poll().freq) {
                return false;
            }
        }

        return true;
    }

    class Pair {
        char ch;
        int freq;

        Pair(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
    }

}
