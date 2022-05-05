public class permutation {
    
    static void soln(String s, String ans){
        if(s.length()==0){
            if(isPalindrome(ans))
                System.out.println(ans);
            return;
        }
        if(isPalindrome(ans))
            System.out.println(ans);

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            String left = s.substring(0, i);
            String right = s.substring(i+1,s.length());
            soln(left+right, ans+ch);
        }
    }
    static void partition(String s, String ans, int i){
        if(isPalindrome(ans)){
            System.out.println(ans);
        }
        if(i==s.length())
            return;

        partition(s, ans+s.charAt(i), i+1);
        partition(s, ans, i+1);
    }
    static boolean isPalindrome(String asf){
        int i=0;
        int j = asf.length()-1;
        while(i<j){
            if(asf.charAt(i)!=asf.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        // soln("pep", "");
        partition("pep", "", 0);
    }
}
