public class knightsProbability {
    
    
    public double knightProbability(int n, int k, int row, int column) {
        int xMove[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
        int yMove[] = { 1, 2, 2, 1, -1, -2, -2, -1 };

        double curr[][] = new double[n][n];
        double next[][] = new double[n][n];

        curr[row][column]= 1;

        for(int m=0; m<k; m++){

            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(curr[i][j]!=0){

                        for(int t=0; t<xMove.length; t++){
                            int ii = i+xMove[t];
                            int jj = j+yMove[t];

                            if(ii<0 || jj<0 || i>=n || j>=n) continue;
                            next[ii][jj] += curr[i][j]/8.0;
                        }
                    }
                }
            }
            curr = next;
            next = new double[n][n];
        }
        double sum=0;
        for(double d[]: curr){
            for(double val: d){
                sum+=val;
            }
        }
        return sum;
    }



    public static void main(String[] args) {
        
    }
}
