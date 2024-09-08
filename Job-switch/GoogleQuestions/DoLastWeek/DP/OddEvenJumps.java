package DoLastWeek.DP;

import java.util.*;

public class OddEvenJumps {

    public int oddEvenJumps(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            count += rec(i, 1, arr); // Start with odd jump (1st jump is odd)
            System.out.println(i + " " + count);
        }
        return count;
    }

    public int rec(int idx, int jump, int[] arr) {
        if (idx >= arr.length - 1)
            return 1; // Reached the last index, this is a valid path

        TreeMap<Integer, Integer> map;
        if (jump % 2 == 1) { // Odd jump: find smallest element >= arr[idx]
            map = new TreeMap<>();
            for (int i = idx + 1; i < arr.length; i++) {
                if (arr[i] >= arr[idx]) {
                    map.put(arr[i], i);
                }
            }
        } else { // Even jump: find largest element <= arr[idx]
            map = new TreeMap<>(Collections.reverseOrder());
            for (int i = idx + 2; i < arr.length; i++) {
                if (arr[i] <= arr[idx]) {
                    map.put(arr[i], i);
                }
            }
        }

        if (map.isEmpty()) {
            return 0; // No valid jump possible
        }

        int nextIdx = map.get(map.firstKey()); // Get the next index to jump to
        return rec(nextIdx, jump + 1, arr); // Continue with the next jump
    }

}
