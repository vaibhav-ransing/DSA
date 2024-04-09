package Subsequence;

public class RodCuttingMinCost {
    

    public int minCost(int n, int[] cuts) {
        return recursion(n, cuts);
    }
    public int recursion(int woodLen, int[] cuts) {
        if (woodLen == 0)
            return 0;
        if(woodLen < 0)
            return 9999999;
        int min = 9999999;
        for (int i = 0; i < cuts.length; i++) {
            int val = recursion(woodLen - (i+1), cuts) + cuts[i];
            min = Math.min(min, val);
        }
        return min;
    }
}
