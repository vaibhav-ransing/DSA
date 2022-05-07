import java.util.HashMap;
import java.util.HashSet;

public class wordsKLength {
    

    static void solution(String unique, int ansLen, int k, String asf, int uniqueLen, HashSet<String> set){
        if(ansLen==uniqueLen){
            if(k==0 && set.contains(asf)==false){
                System.out.println(asf);
                set.add(asf);
            }
            return;
        }

        for(int i=0;i<unique.length(); i++){
            char ch = unique.charAt(i);
            String left = unique.substring(0, i);
            String right = unique.substring(i+1);
            solution(left+right, ansLen+1, k-1, asf+ch, uniqueLen, set);
        }
        solution(unique, ansLen+1, k, asf, uniqueLen, set);
    }
    



    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        solution("abce", 0, 3, "", 4, set);
    }
}
