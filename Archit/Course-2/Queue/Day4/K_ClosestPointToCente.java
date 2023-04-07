import java.util.PriorityQueue;

public class K_ClosestPointToCente {
    
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (p1, p2) ->{
                double d1 = Math.sqrt(p1[0]*p1[0] + p1[1]*p1[1]);
                double d2 = Math.sqrt(p2[0]*p2[0] + p2[1]*p2[1]);
                if(d1 > d2) return -1;
                else if(d1 < d2) return 1;
                return 0;
            }
         );
         for(int[] point: points){
            if(pq.size() < k){
                pq.add(point);
            }else{
                pq.add(point);
                pq.remove();
                // double d1 = Math.sqrt(point[0]*point[0] + point[1]*point[1]);
                // double d2 = Math.sqrt(pq.peek()[0]*pq.peek()[0] + pq.peek()[1]*pq.peek()[1]);

                // if(d2 > d1){
                //     pq.remove();
                //     pq.add(point);
                // }
            }
         }
         int[][] ans = new int[k][2];
         int i=0;
         while(pq.size()>0){
            ans[i++] = pq.remove();
         }

         return ans;
    }
}
