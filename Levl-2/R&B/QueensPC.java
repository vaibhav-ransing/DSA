import java.util.HashSet;

public class QueensPC {
    

    static boolean isSafe(int arr[][], int row, int col){

        for(int i=0;i<arr.length; i++){
            if(arr[i][col]==1)
                return false;
        }

        int li=row, lj=col;
        while(li>=0 && lj>=0){
            if(arr[li][lj]==1)
                return false;
            li--;
            lj--;
        }
        int ri=row, rj=col;
        while(ri>=0 && rj<arr.length){
            if(arr[ri][rj]==1)
                return false;
            ri--;
            rj++;
        }
        return true;
    }
    static void nQueens(int arr[][], int row, int qp){
        if(row==arr.length){
            if(qp==arr.length){
                display(arr);
                System.out.println("--------");
            }
            return;
        }

        for(int i=0; i<arr.length; i++){
            if(isSafe(arr, row, i)){
                arr[row][i] = 1;
                nQueens(arr, row+1, qp+1);
                arr[row][i] = 0;
            }
        }
    }  
    static void display(int arr[][]){
        for(int r[]: arr){
            for(int val: r){
                if(val==1){
                    System.out.print('q');
                }else{
                    System.out.print('-');
                }
            }
            System.out.println();
        }
    }

    static void queenCombBoxChooses(int arr[][], int qr, int row, int col){
        if(qr==0 || row==arr.length){
            if(qr==0)
                display(arr);
            return;
        }  
        int nr, nc;
        if(col==arr.length-1){
            nr= row+1;
            nc = 0;
        }else{
            nr=row;
            nc = col+1;
        }
        arr[row][col] = 1;
        queenCombBoxChooses(arr, qr-1, nr, nc);
        arr[row][col] = 0;
        queenCombBoxChooses(arr, qr, nr, nc);
    }

    static void queenPermuQueenChooses(int arr[][], int cq){
        if(cq==arr.length){
            display2(arr);
            return;
        }
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr.length; j++){
                if(arr[i][j]==0){
                    arr[i][j] = cq;
                    queenPermuQueenChooses(arr, cq+1);
                    arr[i][j] = 0;
                }
            }
        }
    }
    static void display2(int arr[][]){
        for(int r[]: arr){
            for(int val: r){
                if(val!=0){
                    System.out.print("q"+val+"\t");
                }else{
                    System.out.print('-'+"\t");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    static void queenPermuBoxChooses(int arr[][], int qp, int row, int col, HashSet<Integer> set){
        if(row==arr.length || qp==arr.length){
            if(qp==arr.length)
                display2(arr);
            return;
        }
        int nr, nc;
        if(col==arr.length-1){
            nr = row+1;
            nc = 0;
        }else{
            nr = row;
            nc = col+1;
        }
        for(int i=1; i<=arr.length; i++){
            if(set.contains(i)==false){
                arr[row][col] =i;
                set.add(i);
                queenPermuBoxChooses(arr, qp+1, nr, nc, set);
                set.remove(i);
                arr[row][col] =0;
            }
        }
        queenPermuBoxChooses(arr, qp, nr, nc, set);

    }
    
    static void queenCombQueencChooses(int arr[][], int qp, int row, int col){
        if(qp==arr.length+1){
            display(arr);
            return;
        }
        if(row==arr.length)
            return;

        int nr, nc;
        if(col==arr.length-1){
            nr= row+1;
            nc = 0;
        }else{
            nr=row;
            nc = col+1;
        }
        arr[row][col] = 1;
        queenCombQueencChooses(arr, qp+1, nr, nc);
        arr[row][col] = 0;
        queenCombQueencChooses(arr, qp, nr, nc);
    }
    
    public static void main(String[] args) {
        int arr[][] = new int[2][2];
        // nQueens(arr, 0, 0);
        // HashSet<Integer> set = new HashSet<>();
        // queenPermuBoxChooses(arr, 0, 0, 0, set);

        queenCombQueencChooses(arr, 1, 0, 0);
        
    }
}
