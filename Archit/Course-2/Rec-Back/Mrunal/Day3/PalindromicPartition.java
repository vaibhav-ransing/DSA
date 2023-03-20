import java.util.ArrayList;
import java.util.List;

import javax.print.DocFlavor.STRING;

public class PalindromicPartition {
    

    public static void soln(String str, int startIdx, int currIdx, String asf, int count){
        if(startIdx>=str.length() || currIdx>str.length()){
            if(count==str.length())
                System.out.println(asf);
            return;
        }
        //  abaaba
        soln(str, startIdx, currIdx+1, asf, count);
        if(isPalindrome(str, startIdx, currIdx)){
            soln(str, currIdx, currIdx+1, asf+"("+str.substring(startIdx, currIdx) +")", count+(currIdx-startIdx));
        }
        
    }

    static List<List<String>> list;
    public static List<List<String>> partition(String s) {
        list = new ArrayList<>();
        helper(s, 0, 1, 0, new ArrayList<String>());
        System.out.println(list);
        return list;
    }

    public static void helper(String str, int startIdx, int currIdx,  int count, List<String> al ){
        if(startIdx>=str.length() || currIdx>str.length()){
            if(count==str.length()){
                list.add(al);
            }
            return;
        }
        //  abaaba
        if(isPalindrome(str, startIdx, currIdx)){
            al.add(str.substring(startIdx, currIdx));
            helper(str, currIdx, currIdx+1,count+(currIdx-startIdx), al);
            al.remove(al.size()-1);
        }
        helper(str, currIdx, currIdx+1,count,al);
    }

    public static boolean isPalindrome(String str, int se, int ee){
        int i=0;
        int j=str.length()-1;
        while(j>i){
            if(str.charAt(i)!=str.charAt(j)){
                return false;
            }
            j--;
            i++;
        }
        return true;
    }





    static List<List<String>> ansList;
    public static void partionSoln(String str){
        ansList = new ArrayList<>();
        helper2(str, new ArrayList<String>());
        System.out.println(ansList);
    }
    public static void helper2(String str, ArrayList<String> al){
        if(str.length()==0){
            System.out.println(al);
            ArrayList<String> tempList = new ArrayList<>(al);
            ansList.add(tempList);
            return;
        }
        for(int i=0; i<str.length(); i++){
            String substr = str.substring(0, i+1);
            if(palCheck(substr)){
                al.add(substr);
                helper2(str.substring(i+1), al);
                al.remove(al.size()-1);
            }
        }
    }
    //  abaaba
    public static boolean palCheck(String str){
        int i=0,j=str.length()-1;
        while(j>i){
            if(str.charAt(i++)!=str.charAt(j--)){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        partionSoln("aab");
    }
}
