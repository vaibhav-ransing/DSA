import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QueenComb2dAs2D {

    public static List<List<String>> solveNQueens(int n) {

        List<List<String>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            ans.add(new ArrayList<>(Collections.nCopies(n, "_")));
        }

        helper(0, 0, "", 2, 2);
        System.out.println(ans);
        return ans;
    }

    public static void helper(int row, int col, String asf, int n, int totalQueen) {

        if (row == n) {
            if (totalQueen == 0) {
                System.out.println(asf);
                System.out.println("*********");
            }
            return;
        }
        String take;
        String dontTake;

        if (col == n - 1) {
            row = row + 1;
            col = 0;
            take = asf + "q\n";
            dontTake = asf + "-\n";
        } else {
            take = asf + "q";
            dontTake = asf + "-";
        }
        helper(row, col + 1, take, n, totalQueen - 1);
        helper(row, col + 1, dontTake, n, totalQueen);
    }

    public static void main(String[] args) {
        solveNQueens(4);
    }
}
