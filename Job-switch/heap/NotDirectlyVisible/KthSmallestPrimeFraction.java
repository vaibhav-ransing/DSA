package NotDirectlyVisible;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public class KthSmallestPrimeFraction {
    class Optimized {

        public int[] kthSmallestPrimeFraction(int[] arr, int k) {
            PriorityQueue<double[]> minHeap = new PriorityQueue<>((a, b) -> (int) Math.ceil((a[2] - b[2])));
            int n = arr.length;

            minHeap.add(new double[] { 0, n - 1, arr[0] / (double) arr[n - 1] });
            System.out.println(arr[0] / (double) arr[n - 1]);
            HashSet<String> set = new HashSet<>();
            set.add("0-" + (n - 1));
            while (k-- > 1) {
                double[] peek = minHeap.poll();
                int i = (int) peek[0];
                int j = (int) peek[1];

                double fracISame = j - 1 >= 0 ? arr[i] / (double) arr[j - 1] : Integer.MAX_VALUE;
                double fracJSame = i + 1 < n ? arr[i + 1] / (double) arr[j] : Integer.MAX_VALUE;

                if (fracISame != Integer.MAX_VALUE && !set.contains(i + "-" + (j - 1))) {
                    set.add(i + "-" + (j - 1));
                    minHeap.add(new double[] { i, j - 1, arr[i] / (double) arr[j - 1] });
                }
                if (fracJSame != Integer.MAX_VALUE && !set.contains((i + 1) + "-" + j)) {
                    set.add((i + 1) + "-" + j);
                    minHeap.add(new double[] { i + 1, j, arr[i + 1] / (double) arr[j] });
                }
            }
            return new int[] { arr[(int) minHeap.peek()[0]], arr[(int) minHeap.peek()[1]] };
        }
    }

    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        // PriorityQueue<double[]> minHeap = new PriorityQueue<>((a,b) -> {return a[2] >
        // b[2] ? 1 : 0;} );
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                double d1 = (double) a[0] / a[1];
                double d2 = (double) b[0] / b[1];
                if (d1 < d2)
                    return 1;
                else if (d1 > d2)
                    return -1;
                else
                    return 0;
            }
        });
        int n = arr.length;

        // add all the fraction into the priority queue till k size
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                minHeap.add(new int[] { arr[i], arr[j] });

                if (minHeap.size() > k)
                    minHeap.poll();
            }
        }
        return new int[] { (int) minHeap.peek()[0], (int) minHeap.peek()[1] };
    }
}
