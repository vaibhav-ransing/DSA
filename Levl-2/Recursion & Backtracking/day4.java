public class day4 {
    
    static void NqueensBnB(boolean ches[][], int qp, boolean[] ld, boolean[] rd, boolean[] col, String ans){
        if(qp==ches.length){
            System.out.println(ans+".");
            return;
        }

        for(int i=0;i<ches.length;i++){
            if( col[i]==false && ld[qp+i]==false && rd[qp - i + ches.length -1]==false ){
                col[i] = true;
                ld[qp+i] = true;
                rd[qp - i +ches.length-1] = true;
                NqueensBnB(ches, qp+1, ld, rd, col, ans+ qp+"-"+i+", " );
                col[i] = false;
                ld[qp+i] = false;
                rd[qp - i +ches.length-1] = false;
            }
        }

    }


    static boolean isSafeSudoku(int arr[][] , int row, int col, int val){
        for(int i=0;i<arr.length; i++){
            if(arr[row][i]==val)
                return false;
            if(arr[i][col]==val)
                return false;
        }
        int startRow = 3*(row/3);
        int startCol = 3*(col/3);
        for(int i= startRow; i<startRow+3; i++){
            for(int j= startCol; j<startCol+3; j++){
                if(arr[i][j]==val)
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int n=4;
        boolean ches[][] = new boolean[n][n];
        boolean col[] = new boolean[n];
        boolean ld[] = new boolean[2*n-1];
        boolean rd[] = new boolean[2*n-1];
        NqueensBnB(ches, 0, ld, rd, col, "");

    }
}
