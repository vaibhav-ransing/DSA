package DoLastWeek.DP;

import java.util.Arrays;
import java.util.TreeMap;

public class OddEvenJumpsOD {

    public int oddEvenJumps(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][2];
        Arrays.stream(dp).forEach(row -> Arrays.fill(row, -1));
        dp[n - 1][0] = 1;
        dp[n - 1][1] = 1;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(arr[n - 1], n - 1);
        int count = 1;

        for (int i = n - 2; i >= 0; i--) {
            int cv = arr[i];

            // Odd jump (find the smallest element >= arr[i])
            if (map.ceilingKey(cv) != null) {
                int nextIdx = map.get(map.ceilingKey(cv));
                dp[i][0] = dp[nextIdx][1]; // Odd jump leads to an even jump
            }

            // Even jump (find the largest element <= arr[i])
            if (map.floorKey(cv) != null) {
                int nextIdx = map.get(map.floorKey(cv));
                dp[i][1] = dp[nextIdx][0]; // Even jump leads to an odd jump
            }

            // If odd jump from index i can reach the end, increment count
            if (dp[i][0] == 1) {
                count++;
            }

            // Add current value and index to the TreeMap
            map.put(arr[i], i);
        }

        return count;
    }

    public static void main(String[] args) {
        TreeMap<Integer, Integer> map = new TreeMap<>(); // arr[i], i
        map.put(15, 3);
        map.put(20, 8);
        map.put(17, 5);
        System.out.println("Ceil of " + 16 + ": " + map.ceilingKey(16)); // 17
        System.out.println("Flor of " + 16 + ": " + map.floorKey(16)); // 15
    }
}