import java.util.HashMap;
import java.util.HashSet;

public class day1 {
    
    static void largestSubarrayZeroSum(int arr[]){
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum=0;
        int len = 0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(map.containsKey(sum)){
                len = Math.max(len,i - map.get(sum));
            }else{
                map.put(sum, i);
            }
        }
        System.out.println(len);
    }
   
    static void countSubarrZeroSum(int arr[]){
        // 15 -2 2 -8 1 7 10 23]
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum=0, count=0;
        for(int i=0;i<arr.length;i++){
            sum = sum+arr[i];
            if(map.containsKey(sum)){
                count+=map.get(sum);
                map.put(sum, map.get(sum)+1);
            }else{
                map.put(sum, 1);
            }
        }
        System.out.println(count);
    }

    static void equalZeroOneMaxLen(int arr[]){
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum =0, len=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0)
                sum-=1;
            else
                sum+=1;
            if(sum==0){
                map.put(0, 0);
            }
            else if(map.containsKey(sum)){
                len = Math.max(len, i-map.get(sum));
            }else{
                map.put(sum, i);
            }
        }
    }

    static void subArrWithEqualZeroOne(int arr[]){
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0, count=0;
        for(int i=0;i<arr.length;i++){
            sum = (arr[i]==0) ? sum-1 : sum+1;
            count = map.containsKey(sum) ? count+1: count;
        }
        System.out.println(count);
    }

    public static int countOfSubarrayWithEqualZeroOne(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum=0, count=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0)
                sum-=1;
            else
                sum+=1;

            if(map.containsKey(sum)){
                count+=map.get(sum);
                map.put(sum, map.get(sum)+1);
            }else{
                map.put(sum, 1);
            }
        }

        return count;
    }
   
   static void LongestSubarrayWithZeroOneTwo(int arr[]){
        HashMap<String, Integer> map = new HashMap<>();
        int c0=0, c1=0, c2=0;
        map.put("0#0", 0);
        int len = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0)
                c0++;
            else if(arr[i]==1)
                c1++;
            else 
                c2++;
            String key = (c1-c0)+"#"+(c2-c1);
            if(map.containsKey(key)){
                len = Math.max(len, i-map.get(key));
            }else{
                map.put(key, i);
            }
        }
        System.out.println(len);
    }
   
   
   
   
    public static void main(String[] args) {
        
    }
}
