public class toggle {
    
    static void tc(String str){
        StringBuilder s = new StringBuilder(str);
        StringBuilder ans = new StringBuilder();
        
        
        for(int i=0; i<s.length();i++){
            if(s.charAt(i)>=97){
                Character lc = (char)(s.charAt(i)-'a'+'A');
                ans.append(lc);
            }else{
                Character uc = (char)(s.charAt(i)+'a'-'A');
                ans.append(uc);
            } 
        }
        System.out.println(ans);
    
    }


    public static void main(String[] args) {
        
        String str = "cepCODinG";

        tc(str);

    }
}
