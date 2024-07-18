import java.util.HashMap;

public class CountGoodPartiions {
    class Solution {
        public static int numberOfGoodPartitions(int[] arr) {
            int n = arr.length;
            HashMap<Integer, Integer> valRightIdx = new HashMap<>();
            for (int i = 0; i < n; i++) {
                valRightIdx.put(arr[i], i);
            }
            int count = 1;
            int i = 0, j = valRightIdx.get(arr[0]);

            while (i < n) {
                if (i > j) {
                    count = (count * 2) % 1000000007;
                }
                int cv = arr[i];
                j = Math.max(j, valRightIdx.get(cv));
                i++;
            }
            return count;
        }
    }

    public static int numberOfGoodPartitions(int[] arr) {
        int n = arr.length;
        // int[] right_occ = new int[n];
        HashMap<Integer, Integer> valRightIdx = new HashMap<>();
        for (int i = 0; i < n; i++) {
            valRightIdx.put(arr[i], i);
        }
        int count = 1;
        int i = 0, j = valRightIdx.get(arr[0]);

        while (j < n) {
            if (i > j) {
                // count = (count * 2) % 1000000007;
                // j = i;
                // continue;
            }
            int cv = arr[i];
            j = Math.max(j, valRightIdx.get(cv));
            i++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 1, 3, 3, 4 };
        System.out.println(numberOfGoodPartitions(arr));
    }
}
