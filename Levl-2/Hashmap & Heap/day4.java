import java.util.ArrayList;
import java.util.HashMap;

public class day4 {
    
    static void printAll_anagram(String s1, String s2){
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
    
    static void printKanagram(String s1, String s2, int k){
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        
        for(int i=0;i<s1.length();i++){
            char f = s1.charAt(i);
            map1.put(f, map1.getOrDefault(f, 0)+1);

            char s = s2.charAt(i);
            map2.put(s, map2.getOrDefault(s, 0)+1);
        }

        for(char key: map1.keySet()){
            int  fc = map1.get(key);
            int sc = map2.getOrDefault(key, 0);
            if(sc!=0){
                int min = Math.min(fc, sc);
                map1.put(key, fc-min);
                map2.put(key, sc-min);
            }
        }
        int count=0;
        for(char key: map2.keySet()){
            count+= map2.get(key);
        }
        if(count<=k)
            System.out.println(true);
        else
            System.out.println(false);
    }


    static void anagramMapping(String s, String p){
        HashMap<Character, ArrayList<Integer>> map = new HashMap<>();
        int arr[] = new int[s.length()];
        for(int i=0;i<p.length();i++){
            char ch = p.charAt(i);
            if(map.containsKey(ch)){
                ArrayList<Integer> al = map.get(ch);
                al.add(i);
                map.put(ch, al);
            }else{
                ArrayList<Integer> al = new ArrayList<>();
                al.add(i);
                map.put(ch, al);
            }
        }
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            ArrayList<Integer> al = map.get(ch);
            arr[i] = al.get(0);
            al.remove(0);
            map.put(ch, al);
        }
        for(int val: arr){
            System.out.print(val+" ");
        }
    }
    static void anagramMapping2(int arr1[], int arr2[]){
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int arr[] = new int[arr1.length];
        for(int i=0;i<arr2.length;i++){
            int key = arr2[i];
            if(map.containsKey(key)){
                ArrayList<Integer> al = map.get(key);
                al.add(i);
                map.put(key, al);
            }else{
                ArrayList<Integer> al = new ArrayList<>();
                al.add(i);
                map.put(key, al);
            }
        }
        for(int i=0;i<arr1.length;i++){
            int key = arr1[i];
            ArrayList<Integer> al = map.get(key);
            arr[i] = al.get(0);
            al.remove(0);
            map.put(key, al);

        }
    }
   
    static void minWindowSubstring2(String s1, String s2){
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
        System.out.println(ans);
    }
   
    public static void main(String[] args) {
        minWindowSubstring2("aabdcab", "abc");
    }
}
