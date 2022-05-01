package Anuj;
import java.text.BreakIterator;
import java.util.HashMap;

public class mp {
    
    static void windowSubstring(String s, String p){
        int matchCount = 0;
        HashMap<Character, Integer> fixed = new HashMap<>();
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0;i<p.length();i++){
            char ch = p.charAt(i);
            fixed.put(ch, fixed.getOrDefault(ch, 0)+1);

        }
        // ABBDC-CBDA      ABC
        int len = Integer.MAX_VALUE;
        int i=0, j=0;
        while(true){  

            while(j<s.length() && matchCount< p.length()){
                char ch = s.charAt(j);
                int fc = fixed.getOrDefault(ch, 0);
                int mc = map.getOrDefault(ch, 0);
                if(fc!=0 && fc>mc){
                    matchCount++;
                }
                System.out.println(ch+" "+fc+" "+mc+" "+matchCount);
                j++;
                map.put(ch, map.getOrDefault(ch, 0)+1);
            }   

            while(i<s.length() && matchCount>= p.length()){
                String temp = s.substring(i, j);
                System.out.println(temp);
                char release = s.charAt(i);
                int fc = fixed.getOrDefault(release, 0);
                int mc = map.get(release);
                len = Math.min(len, j-i+1);

                if(fc==mc){
                    matchCount--;
                }
                if(mc==1){
                    map.remove(release);
                }else{
                    map.put(release, map.get(release)-1);
                }
                i++;
            }

            if(j==s.length()){
                break;
            }
        }
        System.out.println(len);
    }


    public static void main(String[] args) {
        windowSubstring("ABBDCCBDA", "ABC");
        
    }
}
