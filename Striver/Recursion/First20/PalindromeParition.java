package First20;

public class PalindromeParition {

    public static void printPalindromes(String s) {
        helper(s, "");
    }

    public static void helper(String str, String asf) {
        if(str.length()<=0){
            System.out.println(asf);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            if (isPal(str, 0, i)) {
                helper(str.substring(i + 1), asf + "(" + str.substring(0, i + 1) + ") ");
            }
        }
    }

    public static boolean isPal(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        printPalindromes("abaaba");
    }
}
