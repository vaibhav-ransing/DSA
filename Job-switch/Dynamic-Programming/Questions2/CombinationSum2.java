import java.util.ArrayList;
import java.util.List;

public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(0, candidates, target, new ArrayList<>(), ans);
        return ans;
    }

    public void dfs(int idx, int[] candidates, int target, List<Integer> curr, List<List<Integer>> ans) {
        if (target < 0 || idx == candidates.length)
            return;
        if (target == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        dfs(idx + 1, candidates, target, curr, ans);
        curr.add(candidates[idx]);
        dfs(idx + 1, candidates, target - candidates[idx], curr, ans);
        curr.remove(curr.size() - 1);
    }
}
