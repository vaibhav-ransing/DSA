import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import javax.print.event.PrintEvent;

public class practive {
    
    public static void maxFrequencyCharacter(String s){
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            }else
                map.put(s.charAt(i),1);
        }
        int max = 0;
        char c= '\0';
        for (Map.Entry<Character, Integer> set : map.entrySet()){
            // System.out.println(set.getKey()+" "+ set.getValue());
            if(set.getValue()>max){
                c = set.getKey();
                max = set.getValue();
            }
        }
        System.out.println(c);
    }

    public static void getCommonElements(int arr[], int arr2[]){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i])){
                map.replace(arr[i], map.get(arr[i])+1);
            }else 
                map.put(arr[i], 1);
        }
        for(int i=0;i<arr2.length;i++){
            if(map.containsKey(arr2[i]) ){
                System.out.print(arr2[i]+" ");
                int val = map.get(arr2[i])-1;
                if(val>0)
                    map.put(arr2[i], val);
                else
                    map.remove(arr2[i]);
                
            }
        }
    }

    public static void longestConsequtiveElments(int arr[]){
        HashMap<Integer , Boolean> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i], true);
        }
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i]-1))
                map.replace(arr[i], false);
        }
        int maxStart = 0;
        int maxLen = 0;
        for(int i=0;i<arr.length;i++){
            int val = arr[i]+1;
            int len = 1;
            if(map.get(arr[i])){
                while(map.containsKey(val)){
                    len++;
                    val++;
                }
            }
            if(len>maxLen){
                maxStart = arr[i];
                maxLen = len;
            }
        }
        // System.out.println(maxStart);
        // System.out.println(maxLen);
        for(int i=0; i<maxLen;i++){
            System.out.println(maxStart+i);
        }

    }

    public static void kLargestElements(int arr[], int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<arr.length;i++){
            if(pq.size()<k){
                pq.add(arr[i]);
            }else{
                if(pq.peek() < arr[i]){
                    pq.remove();
                    pq.add(arr[i]);
                }
            }
        }
        for(int i=0;i<k;i++){
            System.out.println(pq.peek());
            pq.remove();
        }
    }

    public static void main(String[] args) {
        int arr[] = { 1,2,3,6,7,8,9,10,11,12};
        kLargestElements(arr, 3);
    }
}
