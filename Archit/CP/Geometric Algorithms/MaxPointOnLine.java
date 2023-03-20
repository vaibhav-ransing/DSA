import java.util.HashMap;

public class MaxPointOnLine {
    
    public double getSlope(int[] p1, int[] p2){
        if(p1[0]==p2[0] && p1[1]==p2[1]){
            return Double.NEGATIVE_INFINITY;
        }
        if(p1[0]==p2[0] ){
            return Double.POSITIVE_INFINITY;
        }
        return ((double)(p2[1]-p1[1])/(p2[0]-p1[1]));
    }

    public int maxPoints(int[][] points) {
        if(points.length <=2){
            return points.length;
        }
        int ans = 2;
        for(int[] p1: points){
            HashMap<Double, Integer> map = new HashMap<>();
            for(int[] p2: points){
                double slope = getSlope(p1, p2);
                map.put(slope, map.getOrDefault(slope, 1)+1);
                ans = Math.max(ans, map.get(slope));
            }
        }
        return ans;
    }
}
