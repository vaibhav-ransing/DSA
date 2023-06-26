package Arrays.Day2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PartitionLables {
    

    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            map.put(s.charAt(i), i);
        }
        ArrayList<Integer> list = new ArrayList<>();
        int max = -1;
        int prev = 0;
        for(int i=0; i<s.length(); i++){
            int lastOcc = map.get(s.charAt(i));
            max = Math.max(max, lastOcc);
            if(i==max){
                max = -1;
                list.add(i - prev);
                prev = i;
            }   
        }
        return list;
    }
}