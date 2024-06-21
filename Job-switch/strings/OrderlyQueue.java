import java.util.Arrays;
import java.util.HashMap;

public class OrderlyQueue {
    public static String orderlyQueue(String s, int k) {
        if (k > 1) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            return new String(arr);
        }

        String res = s;
        for(int i=0; i<=s.length(); i++){
            String rotate = s.substring(i) + s.substring(0, i);
            if(rotate.compareTo(res) < 0){
                res = rotate;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println((int) 'a');
        System.out.println((int) 'Z');
    }
}
