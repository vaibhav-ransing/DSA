package QuestionsCSWMIK.DFS;

import java.util.Arrays;
import java.util.List;

public class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] vis = new boolean[rooms.size()];
        dfs(0, vis, rooms);
        System.out.println(Arrays.toString(vis));
        for (int i = 0; i < rooms.size(); i++) {
            if (!vis[i] && rooms.get(i).size() > 0)
                return false;
        }
        return true;
    }

    public void dfs(int idx, boolean[] vis, List<List<Integer>> rooms) {
   
        vis[idx] = true;
        for (int nextIdx : rooms.get(idx)) {
            if (!vis[nextIdx]) {
                vis[nextIdx] = true;
                dfs(nextIdx, vis, rooms);
            }
        }
    }
}
