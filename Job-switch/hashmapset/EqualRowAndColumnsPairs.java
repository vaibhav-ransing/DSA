import java.util.HashMap;

public class EqualRowAndColumnsPairs {

    public int equalPairs(int[][] grid) {
        // HashSet<String> set = new HashSet<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (int[] row : grid) {
            StringBuilder sb = new StringBuilder();
            for (int val : row) {
                sb.append(val + "-");
            }
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
        }
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < grid.length; j++) {
                sb.append(grid[j][i] + "-");
            }
            if (map.containsKey(sb.toString())) {
                count += map.get(sb.toString());
            }
        }
        return count;
    }
}
