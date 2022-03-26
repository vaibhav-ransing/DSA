import java.util.HashMap;
import java.util.HashSet;

public class day5 {
    

    static void longestSubstringUniqueCharacters(String s){
        // abcdaafghija
        HashMap<Character, Integer> map = new HashMap<>();
        boolean repeat = false;
        int i=0;
        int j=0;
        int len = 0;
        while(true){
            boolean f1 = false , f2=false;
            while(repeat==false && i<s.length()){
                char ch = s.charAt(i);
                i++;
                int currFreq = map.getOrDefault(ch, 0);
                if(currFreq>=1){
                    repeat = true;
                }else{
                    len = Math.max(len, i-j);
                }
                map.put(ch, map.getOrDefault(ch, 0)+1);
                f1 = true;
            }
            while(repeat==true){
                char ch = s.charAt(j);
                int currCharFreq = map.get(ch);
                if(currCharFreq==1){
                    map.remove(ch);
                }else if(currCharFreq==2){
                    map.put(ch, map.get(ch)-1);
                    repeat = false;
                }
                j++;
                f2 = true;
            }
            if(f1==false && f2==false)
                break;
        }
        System.out.println(len);
    }
    
    static void countSubstringUniqueCharacters(String s){
        // abcdaafghija
        HashMap<Character, Integer> map = new HashMap<>();
        boolean repeat = false;
        int i=0;
        int j=0;
        int count = 0;
        int len = 0;
        while(true){
            // aabcb
            boolean f1 = false , f2=false;
            while(repeat==false && i<s.length()){
                char ch = s.charAt(i);
                i++;
                int currFreq = map.getOrDefault(ch, 0);
                if(currFreq>=1){
                    repeat = true;
                    count+=1;
                    System.out.println("Rep "+i+" "+j+" "+count);
                }else{
                    len = i-j;
                    count+= len;
                    System.out.println("NR "+i+" "+j+" "+count);
                }
                map.put(ch, map.getOrDefault(ch, 0)+1);
                f1 = true;
            }
            while(repeat==true){
                char ch = s.charAt(j);
                int currCharFreq = map.get(ch);
                if(currCharFreq==1){
                    map.remove(ch);
                }else if(currCharFreq==2){
                    map.put(ch, map.get(ch)-1);
                    repeat = false;
                }
                j++;
                f2 = true;
            }
            if(f1==false && f2==false)
                break;
        }
        // System.out.println(i-j);
        System.out.println(count);
    }

    static void trickeySorting(int arr[]){
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLen = 0;
        for(int i=0;i<arr.length;i++){
            int key = arr[i];
            map.put(key, map.getOrDefault(key-1, 0)+1);
            maxLen = Math.max(maxLen, map.get(key));
        }
        System.out.println(arr.length-maxLen);
    }

    static boolean isomorphicString(String s1, String s2){
        HashMap<Character, Character> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();
        for(int i=0;i<s1.length();i++){
            char key = s1.charAt(i);
            char value = s2.charAt(i);
            if(map.containsKey(key)){
                if(map.get(key)!=value)
                    return false;
            }else{
                if(set.contains(value))
                    return false;
                map.put(key, value);
                set.add(value);
            }
        }
        return true;
        // p e p c o d i n g
        // s o s h e r l o k
    }
    
    static void smallestSubstringOfStringContainingAllitsUniqueCharacter(String s){
        HashSet<Character> set = new HashSet<>();
        String s2 = "";
        for(int i=0;i<s.length();i++){
            char key = s.charAt(i);
            if(set.contains(key))
                continue;
            else{
                s2+=key;
                set.add(key);
            }
        }
        String ans = minWindowSubstring2(s, s2);
        System.out.println(ans.length());
    }
    static String minWindowSubstring2(String s1, String s2){
        HashMap<Character, Integer> fixedMap = new HashMap<>();
        for(int i=0;i<s2.length();i++){
            char ch = s2.charAt(i);
            fixedMap.put(ch, fixedMap.getOrDefault(ch, 0)+1);
        }
        String ans = "";
        int currCount=0;
        int reqCount = s2.length();
        int i=0, j=0;
        HashMap<Character, Integer> map = new HashMap<>();
        while(true){
            boolean f1=false, f2=false;

            while(currCount<reqCount && i<s1.length()){
                char ch = s1.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0)+1);
                if(map.get(ch) <= fixedMap.getOrDefault(ch, 0))
                    currCount++;
                i++;
                f1 = true;
            }
            while(reqCount<=currCount){
                String temp = s1.substring(j, i);
                if(ans.length()==0 || temp.length()<ans.length()){
                    ans = temp;
                }
                char ch = s1.charAt(j);
                if(map.get(ch)==1)
                    map.remove(ch);
                else
                    map.put(ch, map.get(ch)-1);
                if(map.getOrDefault(ch, 0) < fixedMap.getOrDefault(ch, 0)){
                    currCount--;
                }
                j++;
                f2 = true;
            }
            if(f1==false && f2==false)
                break;

        }
        return ans;
    }

    static void longestSubstringWith_K_UniqueCharacters(String s, int k){
        HashMap<Character, Integer> map = new HashMap<>();
        // abcdaabcc
        String ans = "";
        int i=0,j=0, len=0;
        int uniqueCount = 0;
        while(true){
            boolean f1 = false, f2 =false;
            while(i<s.length() && uniqueCount<=k){
                char ch = s.charAt(i);
                if(map.containsKey(ch)){
                    map.put(ch, map.get(ch)+1);
                }else{
                    map.put(ch, 1);
                    uniqueCount++;
                }
                i++;
                if(uniqueCount==k){
                    ans = s.substring(j, i);
                    len = Math.max(len, i-j);
                }
                f1 = true;
            }
            while(uniqueCount>k){
                char ch = s.charAt(j);
                if(map.get(ch)==1){
                    map.remove(ch);
                    uniqueCount--;
                }else{
                    map.put(ch, map.get(ch)-1);
                }
                j++;
                f2 = true;
            }
            if(f1==false && f2==false)
                break;
        }
        // System.out.println(ans);
        System.out.println(len);
    }

    static void FindItineraryFromTickets(HashMap<String, String> map){

        HashSet<String> set = new HashSet<>();
        for(String key: map.keySet()){
            set.add(key);
        }
        for(String key: map.keySet()){
            String val = map.get(key);
            if(set.contains(val)){
                set.remove(val);
            }
        }
        String start = set.stream().findFirst().get();
        
        while(true){
            System.out.println( start);
            if(map.containsKey(start)){
                start = map.get(start);
                System.out.print(" -> ");
            }else{
                System.out.println(".");
                break;
            }
        }


    }

    public static void main(String[] args) {
        // longestSubstringUniqueCharacters("abcdaafghija");
        // countSubstringUniqueCharacters("aabcb");
        longestSubstringWith_K_UniqueCharacters("aabcbcdbca", 3);
    }
}
