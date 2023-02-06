import java.util.HashMap;
import java.util.List;

public class LC438 {
    

    public List<Integer> findAnagrams(String str, String p) {
        int n = p.length();
        HashMap<Character, Integer> staticMap = new HashMap<>();
        for(char ch: p.toCharArray()){
            staticMap.put(ch, staticMap.getOrDefault(ch, 0)+1);
        }
        HashMap<Character, Integer> map = new HashMap<>(staticMap);
        int count = 0;
        int i=0, j=0;
        while(j<str.length()){
            char currChar = str.charAt(j);
            if(map.containsKey(currChar)){
                map.put(currChar, map.get(currChar)-1);
                if(map.get(currChar)==0){
                    map.remove(currChar);
                }
                j++;
                count++;
            }else{
                count=0;
                map = new HashMap<>(staticMap);
                i=j;
            }
            if(count==n){
                System.out.println("i "+i);
            }
        }
        return null;
    }


    public static void main(String[] args) {
        
    }
}
