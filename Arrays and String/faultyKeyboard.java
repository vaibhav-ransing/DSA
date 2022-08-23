public class faultyKeyboard{


    public boolean isLongPressedName(String name, String typed) {
        int i=0, j=0;
        boolean ans = true;
        while(i<name.length() && j<typed.length()){
            char ci = name.charAt(i);
            char cj = typed.charAt(j);
            if(ci==cj){
                i++; j++;
            }else{

                if(j!=0 && typed.charAt(j-1)==cj){
                    j++;
                }else{  
                    ans = false;
                    break;
                }
            }
        }
        while(j<typed.length()){
            if(typed.charAt(j-1)!=typed.charAt(j)){
                ans = false;
                break;
            }
            j++;
        }
        if(i!=name.length()){
            ans =false;
        }
        return ans; 
    }


    public static void main(String[] args) {

    }
}