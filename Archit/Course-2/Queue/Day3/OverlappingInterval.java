package Day3;

import java.util.ArrayList;
import java.util.Arrays;

public class OverlappingInterval {
    
    public static class Pair{
        int start;
        int end;
        Pair(int start , int end){
            this.start = start;
            this.end = end;
        }
    }
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->{
            return a[0] - b[0];
        });
        ArrayList<Pair> list = new ArrayList<>();

        list.add(new Pair(intervals[0][0], intervals[0][1]));
        for(int i=1; i<intervals.length; i++){
            int start = intervals[i][0];
            int end = intervals[i][1];

            if(list.get(list.size()-1).end < start){
                list.add(new Pair(start, end));
            }else{
                list.get(list.size()-1).end = Math.max(list.get(list.size()-1).end, end);
            }
        }
        int ans[][] = new int[list.size()][2];
        for(int i=0; i<list.size(); i++){
            Pair p = list.get(i);
            int temp[] = {p.start, p.end};
            ans[i] = temp;
        }
        return ans;
    }

    public static int[][] merge2(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->{
            return a[0] - b[0];
        });
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(intervals[0][0]);
        temp.add(intervals[0][1]);

        list.add(temp);

        for(int i=1; i<intervals.length; i++){
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];
            int prevEnd = list.get(list.size()-1).get(1);

            if(currStart > prevEnd){
                ArrayList<Integer> currTemp = new ArrayList<>();
                currTemp.add(currStart);
                currTemp.add(currEnd);
                list.add(currTemp);
            }else{
                list.get(list.size()-1).add(1, Math.max(currEnd, prevEnd));
            }
        }
        System.out.println(list);
        return intervals;
    }

    public static void main(String[] args) {
        int arr[][] = {{1,3}, {2,6}, {8,10}};
        merge(arr);
    }
}
