package First10;

import java.util.*;

public class NQueensForLoop {

    public static List<List<String>> solveNQueens(int n) {

        List<List<String>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            ans.add(new ArrayList<>(Collections.nCopies(n, "_")));
        }

        helper(ans, 0, 0, 0);
        System.out.println(ans);
        return ans;
    }

    public static void helper(List<List<String>> ans, int row, int col, int placedCount) {

        if (row == ans.size()) {
            if (placedCount == ans.size()) {
                System.out.println(ans);
            }
            return;
        }
        row = col == ans.size() ? row + 1 : row;
        col = col == ans.size() ? 0 : col;

        for (int i = 0; i < ans.size(); i++) {

            if (isSafe(ans, row, i)) {
                ans.get(row).set(i, "Q");
                helper(ans, row + 1, 0, placedCount + 1);
                ans.get(row).set(i, "_");
            }
            helper(ans, row + 1, 0, placedCount);

        }

    }

    public static boolean isSafe(List<List<String>> ans, int row, int col) {

        for (int i = 0; i < ans.size(); i++) {
            if (ans.get(i).get(col).equals("Q") || ans.get(row).get(i).equals("Q")) {
                return false;
            }
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (ans.get(i).get(j).equals("Q"))
                return false;
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < ans.size(); i--, j++) {
            if (ans.get(i).get(j).equals("Q"))
                return false;
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (ans.get(i).get(j).equals("Q"))
                return false;
        }

        return true; // No conflicts found, it's safe to place a queen
    }

    public static void main(String[] args) {
        solveNQueens(4);
    }
}
