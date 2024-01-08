package First10;

import java.util.*;

public class NQueens {

    public static List<List<String>> solveNQueens(int n) {

        List<List<String>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            ans.add(new ArrayList<>(Collections.nCopies(5, "")));
        }
        helper(ans, 0, 0, 0);
        return ans;
    }

    public static void helper(List<List<String>> ans, int row, int col, int placedCount) {

        if (row == ans.size() || (row == ans.size() - 1 && col == ans.size())) {
            if (placedCount == ans.size())
                System.out.println(ans);
            return;
        }

        row = col == ans.size() ? row + 1 : row;
        col = col == ans.size() ? 0 : col;

        if (isSafe(ans, row, col)) {
            ans.get(row).set(col, "Q");
            helper(ans, row + 1, 0, placedCount + 1);
            ans.get(row).set(col, "");
        }
        helper(ans, row, col + 1, placedCount);
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
