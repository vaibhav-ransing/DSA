package ZRandom;

import java.util.HashSet;

public class MinAreaRect {

    public int minAreaRect(int[][] points) {
        HashSet<String> set = new HashSet<>();
        int min = Integer.MAX_VALUE;
        for (int[] p : points) {
            int xp = p[0];
            int yp = p[1];
            for (String str : set) {
                String[] diagonalPoints = str.split(",");
                int xd = Integer.parseInt(diagonalPoints[0]);
                int yd = Integer.parseInt(diagonalPoints[1]);

                String remp1 = xp + "," + yd;
                String remp2 = xd + "," + yp;
                if (set.contains(remp1) && set.contains(remp2)) {
                    int area = (Math.abs(xp - xd) * Math.abs(yp - yd));
                    min = Math.min(min, area);
                }
            }
            set.add(xp + "," + yp);
        }

        return min == Integer.MAX_VALUE ? 0 : min; // Return 0 if no rectangle is found
    }

    class Solution {
        public int minAreaRect(int[][] points) {
            HashSet<String> set = new HashSet<>();
            int min = Integer.MAX_VALUE; // Set initial value to maximum integer

            for (int[] p : points) {
                int xp = p[0];
                int yp = p[1];
                // Loop over the set of already seen points
                for (String str : set) {
                    String[] diagonalPoints = str.split(",");
                    int xd = Integer.parseInt(diagonalPoints[0]);
                    int yd = Integer.parseInt(diagonalPoints[1]);

                    // Check if the current point and this diagonal point can form a rectangle
                    String remp1 = xp + "," + yd;
                    String remp2 = xd + "," + yp;
                    // Check if the other two points of the rectangle exist in the set
                    if (set.contains(remp1) && set.contains(remp2)) {
                        int area = Math.abs(xp - xd) * Math.abs(yp - yd);
                        min = Math.min(min, area); // Update min area
                    }
                }
                set.add(xp + "," + yp); // Add the current point to the set
            }

            return min == Integer.MAX_VALUE ? 0 : min; // Return 0 if no rectangle is found
        }
    }

}
