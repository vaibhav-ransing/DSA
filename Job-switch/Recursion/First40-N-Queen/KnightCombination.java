public class KnightCombination {

    public static void nKnight(int kpsf, int tk, boolean[][] chess, int lcno) {
        if (kpsf == tk) {
            System.out.println(chess);
            return;
        }

        for (int i = lcno + 1; i < chess.length * chess.length; i++) {
            int row = i / chess.length;
            int col = i % chess.length;
            if (chess[row][col] == false && IsKnifhtSafe(chess, row, col)) {
                chess[row][col] = true;
                nKnight(kpsf + 1, tk, chess, i);
                chess[row][col] = false;
            }
        }
    }

    public static boolean IsKnifhtSafe(boolean[][] chess, int row, int col) {
        return true;
    }

    public static void main(String[] args) {

    }
 
}
