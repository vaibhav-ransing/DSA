public class StraightLine {
    
    public boolean checkStraightLine(int[][] cord) {
        double slope = (((double)cord[1][0] - cord[0][0])/(cord[1][1] - cord[0][1]));

        for(int i=2; i<cord.length; i++){
            if(cord[i][1]-cord[0][1]==0){
                return false;
            }
            double curr = (((double)cord[i][0] - cord[0][0])/(cord[i][1] - cord[0][1]));
            
            if(curr!=slope){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        
    }
}
