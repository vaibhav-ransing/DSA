import java.util.HashMap;

public class subArrayType {
    
    static void countSubarrWithEqualZeroAndOne(int arr[]){
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum=0;
        int count = 0;
        for(int val: arr){
            if(val==0){
                sum+=-1;
            }else{
                sum+=1;
            }
            if(map.containsKey(sum)){
                count+= map.get(sum);
                map.put(sum , map.get(sum)+1);
            }else
                map.put(sum , 1);
        }
        System.out.println(count);
    }

    static void longestZeroOne(int arr[]){
        HashMap<Integer, Integer> map = new HashMap<>();
    }

    static void countSubarrWithEqualZeroOneTwo(int arr[]){
        HashMap<String, Integer> map = new HashMap<>();
        map.put("0#0", 1);
        int count=0;
        int c0=0;
        int c1=0;
        int c2=0;
        // key   (c1-c0)#(c2-c1)
        for(int val: arr){
            if(val==0){
                c0++;
            }else if(val==1){
                c1++;
            }else if(val==2){
                c2++;
            }
            String key = (c1-c0)+"#"+(c2-c1);
            if(map.containsKey(key)){
                count+= map.get(key);
                map.put(key, map.get(key)+1);
            }else{
                map.put(key, 1);
            }
        }
        System.out.println(count);
    }


    public static void main(String[] args) {
    }
}
