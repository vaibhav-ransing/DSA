import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class kSelect3 {
    

    static void permutaion(String str, int k, String asf, HashSet<String> set){
        if(k==0){
            if(set.contains(asf)==false){
                System.out.println(asf);
                set.add(asf);
            }
            return;
        }
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            String left = str.substring(0, i);
            String right = str.substring(i+1);
            permutaion(left+right, k-1, asf+ch, set);
        }
    }

    static void combination(String str, String arr[], int arrIndex, int idx, HashSet<String> set){
        if(arrIndex==arr.length){
            String ans = "";
            for(String val: arr){
                ans+=val;
            }
            if(set.contains(ans)==false){
                System.out.println(ans);
                set.add(ans);
            }
            return;
        }
        if(idx==str.length())
            return;

        for(int i=idx; i<str.length(); i++){
            arr[arrIndex] = str.charAt(i)+"";
            combination(str, arr, arrIndex+1, i+1, set);
            arr[arrIndex] = null;
        }   
    }




    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        // permutaion("aabbbccdde", 3, "", set);
        int k=3;
        String arr[] = new String[k];
        String str = "abaddcb";
        // combination(str, arr, 0, 0, set);
        char[] ch = str.toCharArray();
        Arrays.sort(ch);
        System.out.println(String.valueOf(ch));
    }
}
