package Arrays.Day1;

public class LongPressed_LC925 {
    
    public boolean isLongPressedName(String name, String typed) {
        int i=0, j=0;
       
        while(i<name.length()){
            
            if(j==typed.length()) return false;

            if(name.charAt(i)==typed.charAt(j)){
                i++; 
                j++;
            }else if(name.charAt(i-1) == typed.charAt(j)){
                j++;
            }else{
                return false;
            }
        }
        for(int k=j; k<typed.length(); k++){
            if(typed.charAt(k) != name.charAt(name.length()-1))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        
    }
}
