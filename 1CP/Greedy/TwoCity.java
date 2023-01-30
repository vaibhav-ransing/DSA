import java.util.Arrays;

public class TwoCity {
    
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (a, b) -> (b[1]-b[0])-(a[1]-a[0]));
        int total = 0;
        for(int i=0; i<costs.length/2; i++){
            total+=costs[0][0];
        }
        for(int i=costs.length/2; i<costs.length; i++){
            total+=costs[0][1];
        }
        return total;
    }

    public static void main(String[] args) {
        
    }
}
