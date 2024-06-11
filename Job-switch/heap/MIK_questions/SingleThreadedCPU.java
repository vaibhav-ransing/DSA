import java.util.Arrays;
import java.util.PriorityQueue;

public class SingleThreadedCPU {

    public int[] getOrder(int[][] tasks) {
        // Arrays.sort(tasks, (a,b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> { // start, end, time, idx
            if (a[1] != b[1]) { // different time
                return a[1] - b[1];
            } else {
                return a[3] - b[3];
            }
        });

        int timePassed = 0;
        int ansIdx = 0;
        int count = 0;
        int[] ans = new int[tasks.length];

        while (count < tasks.length) {

            for(int i=0; i<tasks.length; i++){
                int[] tsk = tasks[i];
                if(tsk[0] <= timePassed){
                    pq.add(new int[] { tsk[0], tsk[1], (tsk[1] - tsk[0]), i });
                    count++;
                    tsk[0] = Integer.MAX_VALUE;
                }
            }

            if (pq.size() > 0) {
                System.out.println("processing");
                while (pq.size() > 0) {
                    int task[] = pq.remove();
                    int s = task[0];
                    int timeTaken = task[1];
                    System.out.println(timeTaken +" tp= "+timePassed +" "+ pq.size());
                    if(s+timeTaken > timePassed){
                        timePassed = timeTaken;
                        ans[ansIdx++] = task[3];
                        break;
                    }
                }
            } else {
                    System.out.println("IOncresaing time ");
                timePassed++;
            }
        }

        while (pq.size() > 0) {
            int task[] = pq.remove();
            ans[ansIdx++] = task[3];
        }
        return ans;
    }

    public int[] getOrder23(int[][] tasks) {
        int n = tasks.length;
        int[] ans = new int[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else if (a[1] != b[1]) {
                return a[1] - b[1];
            } else {
                return a[2] - b[2];
            }
        });

        for (int i = 0; i < n; i++) {
            int[] task = tasks[i];
            pq.add(new int[] { task[0], task[1], i });
        }
        int i = 0;
        while (pq.size() > 0) {
            int[] peek = pq.remove();
            System.out.println(peek[0] + " " + peek[1]);
            ans[i++] = peek[2];
        }
        return ans;
    }

    public static void main(String[] args) {

    }

    class Pair implements Comparable<Pair> {
        int start;
        int end;
        int time;

        int idx;

        Pair(int start, int end, int idx) {
            this.start = start;
            this.end = end;
            this.idx = idx;
            this.time = start - end;
        }

        public int compareTo(Pair o) {
            if (this.time != o.time) {
                return this.time - o.time;
            } else {
                return this.idx - o.idx;
            }
        }
    }

}
