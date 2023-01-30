package Monolitic_Stack;

public class RemoveDuplicate {
    
    public String removeDuplicateLetters(String s) {
        StringBuilder sb = new StringBuilder();
        char[] arr = s.toCharArray();
        int[] freq = new int[26];
        boolean[] visited = new boolean[26];
        for(char ch: arr){
            freq[ch-'a']++;
        }
        for(char ch: arr){
            freq[ch-'a']--;
            if(visited[ch-'a']) continue;
            visited[ch-'a'] = true;
            
            while(sb.length()>0){
                char top = sb.charAt(sb.length()-1);
                if(top>ch && freq[top-'a']>0){
                    sb.deleteCharAt(sb.length()-1);
                    visited[top-'a'] = false;
                }else{
                    break;
                }
            }
            sb.append(ch);
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        
    }
}
