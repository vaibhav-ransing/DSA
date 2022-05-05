import java.util.HashMap;

public class palindrome {
    


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

    public static void generatepw(int cs, int ts, HashMap<Character, 
                                    Integer> fmap, Character oddc, String asf) {
        
        if(cs>ts){
            String rev = "";
            for(int i=asf.length()-1; i>=0;i--){
                rev+=asf.charAt(i);
            }
            if(oddc!=null){
                asf+= oddc+rev;
            }else{
                asf+=rev;
            }
            if(isPalindrome(asf))
                System.out.println(asf);
            return;
        }
        
        for(char ch: fmap.keySet()){
            int freq = fmap.get(ch);
            if(freq!=0){
                fmap.put(ch, freq-1);
                generatepw(cs+1, ts, fmap, oddc, asf+ch);
                fmap.put(ch, freq);
            }
            
        }

	}


    public static void palindromePartition(String s, String ans){
        if(s.length()==0){
            System.out.println(ans);
            return;
        }
        // System.out.println(s);
        for(int i=0; i<s.length(); i++){
            String temp = s.substring(0,i+1);
            String rem = s.substring(i+1);
            // System.out.println(temp+" "+rem);
            if(isPalindrome(temp))
                palindromePartition(rem,   ans+"("+temp+") ");
        }
    }

    public static void main(String[] args) {
        String s = "aabbc";
        HashMap<Character, Integer> fmap = new HashMap<>();
        Character oddc = null;
        int oddCount = 0;
        int len = 0;

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			fmap.put(ch, fmap.getOrDefault(ch, 0) + 1);
		}
        for(char ch: fmap.keySet()){
            if(fmap.get(ch)%2!=0){
                oddCount++;
                oddc = ch;
                if(oddCount>1){
                    return;
                }
            }
            len+= (fmap.get(ch)/2);
            fmap.put(ch, fmap.get(ch)/2);
           
        }
        // generatepw(1, len, fmap, oddc, "");
        palindromePartition("pepper",  "");
    }
}
