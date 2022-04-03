import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class day12 {
    
    static void minFulingGasStation(int arr[][], int targ, int startFuel){
        // [ [10,60], [20,30], [30,30], [60,40] ]
        // sf = 10, tar=100

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int fuel=startFuel;
        int  i=0, count=0;
        while(true){
            while(i<arr.length && arr[i][0]<=fuel ){
                pq.add(arr[i][1]);
                i++;
            }
            if(pq.size()==0){
                count = -1;
                break;
            }
            fuel+= pq.remove();
            count++;
            if(fuel>=targ)
                break;
        }
        System.out.println(count);
    }
    // one last TC
    // start = 10, targ = 100
    // 10(40) 20(10) 40(10) 60(50) 

    public static boolean lineReflection(int arr[][]){
        HashSet<String> set = new HashSet<>();

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            min = Math.min(min, arr[i][0]);
            max = Math.max(max, arr[i][0]);

            String key = arr[i][0]+"*"+arr[i][1];
            set.add(key);
        }
        if((min+max)%2==1)
            return false;
        int mid = (min+max)/2;

        for(int i=0;i<arr.length;i++){
            int x =  arr[i][0];
            int y =  arr[i][1];
            int mirrorX = 2*mid - x;
            String key = mirrorX+"*"+y;
            if(set.contains(key)==false)
                return false;
        }

        return true;
    }

    static class pair implements Comparable<pair> {
        char ch;
        int freq;
        pair(char ch, int freq){
            this.ch = ch;
            this.freq =freq;
        }
        public int compareTo(pair o){
            return this.freq- o.freq;
        }
    }

    static void reArangeString(String s){
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        PriorityQueue<pair> pq = new PriorityQueue<>();
        for(char key: map.keySet()){
            pair p = new pair(key, map.get(key));
        }

        String ans="";
        
    }


    public static void main(String[] args) {
        // int arr[][] = {{10,60}, {20,30}, {30,30}, {60,40}};
        // minFulingGasStation(arr, 100, 10);
        // reArangeString("aabcc");
    }
}
