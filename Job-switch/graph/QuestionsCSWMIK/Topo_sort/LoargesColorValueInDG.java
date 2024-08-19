package QuestionsCSWMIK.Topo_sort;

import java.util.*;

public class LoargesColorValueInDG {

    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        int[] indegree = new int[n];
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            indegree[edge[1]]++;
        }
        int[][] dp = new int[n][26];

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                dp[i][colors.charAt(i) - 'a']++;
                queue.add(i);
            }
        }
        int ans = -1;
        int nodesSeen = 0;
        while (queue.size() > 0) {
            int src = queue.poll();
            nodesSeen++;
            for (int nbr : graph.get(src)) {
                for (int i = 0; i < 26; i++) {
                    dp[nbr][i] = Math.max(dp[nbr][i], dp[src][i]);
                }
                dp[nbr][colors.charAt(nbr) - 'a']++;
                indegree[nbr]--;
                if (indegree[nbr] == 0) {
                    queue.add(nbr);
                }
            }
            for (int val : dp[src]) {
                ans = Math.max(ans, val);
            }
        }
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, Arrays.stream(dp[i]).max().orElse(-1));
        }
        return nodesSeen == n ? ans : -1;
    }

    public int largestPathValueWrong(String colors, int[][] edges) {
        int n = colors.length();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        int[] indegree = new int[n];
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            indegree[edge[1]]++;
        }
        HashMap<Integer, int[]> map = new HashMap<>();
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                int[] freq = new int[26];
                freq[colors.charAt(i) - 'a']++;
                map.put(i, freq);
                queue.add(i);
            }
        }
        int ans = -1;
        int nodesSeen = 0;
        while (queue.size() > 0) {
            int src = queue.poll();
            indegree[src]--;
            nodesSeen++;
            int[] freq = map.get(src);
            int isEnd = 0;
            for (int nbr : graph.get(src)) {
                indegree[nbr]--;
                System.out.println(nbr + " " + indegree[nbr]);
                if (indegree[nbr] == 0) {
                    isEnd++;
                    int[] newFreq = new int[26];
                    for (int i = 0; i < freq.length; i++) {
                        newFreq[i] = freq[i];
                    }
                    newFreq[colors.charAt(nbr) - 'a']++;
                    map.put(nbr, newFreq);
                    queue.add(nbr);
                }
            }
            System.out.println(src + " end " + isEnd);
            if (isEnd == 0) {
                for (int val : freq) {
                    ans = Math.max(ans, val);
                }
            }
        }
        return nodesSeen == n ? ans : -1;
    }

}