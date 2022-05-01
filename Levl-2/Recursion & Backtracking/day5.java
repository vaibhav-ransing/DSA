import java.util.HashMap;

public class day5 {
    

    static int stringNum(HashMap<Character, Integer> map, String s){
        int num=0;
        for(int i=0;i<s.length();i++){
            char ch=  s.charAt(i);
            int val = map.get(ch);
            num+=val;
        }
        for(char key: map.keySet()){
            System.out.println(key +" "+map.get(key));
        }

        return num;
    }






    public static void main(String[] args) {
        
    }
}
