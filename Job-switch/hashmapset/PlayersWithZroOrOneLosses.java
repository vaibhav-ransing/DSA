import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

public class PlayersWithZroOrOneLosses {

    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> ans = new ArrayList<>();
        // matches[i] = [winner-i, loser-i]
        HashMap<Integer, Integer> timeDefeatedMap = new HashMap<>();

        TreeSet<Integer> teams = new TreeSet<>();
        for (int[] mat : matches) {
            teams.add(mat[0]);
            teams.add(mat[1]);
            timeDefeatedMap.put(mat[1], timeDefeatedMap.getOrDefault(mat[1], 0) + 1);
        }
        List<Integer> zeroLost = new ArrayList<>();
        List<Integer> oneLost = new ArrayList<>();
        for (int val : teams) {
            int lost = timeDefeatedMap.getOrDefault(val, 0);
            if (lost == 0) {
                zeroLost.add(val);
            } else if (lost == 1) {
                oneLost.add(val);
            }
        }
        ans.add(zeroLost);
        ans.add(oneLost);
        return ans;
    }

}