import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class day11 {
    
    public static void minCostToConnectStick(int arr[]){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int val:arr){
            pq.add(val);
        }
        int cost=0;
        while(pq.size()>1){
            int t1 = pq.remove();
            int t2 = pq.remove();
            cost+=t1+t2;
            pq.add(t1+t2);
        }
        System.out.println(cost);
    }

    class SnapshotArray1 {

        ArrayList<ArrayList<Integer>> list;
        int last = 0;
        int len;
        public SnapshotArray1(int length) {
            list = new ArrayList<>();
            ArrayList<Integer> al = new ArrayList<>(length);
            list.add(al);
            len = length;
        }
        
        public void set(int index, int val) {
            ArrayList<Integer> al = list.get(last);
            al.add(index, val);
        }
        
        public int snap() {
            ArrayList<Integer> al = new ArrayList<>(len);
            for(int i=0;i<list.get(last).size(); i++){
                al.add(i, list.get(last).get(i));
            }
            list.add(al);
            last++;
            return last;
        }
        
        public int get(int index, int snap_id) {
            return list.get(snap_id).get(index);
        }
    }

    class SnapshotArray {

        HashMap<Integer, Integer> arr[];
        int snapIndex;
        public SnapshotArray(int length) {
            arr = new HashMap[length];
            for(int i=0;i<length;i++){
                HashMap<Integer, Integer> map = new HashMap<>();
                arr[i] = map;
            }
            snapIndex = 0;
        }
        
        public void set(int index, int val) {
            HashMap<Integer, Integer> map = arr[index];
            map.put(snapIndex, val);
        }   
        
        public int snap() {
            
            return snapIndex++;
        }
        
        public int get(int index, int snap_id) {
            
            HashMap<Integer, Integer> map = arr[index];
            for(int i=snap_id; i>=0;i--){
                int val =map.getOrDefault(snap_id, 0);  
                if(val!=0)
                    return val;
            }
            return 0;
        }
    }

    static void AvoidFloodInTheCity(int arr[]){
        HashSet<Integer> set = new HashSet<>();
        int ans[] = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){  
                for(int j=i+1; j<arr.length;j++){
                    if(set.contains(arr[j])){
                        ans[i] =  arr[j];
                        set.remove(arr[j]);
                        break;
                    }
                }
                if(ans[i]==0 && set.size()>0){
                   for(int lake: set){
                       ans[i] = lake;
                       set.remove(lake);
                       break;
                   }
                }
            }else{
                if(set.contains(arr[i])){
                    System.out.println("Bhago baad aai");
                    return;
                }
                set.add(arr[i]);
                ans[i] = -1;
            }
        }
        for(int i=0;i<ans.length;i++)
            System.out.print(ans[i]+" ");
    }

    static void AvoidFloodInTheCityBetter(int arr[]){
        HashMap<Integer, Integer> map= new HashMap<>();
        TreeSet<Integer> ts = new TreeSet<>();
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
                
            }else{
                if(map.containsKey(arr[i])){
                    System.out.println("Flodeedd");
                    return;
                }
                map.put(arr[i], i);
            }
        }
    }

    public static void main(String[] args) {
        // int arr[] = {2,4,3};
        // minCostToConnectStick(arr);
        int arr[] = {1,2,0,0,2,1};
        AvoidFloodInTheCity(arr);
    }
}
