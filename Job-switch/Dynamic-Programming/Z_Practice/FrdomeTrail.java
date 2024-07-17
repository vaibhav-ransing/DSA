public class FrdomeTrail {

    public int findRotateSteps(String ring, String key) {
        return rec(0, 0, ring, key);
    }

    public int rec(int idx, int dialIdx, String ring, String key) {
        if (idx == key.length()) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        int n = ring.length();

        // Iterate through all positions in the ring
        for (int i = 0; i < n; i++) {
            if (ring.charAt(i) == key.charAt(idx)) {
                int distance = Math.abs(dialIdx - i);
                distance = Math.min(distance, n - distance); // Minimum of clockwise and counterclockwise distance
                min = Math.min(min, 1 + distance + rec(idx + 1, i, ring, key));
            }
        }
        return min;
    }

    // public int findRotateSteps(String ring, String key) {
    // return rec(0, 0, ring, key);
    // }

    // public int rec(int idx, int dialIdx, String ring, String key) {
    // if (idx == key.length()) {
    // return 0;
    // }

    // int min = Integer.MAX_VALUE;
    // for (int i = dialIdx; i >= 0; i--) {
    // if (ring.charAt(i) == key.charAt(idx)) {
    // min = Math.min(min, 1 + Math.abs(i - idx) + rec(idx + 1, i, ring, key));
    // }
    // }
    // for (int i = dialIdx; i < ring.length(); i++) {
    // if (ring.charAt(i) == key.charAt(idx)) {
    // min = Math.min(min, 1 + Math.abs(i - idx) + rec(idx + 1, i, ring, key));
    // }
    // }
    // return min;
    // }
}
