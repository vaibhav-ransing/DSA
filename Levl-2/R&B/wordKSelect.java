import java.util.HashSet;
import java.util.Scanner;

public class wordKSelect {


    static void pickKunique(String str, int count,int index, HashSet<Character> set, String asf, HashSet<String> uniquePrint){
        if(index==str.length()){
            if(asf.length()==count){
                if(uniquePrint.contains(asf)==false){
                    System.out.println(asf);
                    uniquePrint.add(asf);
                }
            }
            return;
        }   
        if(set.contains(str.charAt(index))==false){
            set.add(str.charAt(index));
            pickKunique(str, count, index+1, set, asf+str.charAt(index), uniquePrint);
            set.remove(str.charAt(index));
        }
        pickKunique(str, count, index+1, set, asf, uniquePrint);
    }

    public static void wordSelect1(int i, String ustr, int ssf, int ts, String asf ) {
        if(i==ustr.length()){
            if(ssf==ts){
                System.out.println(asf);
            }
            return;
        }
        wordSelect1(i+1, ustr, ssf+1, ts, asf+ustr.charAt(i));
        wordSelect1(i+1, ustr, ssf, ts, asf);
    }

    public static void solution1(String unique, int idx, Character[] arr, int k){

        if(idx==arr.length){
            if(k==0){
                for(char val: arr){
                    System.out.print(val);
                }
                System.out.println();
            }
            return;
        }
        char ch = unique.charAt(idx);
        for(int i=0; i<arr.length; i++){
            if(arr[i]==null){
                arr[i] = ch;
                solution1(unique, idx+1, arr, k-1);
                arr[i] = null;
            }
        }
        solution1(unique, idx+1, arr, k);
    }


//  ----------------------------------------------------------------------------------------------
    static void w1(String unique, int idx, int bi, Character[] arr, int k){
        if(idx==unique.length() || bi==arr.length){
            if(bi==arr.length){
                for(char val: arr){
                    System.out.print(val);
                }
                System.out.println();
            }
            return;
        }
        arr[bi] = unique.charAt(idx);
        w1(unique, idx+1, bi+1, arr, k);
        arr[bi] = null;
        w1(unique, idx+1, bi, arr, k);
    }

    public static void word1(int idx, String ustr, int ansLen, int ts, String asf ) {
        if(idx==ustr.length()){
            if(ansLen==ts){
                System.out.println(asf);
            }
            return;
        }

        char ch = ustr.charAt(idx);
        word1(idx+1, ustr, ansLen+1, ts, asf+ch);
        word1(idx+1, ustr, ansLen, ts, asf);
    }
//  ----------------------------------------------------------------------------------------------



    public static void main(String[] args) {
        HashSet<Character> set = new HashSet<>();
        // pickKunique("aabbbccdde", 3, 0, set, "", new HashSet<>());
        // solution1("abcde", 0, new Character[3], 3);
        // w1("abcde", 0, 0, new Character[3], 3);
        word1(0, "abcde", 0, 3, "");

        
    }
}
