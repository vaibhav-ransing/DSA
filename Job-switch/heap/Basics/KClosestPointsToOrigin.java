package Basics;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

    static class Pair implements Comparable<Pair> {
        int x;
        int y;
        double distance;

        Pair(int x, int y, double distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }

        public int compareTo(Pair o) {
            // we want obj with highest distance on top
            if (this.distance > o.distance) {
                return -1;
            } else {
                return 1;
            }
        }
    }

    public static int[][] kClosest(int[][] points, int k) {

        PriorityQueue<Pair> maxHeap = new PriorityQueue<>();

        for (int point[] : points) {
            int x = point[0];
            int y = point[1];
            double distance = Math.sqrt(x * x + y * y);
            if (maxHeap.size() < k) {
                maxHeap.add(new Pair(x, y, distance));
            } else {
                if (maxHeap.peek().distance > distance) {
                    maxHeap.remove();
                    maxHeap.add(new Pair(x, y, distance));
                }
            }
        }
        int ans[][] = new int[k][2];
        int idx = 0;
        while (maxHeap.size() > 0) {
            Pair currPair = maxHeap.remove();
            ans[idx][0] = currPair.x;
            ans[idx][1] = currPair.y;
            idx++;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 3, 3 },
                { 5, -1 },
                { -2, 4 }
        };
        int k = 2;
        Arrays.stream(kClosest(matrix, k)).forEach(arr -> System.out.println(Arrays.toString(arr)));
    }
}
