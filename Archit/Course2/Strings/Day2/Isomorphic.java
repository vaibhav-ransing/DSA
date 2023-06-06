package Course2.Strings.Day2;

public class Isomorphic {
    

    class Solution {
        
        public static boolean isMapped(String s, String t){
            if (s.length() != t.length()) {
                return false;
            }
            
            Character[] arr = new Character[26];
        
            for (int i = 0; i < s.length(); i++) {
                char c1 = s.charAt(i);
                char c2 = t.charAt(i);
                
                if ((arr[c1 - 'a'] != null) && (arr[c1 - 'a'] != c2) ){
                    return false;
                } else {
                    arr[c1 - 'a'] = c2;
                }
            }
            return true;
        }
        public static boolean isIsomorphic(String s, String t) {
            return (isMapped(s, t) && isMapped(t, s));
        }
        
        public static void main(String[] args) {
            System.out.println(isIsomorphic("egg", "add"));
        }
    }

}
