import java.util.HashMap;
import java.util.Scanner;

import javax.management.remote.JMXAddressable;

public class Main {
    
    public static Character maxFrequencyCharacter(String s){
        HashMap<Character , Integer> map = new HashMap<>();
        int max = 0;
        char ans = s.charAt(0);
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                map.put(c, map.get(c)+1);
                int val = map.get(c);
                if(val>max){
                    max = val;
                    ans = c;
                }
            }else{
                map.put(c, 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {    

        Character ans = maxFrequencyCharacter("abccbab");
        System.out.println(ans);
    }
}
