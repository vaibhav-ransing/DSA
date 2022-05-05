import java.util.HashSet;

public class wordBreak1 {
    
    public static void wordBreak(String str, String ans, HashSet<String> dict){
        if(str.length()==0){
            System.out.println(ans);
            return;
        }
        
        for(int i=0; i<str.length(); i++){
            String temp = str.substring(0, i+1);
            if(dict.contains(temp)){
                wordBreak(str.substring(i+1), ans+temp+" ", dict);
            }
        }
	}

    public static void main(String[] args) {
        
    }
}
