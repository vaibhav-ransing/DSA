package First20;

import java.util.HashSet;

public class RemoveInvalidParanthesis {
    
    public static int getMin(String s){
        int insideCount = 0;
        int count = 0;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                insideCount++;
            }else{
                if(insideCount == 0){
                    count++;
                }else{
                    insideCount -= 1;
                }
            }
        }
        return count;
    }

    public static void distinctValidParanthesis(String str, int idx, int minRemoval, HashSet<String> set){
        if(minRemoval == 0 || idx == str.length()){
            if(getMin(str)==0){
                if(!set.contains(str))
                    System.out.println(str);
                set.add(str);
            }
            return;
        }
        distinctValidParanthesis(str, idx+1, minRemoval, set);
        distinctValidParanthesis(str.substring(0, idx)+str.substring(idx+1), idx, minRemoval - 1, set);
    }

    public static void main(String[] args) {
        System.out.println(getMin("()())()"));
        distinctValidParanthesis("()())()", 0, getMin("()())()"), new HashSet<>());
    }
}
