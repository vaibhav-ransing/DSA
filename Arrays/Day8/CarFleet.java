package Day8;

import java.util.Arrays;

public class CarFleet {

    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        // 0th index position
        // 1th - time
        double[][] data = new double[n][2];
        for(int i=0; i<n; i++){
            data[i][0] = position[i];
            data[i][1] = ((target - position[i])*1d)/speed[i];
        }
        Arrays.sort(data, ((a,b) -> ((int) a[0] - (int) b[0])) );

        int fleet = 0;
        double prevTime = 0;
        for(int i=n-1; i>=0; i--){
            double currTime = data[i][1];
            if(currTime > prevTime){
                prevTime = currTime;
                fleet++;
            }
        }   

        return fleet;
    }

    public static void main(String[] args) {
        
    }
}
