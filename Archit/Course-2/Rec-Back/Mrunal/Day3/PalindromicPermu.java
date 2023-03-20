import java.util.Arrays;

public class PalindromicPermu {
    

    public static void solution(String str, int idx, boolean[] used, String asf){
        if(idx==str.length()){
            System.out.println(asf);
            return;
        }
        // aabb
        for(int i=0; i<str.length(); i++){
            if(used[i]==false){
                used[i] = true;
                solution(str, idx+1, used, asf+str.charAt(i));
                used[i] = false;
            }
        }   
    }



    public static void sortArray(int[] arr){
        // 4, 2, 7, 1, 5
        Arrays.sort(arr);
    }

    public static void main(String[] args) {
        // solution("abca", 0, new boolean[4], "");
        int[] a = new int[3];
        System.out.println();
    }
}
