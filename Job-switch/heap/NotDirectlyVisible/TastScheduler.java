package NotDirectlyVisible;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Stack;

public class TastScheduler {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : tasks) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (char key : map.keySet()) {
            maxHeap.add(new Pair(key, map.get(key)));
        }
        Stack<Pair> stack = new Stack<>();
        int ans = 0;
        while (maxHeap.size() > 0) {
            // n = 2 A-2, B-1 are the two tasks with frequency 2 and 1
            // After A and B are popped then n=0
            // but there should be one more space after B i.e AB_A
            // After every pop from heap we reduce tempN by 1
            // if max heap is empty and tempN is greater than 0 i.e. tempN > 0
            // we check if the stack is not empty,
            // if empty then we add remaining tempN to the answer
            // We check for stack size here because
            // A-2 B-1 tempN=2 after first iteration ans = 3 i.e. AB_ , tempN=0 , 'stack
            // contains A-1'
            // A-1 tempN=2 -> AB_A and tempN=1 but stack is empty if we add this tempN then
            // ans will be AB_A_
            // we dont want that unncessary _ at the end so we skip add this tempN
            int tempN = n + 1;

            while (tempN > 0 && maxHeap.size() > 0) {
                Pair peek = maxHeap.remove();
                // now reduce the peek frequency value by 1 and add it in stack if freq is
                // greater than 0
                peek.freq = peek.freq - 1;
                if (peek.freq > 0)
                    stack.push(peek);
                // Collect 1 in answer and reduce tempN
                ans++;
                tempN--;
            }

            // if tempN is not 0 and stack size is not 0 means there will be more items
            // appending in answer so we need these
            // tempN spaces before adding new charaters to ans.
            if (tempN > 0 && stack.size() > 0)
                ans += tempN;

            while (stack.size() > 0) {
                maxHeap.add(stack.pop());
            }
        }
        return ans;
    }
}

class Pair implements Comparable<Pair> {
    char ch;
    int freq;

    Pair(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
    }

    public int compareTo(Pair o) {
        return this.freq - o.freq;
    }
}
