package SweepLine.Medium;

import java.util.ArrayList;
import java.util.List;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        int[] prefix = new int[100005];
        List<int[]> ans = new ArrayList<>();
        boolean[] starts = new boolean[100005];
        for (int[] inteval : intervals) {
            prefix[inteval[0] + 1]++;
            prefix[inteval[1] + 1]--;
            starts[inteval[0] + 1] = starts[inteval[1] + 1] = true;
        }

        int prevStart = -1;

        for (int i = 1; i < prefix.length; i++) {

            prefix[i] += prefix[i - 1];
            if (prefix[i] != 0 && prevStart == -1 || (starts[i] && prefix[i] == 0)) {
                prevStart = i;
            } else if (prefix[i] == 0 && prevStart != -1) {
                ans.add(new int[] { prevStart - 1, i -1});
                prevStart = -1;
            }
        }
        int[][] finalAns = new int[ans.size()][];
        for (int i = 0; i < ans.size(); i++) {
            finalAns[i] = ans.get(i);
        }
        return finalAns;
    }
}
