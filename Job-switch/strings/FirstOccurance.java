import java.util.HashSet;

public class FirstOccurance {

    public int strStr(String haystack, String needle) {

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    public boolean buddyStrings(String str, String goal) {
        if (str.length() != goal.length())
            return false;

        if(str.equals(goal)){
            HashSet<Character> set = new HashSet<>();
            for(char ch : str.toCharArray()){
                if(set.contains(ch)){
                    return true;
                }
                set.add(ch);
            }
            return false;
        }

        int count = 0;
        char pre1 = '\n';
        char pre2 = '\n';
        
        for (int i = 0; i < str.length(); i++) {
            char c1 = str.charAt(i);
            char c2 = goal.charAt(i);
            if(c1 != c2){
                count++;
                if(pre1 == '\n'){
                    pre1 = c1;  // a
                    pre2 = c2;  // b
                }else{
                    if(pre2 != c1 || pre1 != c2) return false;
                }
            }
        }
        return count == 2;
    }
}
