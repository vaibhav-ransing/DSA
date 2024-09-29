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
            starts[inteval[0] + 1] = true;
        }

        int prevStart = -1;

        for (int i = 1; i < prefix.length; i++) {

            prefix[i] += prefix[i - 1];
            // If prefix sum is not 0 and prevStart is -1 means this is the begining of a range
            if (prefix[i] != 0 && prevStart == -1) {
                prevStart = i;

            }
            // If prefix sum is 0 and prevStart is not -1 that means at prevStart - 1 one range completed 
            else if (prefix[i] == 0 && prevStart != -1) {
                ans.add(new int[] { prevStart - 1, i - 1 });
                prevStart = -1;
            } 
            // If start and end is same i.e [0,0] or [5,5]
            // Then even though the prefix sum will cancel out each other
            // we will know that there was a starting from here using starts[i]
            else if ((starts[i] && prefix[i] == 0)) {
                ans.add(new int[] { i - 1, i - 1 });
            }
        }
        int[][] finalAns = new int[ans.size()][];
        for (int i = 0; i < ans.size(); i++) {
            finalAns[i] = ans.get(i);
        }
        return finalAns;
    }
}
