package Day6;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class partition763{

    public List<Integer> partitionLabels(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            map.put(ch, i);
        }
        int s=0; 
        int e=map.get(str.charAt(0));
        for(int i=s; i<str.length(); i++){
            char ch = str.charAt(i);
            int right = map.get(ch);
            e=right>e? right:e;
            if(i==e){
                ans.add(e-s);
                e=-1;
                s=i+1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        
    }


}