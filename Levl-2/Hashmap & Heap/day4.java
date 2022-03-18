import java.util.ArrayList;
import java.util.HashMap;

public class day4 {
    
    static void anagram(String s1, String s2){
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> temp = new HashMap<>();
        for(int i=0;i<s2.length();i++){
            char c1 = s2.charAt(i);
            map.put(c1, map.getOrDefault(c1, 0)+1);

            char c2 = s1.charAt(i);
            temp.put(c2, temp.getOrDefault(c2, 0)+1);
        }
        ArrayList<Integer> al = new ArrayList<>();
        int count= 0 ;
        int len = s2.length();
        if(map.equals(temp)){
            count++;
            al.add(0);
        }
        for(int i=len; i<s1.length();i++){
            char curr = s1.charAt(i);
            char release = s1.charAt(i-len);
            temp.put(curr, temp.getOrDefault(curr, 0)+1);
            
            if(temp.get(release)==1){
                temp.remove(release);
            }else{
                temp.put(release, temp.get(release)-1);
            }
            if(temp.equals(map)){
                count++;
                al.add(i-len+1);
            }
        }
        System.out.println(count);
        for(int val: al)
            System.out.print(val);
    }
    static void printKanagram(String fst, String sec, int k){
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        
        for(int i=0;i<fst.length();i++){
            char f = fst.charAt(i);
            map1.put(f, map1.getOrDefault(f, 0)+1);

            char s = sec.charAt(i);
            map2.put(s, map2.getOrDefault(s, 0)+1);
        }
        for(char key: map1.keySet()){
            Integer fcount = map1.get(key);
            Integer scount = map2.get(key);
            if(scount!=null){
                int min = Math.min(fcount, scount);
                map1.put(key, fcount-min);
                map2.put(key, scount-min);
            }
            if(map1.get(key)==0)
                map1.remove(key);
            if(map2.get(key)==0)
                map2.remove(key);
        }
        System.out.println(map1.size());
    }

    static void minWindowSubstring(String s, String t){
        HashMap<Character, Integer> constantMap = new HashMap<>();
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<t.length();i++){
            char key = t.charAt(i);
            constantMap.put(key, constantMap.getOrDefault(key, 0)+1);

            char key2 = s.charAt(i);
            map.put(key2, map.getOrDefault(key, 0)+1);
        }
        int len = Integer.MAX_VALUE;
        if(valid(constantMap, map)){
            System.out.println(t.length());
            return;
        }
        // ABBDCBBA   ABC 
        int sfci = 0;
        int i=t.length();
        for(i=t.length(); i<s.length(); i++){
            if(valid(constantMap, map)){
                len = Math.min(len, i-sfci);
                System.out.println(len+" "+i);
                char release = s.charAt(sfci);
                map.put(release, map.get(release)-1);
                if(map.get(release)==0)
                    map.remove(release);
                sfci++;
                i--;
            }else{

                char ch = s.charAt(i);
                System.out.println(ch);
                map.put(ch, map.getOrDefault(ch, 0)+1);
            }
        }
        // System.out.println(valid(constantMap, map));
        for(char key: map.keySet()){
            System.out.println(key+" "+map.get(key));
        }
        // while(valid(constantMap, map)){
        //     len = Math.min(len, i-sfci);
        //     System.out.println(len+" "+i);
        //     char release = s.charAt(sfci);
        //     map.put(release, map.get(release)-1);
        //     if(map.get(release)==0)
        //         map.remove(release);
        //     sfci++;
        // }

    }
    static boolean valid(HashMap<Character, Integer> constantMap,HashMap<Character, Integer> map ){
        
        for(char key: constantMap.keySet()){
            if(map.get(key)!=constantMap.get(key))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        // String s1 = "cbaebabacd";
        // String s2 = "abc";
        // anagram(s1, s2);
        // printKanagram("fodr", "gork", 2);

        minWindowSubstring("ABBDCBBA", "ABC");         

    }
}
