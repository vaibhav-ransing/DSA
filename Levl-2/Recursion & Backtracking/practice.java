public class practice {
    
    static void nQueensBB(boolean[] ld,boolean[] rd,boolean[] col, int row, String ans){

        if(row==col.length){
            System.out.println(ans+".");
            return;
        }

        for(int i=0;i<col.length; i++){
            if(ld[row+i]==false && rd[row-i+col.length-1]==false && col[i]==false){
                ld[row+i]=true;
                rd[row-i+col.length-1]=true;
                col[i]=true;
                nQueensBB(ld, rd, col, row+1, ans+row+"-"+i+", " );
                ld[row+i]=false;
                rd[row-i+col.length-1]=false;
                col[i]=false;
            }
        }
    }


    public static void main(String[] args) {
        int n = 4;
        boolean[] ld = new boolean[2*n -1];
        boolean[] rd = new boolean[2*n -1];
        boolean[] col = new boolean[n];
        nQueensBB(ld, rd, col, 0, "");
    }
}
