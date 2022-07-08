import java.util.ArrayDeque;
import java.util.HashSet;

public class kSimilarString854 {
    

    static class pair{
        String s;
        int lev;
        int idx;
        pair(String s, int lev, int idx){
            this.s = s;
            this.lev = lev;
            this.idx = idx;
        }
    }
    public static int kSimilarity(String s1, String s2) {
        pair p = new pair(s1, 0,0);
        ArrayDeque<pair> queue = new ArrayDeque<>();
        queue.add(p);
        HashSet<String> set = new HashSet<>();
        int ans = 0;
        while(queue.size()>0){
            pair peek = queue.pop();
            System.out.println(peek.s+" "+s2+"----");
            if(set.contains(peek.s)){
                continue;
            }
            if(peek.s==s2){
                ans = peek.lev;
                break;
            }
            set.add(peek.s);
            for(int i=peek.idx; i<s1.length(); i++){
                if(peek.s.charAt(i)!=s2.charAt(i)){
                    System.out.println(peek.s.charAt(i)+" "+s2.charAt(i));
                    int nbrChar = peek.s.charAt(i);
                    for(int j=i; j<s2.length(); j++){
                        if(peek.s.charAt(j)==nbrChar){
                            String tmpString = swap(peek.s, i, j);
                            System.out.println(tmpString);
                            pair tp = new pair(tmpString, peek.lev+1, i+1);
                            queue.add(tp);
                        }
                    }
                }
            }
        }
        return ans;
    }
    static String swap(String s, int i, int j){
        char[] arr = s.toCharArray();
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return new String (arr);
    }



    public static void main(String[] args) {
        System.out.println(kSimilarity("ab", "ba"));
        // System.out.println(swap("acbv", 0, 2));
    }
}
