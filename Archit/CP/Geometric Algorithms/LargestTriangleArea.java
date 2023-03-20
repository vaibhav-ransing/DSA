

public class LargestTriangleArea {
    public double area(int[] p1,int[] p2,int[] p3){
        // (ΔABC) = (1/2) |x1(y2 − y3) + x2(y3 − y1) + x3(y1− y2)|   
        double area = 0.5*Math.abs( p1[0]*(p2[1]-p3[1]) + p2[0]*(p3[1]-p1[1]) + p3[0]*(p1[1]-p2[1]));
        return area;

     }

    public double largestTriangleArea(int[][] points) {
        double max = 0;
        for(int[] p1: points){
            for(int[] p2: points){
                for(int[] p3: points){
                    max = Math.max(max, area(p1, p2, p3));
                }
            }
        }   
        return max;
    }

}
