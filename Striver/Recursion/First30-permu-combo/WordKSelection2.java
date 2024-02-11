
public class WordKSelection2 {

    public static void solution(String str, int selections) {
        helper(str, 0, selections, "");
    }

    public static void helper(String str, int strIdx, int count, String asf){
        if(count == 0){
            System.err.println(asf);
            return;
        }

        if(strIdx >= str.length()){
            return;
        }

        for(int i=strIdx; i<str.length(); i++){
            char ch = str.charAt(i);
            helper(str, i+1, count-1, asf+"-"+ch);
        }
    }

    public static void main(String[] args) {
        // abcde _ _ _
        solution("abcde", 3);
    }

}
