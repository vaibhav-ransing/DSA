import java.util.Arrays;

public class MinCostCutStick {

    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        return rec(0, n, cuts, 0, cuts.length - 1);
    }

    public int rec(int left, int right, int[] cuts, int iStart, int iEnd) {
        if (iStart > iEnd) {
            return 0;
        }

        int cost = right - left; 
        int min = Integer.MAX_VALUE;

        for (int i = iStart; i <= iEnd; i++) {
            int currCut = cuts[i];

            int val = rec(left, currCut, cuts, iStart, i - 1) +
                    rec(currCut, right, cuts, i + 1, iEnd);

            min = Math.min(min, val);
        }

        return min + cost;
    }
}
