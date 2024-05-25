import java.util.ArrayList;

public class CountNumberOfComponents {

    public int countCompleteComponents(int n, int[][] edges) {

		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}
		for (int[] edge : edges) {
			graph.get(edge[0]).add(edge[1]);
			graph.get(edge[1]).add(edge[0]);
		}

		boolean[] visited = new boolean[n];
		boolean[] countVisit = new boolean[n];
		int ans = 0;

		for (int i = 0; i < n; i++) {
			if (visited[i] == false) {
				int count = getNbrCount(graph, i, countVisit) - 1;
				int valid = helper(graph, i, visited, count);
				if (valid == 0)
					ans++;
			}
		}
		return ans;
	}

	public int getNbrCount(ArrayList<ArrayList<Integer>> graph, int idx, boolean[] visited) {
		if (visited[idx])
			return 0;

		visited[idx] = true;
		int count = 0;
		for (int nbr : graph.get(idx)) {
			count += getNbrCount(graph, nbr, visited);
		}
		return count + 1;
	}

	public int helper(ArrayList<ArrayList<Integer>> graph, int idx, boolean[] visited, int count) {
		if (visited[idx])
			return 0;

		visited[idx] = true;
		int ans = 0;

		if (graph.get(idx).size() != count)
			ans = 1;
		for (int nbr : graph.get(idx)) {
			ans += helper(graph, nbr, visited, count);
		}
		return ans;
	}
}
