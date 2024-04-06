package Subsequence;

public class RodCutting {

    public int minCost(int n, int[] cuts) {
        //  n = 7
        // [1,3,4,5]
        return recursion(n, cuts);
    }

    public int recursion(int woodLen, int[] cuts) {

        if (woodLen == 0)
            return 0;

        if(woodLen < 0)
            return Integer.MIN_VALUE;

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < cuts.length; i++) {
            int val = recursion(woodLen - (i+1), cuts) + cuts[i];
            max = Math.max(max, val);
        }
        return max;
    }

    public static void main(String[] args) {

    }
}
