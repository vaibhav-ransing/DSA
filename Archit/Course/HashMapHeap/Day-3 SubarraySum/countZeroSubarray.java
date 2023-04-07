import java.util.HashMap;

public class countZeroSubarray {

    public void solution(int[] arr){
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0, sum=0;
        for(int val: arr){
            sum+=val;
            if(map.containsKey(sum)){
                count += map.get(val);
                map.put(val, map.get(val)+1);
            }else{
                map.put(val, 1);
            }
        }
        System.out.println(count);
    }
}
