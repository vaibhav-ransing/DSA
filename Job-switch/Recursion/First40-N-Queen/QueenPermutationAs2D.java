import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class QueenPermutationAs2D {

    public static List<List<String>> solveNQueens(int n) {

        List<List<String>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            ans.add(new ArrayList<>(Collections.nCopies(n, "_")));
        }

        System.out.println(ans);
        return ans;
    }

    public static void queenPermutation(int qpsf, int tq, int[][] chess) {
        if (qpsf == tq) {
            System.out.println(Arrays.toString(chess));
            return;
        }
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess[0].length; j++) {
                if (chess[i][j] == 0) {
                    chess[i][j] = (qpsf + 1);
                    queenPermutation(qpsf + 1, tq, chess);
                    chess[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {

    }
}
