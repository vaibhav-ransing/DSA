package Course2.Matrix;

public class Multiplication{


    public void  Addition(int[][] matrixA, int[][] matrixB){
        int r1 = matrixA.length;
        int c1 = matrixA[0].length;

        int r2 = matrixB.length;
        int c2 = matrixB[0].length;
        if(c1 != r2) return;

        int[][] mat = new int[r1][c2];

        for(int r=0; r<r1; r++){
            for(int c=0; c<c2; c++){
                for(int k=0; k<c1; k++){
                    mat[r][c] += matrixA[r][k]*matrixB[k][c];
                }
            }
        }

        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[0].length; j++){
                System.out.println(mat[i][j] +" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        
    }
}