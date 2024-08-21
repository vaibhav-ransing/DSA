package QuestionsCSWMIK.ShortestPath;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class PathWithMaxPropabilitl {

    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        ArrayList<ArrayList<double[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());
        for (int i = 0; i < edges.length; i++) {
            int ed[] = edges[i];
            graph.get(ed[0]).add(new double[] { ed[1], succProb[i] });
            graph.get(ed[1]).add(new double[] { ed[0], succProb[i] });
        }
        double[] prob_arr = new double[n];
        prob_arr[start_node] = 1;
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[1], a[1]));
        pq.add(new double[] { start_node, 1.0 }); // src, ,prob
        while (pq.size() > 0) {
            double[] peek = pq.poll();
            int src = (int) peek[0];
            double probability = peek[1];

            for (double[] nbr_prob : graph.get(src)) {
                int nbr = (int) nbr_prob[0];
                double newProb = probability * nbr_prob[1];
                if (newProb > prob_arr[nbr]) {
                    prob_arr[nbr] = newProb;
                    pq.add(new double[] { nbr, newProb });
                }
            }
        }
        return prob_arr[end_node];
    }

}