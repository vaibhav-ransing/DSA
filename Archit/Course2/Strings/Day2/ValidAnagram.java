package Course2.Strings.Day2;

public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        int[] arr1 = new int[26];
        for (char ch : s.toCharArray()) {
            arr1[ch - '0']++;
        }
        for (char ch : t.toCharArray()) {
            arr1[ch - '0']--;
        }
        for(int val : arr1){
            if(val!=0) return false;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
