import java.util.HashMap;

public class patternMatching {
    
    public static void solution(String s,String pattern,int index, HashMap<Character, String> map){
        if(s.length()==0){
            if(index==pattern.length()){
                boolean arr[] = new boolean[26];
                for(int i=0;i<pattern.length();i++){
                    char ch=  pattern.charAt(i);
                    if(arr[ch-'a']==false){
                        System.out.print(ch+" "+map.get(ch)+", ");
                    }
                    arr[ch-'a'] = true;
                }
            }
            return;
        }
        if(index==pattern.length())
            return;
        char ch = pattern.charAt(index);
        if(map.containsKey(ch)){
            String temp = map.get(ch);
            int len = temp.length();
            if(s.length() < temp.length()){
                return;
            }else if(s.substring(0, len).equals(temp)){
                solution(s.substring(len), pattern, index+1, map);
            }else{
                return;
            }
        }else{
            for(int i=0;i <s.length();i++){
                String temp = s.substring(0, i+1);
                String rem = s.substring(i+1);
                map.put(ch, temp);
                solution(rem, pattern, index+1, map);
                map.remove(ch);
            }
        }
    }


    public static void main(String[] args) {
        HashMap<Character, String> map = new HashMap<>();
        solution("graphtreegraph", "pep", 0, map);
    }
}
