import java.io.*;
import java.util.*;

public class cryptarthmetic {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String s1 = scn.nextLine();
    String s2 = scn.nextLine();
    String s3 = scn.nextLine();

    HashMap<Character, Integer> charIntMap = new HashMap<>();
    String unique = "";
    for (int i = 0; i < s1.length(); i++) {
      if (!charIntMap.containsKey(s1.charAt(i))) {
        charIntMap.put(s1.charAt(i), -1);
        unique += s1.charAt(i);
      }
    }

    for (int i = 0; i < s2.length(); i++) {
      if (!charIntMap.containsKey(s2.charAt(i))) {
        charIntMap.put(s2.charAt(i), -1);
        unique += s2.charAt(i);
      }
    }

    for (int i = 0; i < s3.length(); i++) {
      if (!charIntMap.containsKey(s3.charAt(i))) {
        charIntMap.put(s3.charAt(i), -1);
        unique += s3.charAt(i);
      }
    }

    boolean[] usedNumbers = new boolean[10];
    solution(unique, 0, charIntMap, usedNumbers, s1, s2, s3);
  }

  
  public static void solution(String unique, int idx, 
							  HashMap<Character, Integer> charIntMap, 
                              boolean[] usedNumbers, 
							  String s1, String s2, String s3) {

    if(idx== unique.length()){
        int n1 = stringNum(charIntMap, s1);
        int n2 = stringNum(charIntMap, s2);
        int n3 = stringNum(charIntMap, s3);
        if(n1+n2==n3){
            for(char ch='a'; ch<='z'; ch++) {
                if(charIntMap.containsKey(ch)){
                    System.out.print(ch +" "+charIntMap.get(ch));
                }
            }
            System.out.println();
        }
        return;
    }

    for(int i=0;i <10; i++){

        if(usedNumbers[i]==false){
          usedNumbers[i]= true;
          char ch = unique.charAt(idx);
          charIntMap.put(ch, i);
          solution(unique, idx+1, charIntMap, usedNumbers, s1,s2, s3);

          usedNumbers[i]= false;
          charIntMap.put(ch, -1);
        }
    }
  }

  static int stringNum(HashMap<Character, Integer> map, String s){
        String num = "";
        for(int i=0;i<s.length();i++){
            char ch=  s.charAt(i);
            int val = map.get(ch);
            num+=val;
        }
        return Integer.parseInt(num);
    }

}
