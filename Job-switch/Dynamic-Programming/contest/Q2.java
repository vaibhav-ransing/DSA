import java.util.Arrays;
import java.util.HashMap;

public class Q2 {

    public long maximumPoints(int[] arr, int eng) {
        boolean marked[] = new boolean[arr.length];
        HashMap<String, Long> map = new HashMap<>();
        long ans = rec(arr, marked, eng, 0, map);
        return ans;
    }

    public long rec(int arr[], boolean[] marked, int currEng, int currPoint, HashMap<String, Long> map) {

        String key = currEng + "-" + currPoint + "-" + Arrays.toString(marked);
        if (map.containsKey(key))
            return map.get(key);
        long points = 0;
        // operation 1 kill and take point
        for (int i = 0; i < arr.length; i++) {
            if (!marked[i] && currEng >= arr[i]) {
                long p = 1 + rec(arr, marked, currEng - arr[i], currPoint + 1, map);
                points = Math.max(points, p);
            }
        }

        // operation 2 if points > 0 and unmarked take the enrrgy and makr it
        for (int i = 0; i < arr.length; i++) {
            if (currPoint > 0 && !marked[i]) {
                marked[i] = true;
                long p2 = rec(arr, marked, currEng + arr[i], currPoint, map);
                marked[i] = false;
                points = Math.max(points, p2);

            }
        }
        map.put(key, points);
        return points;
    }
}
