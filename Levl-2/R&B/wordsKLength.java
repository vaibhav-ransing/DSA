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
    
    static void w1(String unique, Character[] arr, int k, int idx){
        if(k==0){
            for(char ch: arr){
                System.out.print(ch);
            }
            System.out.println();
            return;
        }
        if(idx==unique.length()){
            return;
        }

        char ch = unique.charAt(idx);
        for(int i=0; i<arr.length; i++){
            if(arr[i]==null){
                arr[i] =ch;
                w1(unique, arr, k-1, idx+1);
                arr[i] =null;
            }
        }
        w1(unique, arr, k, idx+1);
    }


    static void w2(String unique, int k, String asf){
        if(k==0){
            System.out.println(asf);
            return;
        }
        for(int i=0;i<unique.length(); i++){
            char ch = unique.charAt(i);
            String left = unique.substring(0, i);
            String right = unique.substring(i+1);
            w2(left+right, k-1, asf+ch);
        }
    }

    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        // solution("abce", 0, 3, "", 4, set);
        // w1("abcde", new Character[3], 3, 0);
        w2("abcde", 3, "");
    }
}
