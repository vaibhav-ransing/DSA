package First10;

public class Abbreviation {

    public static void printAbbreviation(String word) {
        helper(word, 0, 0, "");
    }

    public static void helper(String word, int idx, int count, String ans) {
        if (idx == word.length()) {
            ans = count == 0 ? ans : (ans + count);
            System.out.println(ans);
            return;
        }

        helper(word, idx + 1, 0, count == 0 ? (ans + word.charAt(idx)) : (ans + count + word.charAt(idx)) );
        helper(word, idx+1, count + 1, ans);

    }

    public static void main(String[] args) {
        printAbbreviation("abc");
    }
}
