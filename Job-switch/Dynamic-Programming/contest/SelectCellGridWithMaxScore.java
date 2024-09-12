import java.util.HashSet;
import java.util.List;

public class SelectCellGridWithMaxScore {

    public int maxScore(List<List<Integer>> grid) {

    }



    public int bruteForce(List<List<Integer>> grid) {
        HashSet<Integer> set = new HashSet<>();
        return rec(0, grid, 0, set);
    }

    
    public int rec(int idx, List<List<Integer>> grid, int count, HashSet<Integer> set) {
        if (idx == grid.size()) {
            return count;
        }
        int ans = rec(idx + 1, grid, count, set);
        for (int val : grid.get(idx)) {
            if (!set.contains(val)) {
                set.add(val);
                int c = rec(idx + 1, grid, count + val, set);
                ans = Math.max(ans, c);
                set.remove(val);
            }
        }
        return ans;
    }

}
