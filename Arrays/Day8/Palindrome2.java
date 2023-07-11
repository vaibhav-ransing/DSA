package Day8;

public class Palindrome2 {

    public boolean validPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        
        while (left <= right) {
            char lc = s.charAt(left);
            char rc = s.charAt(right);
            if (lc == rc) {
                left++;
                right--;
            }else{
                boolean iSkip = palindome(s, left+1, right);
                boolean jSkip = palindome(s, left, right-1);

                return (jSkip | iSkip);
            }
        }
        return true;
    }

    public boolean palindome(String s, int i, int j){
        while(i <= j){
            char left = s.charAt(i);
            char right = s.charAt(j);
            if(left != right) return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {

    }

}
