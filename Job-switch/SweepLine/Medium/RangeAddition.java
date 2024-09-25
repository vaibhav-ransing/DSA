package SweepLine.Medium;

public class RangeAddition {

    public int[] getModifiedArray(int length, int[][] updates) {
        int[] prefix = new int[length];
        for (int[] update : updates) {
            prefix[update[0]] += update[2];
            if (update[1] + 1 < prefix.length)
                prefix[update[1] + 1] -= update[2];
        }
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] += prefix[i - 1];
        }

        return prefix;
    }
}
