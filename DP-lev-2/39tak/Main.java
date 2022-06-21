import java.util.*;

public class Main{

    // public static long getMinimumCost(List<Integer> arr){
    //     int maxIndex = -1;
    //     int max=Integer.MIN_VALUE;
    //     for(int i=0; i<arr.size(); i++){
    //         if(arr.get(i)>max){
    //             maxIndex=i;
    //             max = arr.get(i);
    //         }
    //     }
    //     long ans = Integer.MAX_VALUE;
        
    //     if(maxIndex!=0){
    //         int l = arr.get(maxIndex-1);
    //         int mid = (l+arr.get(maxIndex))/2;
    //         arr.add(maxIndex, mid);
    //         ans = getVal(arr); 
    //         arr.remove(maxIndex);
    //     }
        
    //     if(maxIndex!=arr.size()-1){
    //         int r = arr.get(maxIndex+1);
    //         int mid = (r+arr.get(maxIndex))/2;
    //         arr.add(maxIndex+1, mid);
    //         ans = Math.min(ans, getVal(arr));
    //         arr.remove(maxIndex+1);
    //     }
        

    //     return ans;
    // }

    public static long getMinimumCost(List<Integer> arr){
        int maxIndex = -1;
        int max=Integer.MIN_VALUE;
        for(int i=0; i<arr.size(); i++){
            if(arr.get(i)>max){
                maxIndex=i;
                max = arr.get(i);
            }
        }

        long ans = Integer.MAX_VALUE;
        
        if(maxIndex!=0){
            int l = arr.get(maxIndex-1);
            int mid = (l+arr.get(maxIndex))/2;
            arr.add(maxIndex, mid);
            ans = getVal(arr);
            arr.remove(maxIndex);
        }
        
        if(maxIndex!=arr.size()-1){
            int r = arr.get(maxIndex+1);
            int mid = (r+arr.get(maxIndex))/2;
            arr.add(maxIndex+1, mid);
            ans = Math.min(ans, getVal(arr));
            arr.remove(maxIndex+1);
        }
        

        return ans;
    }
    public static long getVal(List<Integer> arr){
        long ans = 0;
       
        for(int i=1; i<arr.size(); i++){
            int l = arr.get(i-1);
            int r = arr.get(i);
            long v = (long) Math.pow(l-r, 2);
            ans+=v;
        }
        return ans;
    }

    // public static long getVal(List<Integer> arr){
    //     long ans = 0;
       
    //     for(int i=1; i<arr.size(); i++){
    //         int l = arr.get(i-1);
    //         int r = arr.get(i);
    //         long v = (long) Math.pow(l-r, 2);
    //         ans+=v;
    //     }
    //     return ans;
    // } 
    

    public static void main(String[] args){
        //write your code here
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(5);
        list.add(2);
        list.add(10);

        System.out.println(getMinimumCost(list));
        // list.add(1, 5);
        // list.remove(2);
        // for(int val: list){
        //     System.out.println(val);
        // }
    }
}