public class CountOnesInSortedMatrix {
    
    int countZeros(int mat[][], int n) {
        int row = 0, col = mat[0].length-1;
        int count = 0;
        while(row<mat.length && col>=0){
            if(mat[row][col]==0){
                row++;
                count+=(col+1);
            }else{
                col--;
            }
        }
        return count;
    }
}
