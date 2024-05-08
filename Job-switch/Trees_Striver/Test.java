import java.util.ArrayList;
import java.util.PriorityQueue;

public class Test {
    


    static class Pair implements Comparable<Pair> {
        int col;
        int row;
        int val;

        Pair(int col, int row, int val) {
            this.col = col;
            this.row = row;
            this.val = val;
        }

        public int compareTo(Pair o) {
            if (this.col == o.col && this.row == o.col) {
                return this.val - o.val;
            } else if (this.col == o.col) {
                return this.row - o.row;
            } else {
                return this.col - o.col;
            }
        }
    }

    public static void main(String[] args) {
        
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(-1,0,2));
        pq.add(new Pair(0,0,3));
        pq.add(new Pair(0,0,1));

        while (pq.size() > 0) {
            System.out.println(pq.remove().val);
        }

    }
}
