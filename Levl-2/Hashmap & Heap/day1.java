import java.util.HashMap;

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

    public static void main(String[] args) {
        
    }
}
