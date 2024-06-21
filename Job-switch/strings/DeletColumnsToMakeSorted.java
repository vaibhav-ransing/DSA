/**
 * DeletColumnsToMakeSorted
 */
public class DeletColumnsToMakeSorted {

    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int col = 0, count = 0;
        while (col < strs[0].length()) {
            for (int row = 1; row < n; row++) {
                String prev_word = strs[row - 1];
                String curr_word = strs[row];

                if (prev_word.charAt(col) > curr_word.charAt(col)) {
                    count++;
                    break;
                }
            }
            col++;
        }
        return count;
    }
}