import java.util.HashMap;

public class cryptarithmetic {
    
    public static boolean isSolvable(String[] words, String result) {
        HashMap<Character, Integer> map = new HashMap<>();
        String unique = "";
        for(String word: words){
            unique+= uniqueHelper(map, word);
        }
        unique+=uniqueHelper(map,result);
        boolean[] usedNum = new boolean[10];

        return helper(map, unique, usedNum, 0, words, result);
    }
    public static boolean helper(HashMap<Character, Integer> map, String unique, boolean[] usedNum, int idx, String[] words, String result){
        if(idx==unique.length()){
            int val = 0;
            for(String word: words){
                val += strToInt(word, map);
            }
            if(val== strToInt(result, map)){

                for(char ch: map.keySet()){
                    System.out.println(ch+" "+map.get(ch));
                }
                System.out.println(val);

                for(String word: words){
                    char sc = word.charAt(0);
                    if(map.get(sc)==0){
                        return false;
                    }
                }

                return true;
            }
            return false;
        }
        for(int i=0; i<10; i++){
            if(!usedNum[i]){
                usedNum[i] = true;
                char chc = unique.charAt(idx);
                map.put(chc, i);
                boolean ans = helper(map, unique, usedNum, idx+1, words, result);
                map.put(chc, -1);
                usedNum[i] = false;
                if(ans) return true;
            }
        }
        return false;
    }
    public static int strToInt(String str,HashMap<Character, Integer> map){
        int mult=10;
        int num=0;
        for(char ch: str.toCharArray()){
            int v = map.get(ch);
            num = (num*mult)+v;
        }
        return num;
    }

    public static String uniqueHelper(HashMap<Character, Integer> map, String word){
        String temp = "";
        for(char ch : word.toCharArray()){
            if(!map.containsKey(ch)){
                map.put(ch, -1);
                temp+=ch;
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        String words[] = {"SEND","MORE"};
        String result = "MONEY";
        System.out.println(isSolvable(words, result));
    }
}
