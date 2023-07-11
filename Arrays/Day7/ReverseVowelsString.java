package Day7;

import java.util.HashSet;

public class ReverseVowelsString {

    public String reverseVowels(String s) {
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        HashSet<Character> set = new HashSet<>();
        for(char ch : vowels){
            set.add(ch);
        }
        char[] arr = s.toCharArray();
        int left = 0, right = s.length() - 1;
        while(left < right){
            char leftChar = arr[left];
            char rightChar = arr[right];

            if(set.contains(leftChar) && set.contains(rightChar)){
                arr[right] = leftChar;
                arr[left] = rightChar;
            }else if(set.contains(leftChar)){
                right--;
            }else{
                left++;
            }
        }

        return new String(arr);
    }

    public static void main(String[] args) {
        
    }
}
