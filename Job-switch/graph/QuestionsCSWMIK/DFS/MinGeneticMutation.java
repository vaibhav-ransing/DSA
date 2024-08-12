package QuestionsCSWMIK.DFS;

import java.util.HashSet;

public class MinGeneticMutation {
    public int minMutation(String startGene, String endGene, String[] bank) {
        int val = dfs(startGene, endGene, bank, new HashSet<>());
        if (val >= 999999 || val > 100000)
            return -1;
        return val;
    }

    public int dfs(String start, String end, String[] bank, HashSet<String> vis) {
        if (start.equals(end))
            return 0;
        if (vis.contains(start))
            return 99999;
        vis.add(start);
        int min = 999999;
        for (String str : bank) { // n
            if (canGo(str, start)) { // 8
                min = Math.min(min, 1 + dfs(str, end, bank, vis)); // n!
            }
        }
        vis.remove(start);
        return min;
    }

    public boolean canGo(String str, String bankStr) {

        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != bankStr.charAt(i))
                count++;
        }
        return count == 1;
    }

}
