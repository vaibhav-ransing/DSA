import java.util.ArrayList;

class Solution {
	public int countCompleteComponents(int n, int[][] edges) {

		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}
		for (int[] edge : edges) {
			graph.get(edge[0]).add(edge[1]);
			graph.get(edge[1]).add(edge[0]);
		}
		for (ArrayList<Integer> temp : graph) {
			System.out.println(temp);
		}
		boolean[] visited = new boolean[n];
		int ans = 0;
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				System.out.println("size " + i + " " + graph.get(i).size());
				boolean valid = helper(graph, i, visited, graph.get(i).size());
				if (valid) {
					ans++;
				}
			}
		}
		return ans;
	}

	public boolean helper(ArrayList<ArrayList<Integer>> graph, int idx, boolean[] visited, int count) {
		if (visited[idx])
			return true;
		
		visited[idx] = true;
		boolean ans = true;
        // if (graph.get(idx).size() != count)
		// 	ans = false;
		for (int nbr : graph.get(idx)) {
			ans = ans && helper(graph, nbr, visited, count);
		}
		return ans;
	}
}