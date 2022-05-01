public class day2 {
    
    public static void queensPermutations(int queensPlaced, int n, int[][] chess){
        if(queensPlaced > n){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(chess[i][j]!=0){
                        System.out.print("q"+chess[i][j]+" ");
                    }else{
                        System.out.print("_");
                    }
                }
                System.out.println();
            }

            return;
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(chess[i][j]==0){
                    chess[i][j] = queensPlaced;
                    queensPermutations(queensPlaced+1, n, chess);
                    chess[i][j] = 0;
                }
            }
        }
    }

    // public static void queensCombination(int qp, int row, int col, int[][] chess){

    //     if(row> chess.length || col> chess.length){
    //         return;
    //     }
    //     if(qp>chess.length){
    //         int n = chess.length;
    //         for(int i=0;i<n;i++){
    //             for(int j=0;j<n;j++){
    //                 if(chess[i][j]!=0){
    //                     System.out.print("q"+chess[i][j]+"\t");
    //                 }else{
    //                     System.out.print("-\t");
    //                 }
    //             }
    //             System.out.println();
    //         }   
    //         System.out.println();

    //         return;
    //     }
    //     int cRow= row;
    //     int cCol = col;

    //     for(int i=row; i<chess.length;i++){
    //         int cj= cRow==row? 0:col;
    //         for(int j=cj; j<chess.length;j++){
    //             if(chess[i][j]==0){
    //                 chess[i][j] = qp;
    //                 queensPermutations(qp+1, i, j, chess);
    //                 chess[i][j] = 0;
    //             }
    //         }
    //     }
    // }

    // public static void queensPermutationsBoxChoose()
    

    public static void main(String[] args) {
        
    }
}
