import java.util.Arrays;

public class WordKSelection {

    public static void solution(String str, int selections) {
        char[] arr = new char[selections];
        helper(str, 0, 0, arr, 0);
    }

    public static void helper(String str, int strIdx, int secltedCount, char[] arr, int arrIdx) {

        if (secltedCount == arr.length) {
            System.out.println(Arrays.toString(arr));
            return;
        }
        if (strIdx >= str.length()) {
            return;
        }

        helper(str, strIdx + 1, secltedCount, arr, arrIdx); // dont select the str char
        char currCh = str.charAt(strIdx);

        // <------------------------ Combination ------------------------>
        arr[arrIdx] = currCh;
        helper(str, strIdx + 1, secltedCount + 1, arr, arrIdx + 1);
        arr[arrIdx] = '\0';

        // <------------------------ Permutation ------------------------>
        // for(int i=0; i<arr.length; i++){
        // if(arr[i] == '\0'){
        // arr[i] = currCh;
        // helper(str, strIdx+1, secltedCount+1, arr);
        // arr[i] = '\0';
        // }
        // }
    }

    public static void main(String[] args) {
        // abcde _ _ _
        solution("abcde", 3);
    }
}