package Revision;

import java.util.HashSet;
import java.util.PriorityQueue;

public class KtheSmallestPrime {

    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(a[2], b[2])); // i, j, fraction
        int n = arr.length;
        pq.add(new double[] { 0, n - 1, arr[0] / arr[n - 1] });
        HashSet<String> set = new HashSet<>();
        set.add(0 + " " + 0);
        while (pq.size() > 0) {
            double[] peek = pq.remove();
            int i = (int) peek[0], j = (int) peek[1];
            System.out.println(arr[i] + " " + arr[j]);
            if (k-- == 1)
                return new int[] { arr[i], arr[j] };
            // i + 1, j
            if (i + 1 <= j && !set.contains((i + 1) + " " + (j))) {
                set.add((i + 1) + " " + (j));
                pq.add(new double[] { i + 1, j, (double) arr[i + 1] / arr[j] });
            }
            if (j - 1 >= i && !set.contains((i) + " " + (j - 1))) {
                set.add((i) + " " + (j - 1));
                pq.add(new double[] { i, j - 1, (double) arr[i] / arr[j - 1] });
            }
        }
        return null;
    }
}
