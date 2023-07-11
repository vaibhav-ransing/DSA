
import java.util.ArrayList;

public class BestMeetingPoint {

    public int minTotalDistance(int[][] mat) {
        ArrayList<Integer> x_coord = new ArrayList<>();
        ArrayList<Integer> y_coord = new ArrayList<>();

        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[0].length; j++){
                if(mat[i][j] == 1){
                    x_coord.add(i);
                }
            }
        }

        for(int j=0; j<mat[0].length; j++){
            for(int i=0; i<mat.length; i++){
               if(mat[i][j] == 1){
                    y_coord.add(j);
                } 
            }
        }   
        int mid = x_coord.size()/2;
        int x = x_coord.get(mid);
        int y = y_coord.get(mid);
        int distance = distanceCalculator(x, y, x_coord, y_coord);

        return distance;
    }

    public int distanceCalculator(int x, int y, ArrayList<Integer> x_coord, ArrayList<Integer> y_coord){
        int distance = 0;
        for(int xCord : x_coord){
            distance += Math.abs(x-xCord);
        }
        for(int yCord : y_coord){
            distance += Math.abs(y-yCord);
        }
        return distance;
    }
}
