import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;

public class day10 {
    

    class RandomPickwithBlacklist {

        HashMap<Integer, Integer> map;
        Random r;
        int top;
        public RandomPickwithBlacklist(int n, int[] blacklist) {
            map = new HashMap<>();
            r = new Random();
            top = n-blacklist.length;

            HashSet<Integer> set = new HashSet<>();
            for(int i=0;i<blacklist.length;i++)
                set.add(blacklist[i]);
            n--;

            for(int val: blacklist){
                if(val<top){
                    while(set.contains(n)){
                        n--;
                    }
                    map.put(val, n--);
                }
            }
        }
        
        public int pick() {
            int index = (int)((Math.random() * (top - 0)) + 0);
            if(map.containsKey(index)){
                return map.get(index);
            }else
                return index;
        }
    }

    public static List<List<Integer>> getSkyline(int[][] buildings) {
            // leetcode 218
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int arr[][] = new int[2*buildings.length][2];
        
        for(int i=0;i<buildings.length;i++){
            int rect[] = buildings[i];
            int start = rect[0];
            int end = rect[1];
            int height = rect[2];
            int inc[] = new int[2];
            int dec[] = new int[2];
            // System.out.println("->  "+start+" "+end+" "+ height);
            inc[0] = start;
            inc[1] = -height;
            dec[0] = end;
            dec[1] = height;
            arr[i+1] = inc;
            arr[i] = dec;
            // System.out.println("->> "+arr[i+1][0]+" "+arr[i+1][1]);
        }
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i][0]+" "+arr[i][1]);
        }
            
        return null;
    }

    static void soln(int arr[][]){
        HashMap<Integer, Integer> xmap = new HashMap<>();
        HashMap<Integer, Integer> ymap = new HashMap<>();
        HashMap<String, Integer> xymap = new HashMap<>();
        // x1==x2 or y1==y2
    
        int count= 0;
        for(int i=0;i<arr.length;i++){
            int x = arr[i][0];
            int y = arr[i][1];
            count+= xmap.getOrDefault(x, 0);
            xmap.put(x, xmap.getOrDefault(x, 0)+1);

            count+= ymap.getOrDefault(y, 0);
            ymap.put(y, ymap.getOrDefault(y, 0)+1);
            String key = x+"*"+y;
            if(xymap.containsKey(key)){
                count-= xymap.get(key);
            }
            xymap.put(key, xymap.getOrDefault(key, 0)+1);
        }

    }

    public static int numOfPairsNonCoincidingPoint(int[] X, int[] Y, int N) {
        //Code Here
        int count = 0;
        HashMap<Integer, Integer> xmap = new HashMap<>();
        HashMap<Integer, Integer> ymap = new HashMap<>();
        HashMap<String, Integer> xymap = new HashMap<>();

        for(int i=0;i<X.length;i++){
            int x = X[i];
            int y = Y[i];
            count+= xmap.getOrDefault(x, 0);
            xmap.put(x, xmap.getOrDefault(x, 0)+1);

            count+= ymap.getOrDefault(y, 0);
            ymap.put(y, ymap.getOrDefault(y, 0)+1);

            String key = x+"*"+y;
            count-= xymap.getOrDefault(key, 0);
            xymap.put(key, xymap.getOrDefault(key, 0)+1);
        }


        return count;
    
    }

    public static boolean pairWithEqualSUm(int arr[]){
        HashSet<Integer>set = new HashSet<>();
        int index=-1;
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                int sum = arr[i]+arr[j];
                index = j+1;
                while(index<arr.length){
                    if(set.contains(arr[index]))
                        return true;
                    set.add(sum-arr[index]);
                    index++;
                }
                set = new HashSet<>();
            }
        }
        return false;
    }

    
    public static void main(String[] args) {
        int bul[][] = {
            {1,2,15},
            {3,4,10}
        };
        getSkyline(bul);
    

    }
}
