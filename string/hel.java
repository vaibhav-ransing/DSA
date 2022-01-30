import java.util.HashMap;

class x{


    static void ans(String s){
        HashMap<Character, Integer> h = new HashMap<>();

        for(int i=0; i<s.length();i++){
            if(!h.containsKey(s.charAt(i))){
                h.put(s.charAt(i), 1);
            }
            else{
                h.replace(s.charAt(i), h.get(s.charAt(i)), h.get(s.charAt(i))+1);
            }
            
        }
        // for(int j= 0; j<h.size();j++){
            System.out.println(h.get('b'));
            // }

    }

    public static void main(String[] args) {
        
        // String s = "aaabbcccdee";
        // ans(s);
        int x = 10;
        String s= "abc";
        s = s+10;
        System.out.println(s);
        
    }
}