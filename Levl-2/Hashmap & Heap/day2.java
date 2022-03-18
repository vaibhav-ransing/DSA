import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class day2 {

    static boolean checkAPFun(int arr[]){
        int a1 = Integer.MAX_VALUE;
        int secMin = Integer.MAX_VALUE;
        HashSet<Integer> set = new HashSet<>();

        for(int i=0;i<arr.length;i++){
            set.add(arr[i]);
            if(arr[i]<a1){
                secMin = a1;
                a1 = arr[i];
            }else if(arr[i]<secMin){
                secMin = arr[i];
            }
        }
        int d = secMin - a1;
        
        for(int i=0;i<arr.length;i++){
            int val = a1 + i*d;
            if(set.contains(val)==false){
                System.out.println("val "+val);
                return false;
            }
        }
        return true;

    }

    static boolean checkDoubleOfEachElement(int arr[]){
        Arrays.sort(arr);
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0)
                continue;
            if(map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i])+1);
            }else{
                map.put(arr[i], 1);
            }
        }
        for(int i=0;i<arr.length;i++){
            int val = arr[i];
            if(map.containsKey(val)==false)
                continue;
            int valD = 2*val;
            if(map.containsKey(valD)){
                map.put(val, map.get(val)-1);
                map.put(valD, map.get(valD)-1);
                if(map.get(val)==0)
                    map.remove(val);
                if(map.get(valD)==0)
                    map.remove(valD);
            }
        }
        if(map.size()==0)
            return true;
        return false;

    }

    static void equalSplit(int arr[]){
        
    }

    public static void main(String[] args) {
        int arr[]  = {1, 2, 4, 4, 8, 16};
        System.out.println(checkDoubleOfEachElement(arr));
    }

}
