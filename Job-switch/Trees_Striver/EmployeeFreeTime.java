import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class EmployeeFreeTime {

    static class Interval {
        int start;
        int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static ArrayList<Integer> findFreeIntervals(ArrayList<ArrayList<Integer>> schedules) {
        // write your code here.

        ArrayList<Integer> ans = new ArrayList<>();

        PriorityQueue<Interval> pq = new PriorityQueue<>((a, b) -> a.start - b.start);

        for(ArrayList<Integer> period : schedules){ 
            pq.add(new Interval(period.get(0), period.get(1)));
        }

        // Interval prev = new Interval(0, 0);  
        Interval prev = null;  

        while (pq.size() > 0) {
            Interval curr = pq.remove();
            if(prev != null && curr.start <= prev.end){   // curr : [1,3] ,  prev : [1,2]      _ _ _    _ _ 
                prev.start = Math.min(prev.start, curr.start); // this will never be true because pq is sorted on start index so prev will always have smaller start compare to curr
                prev.end = Math.max(prev.end, curr.end);
            } else{
                if(prev !=null){
                    ans.add(prev.start);
                    ans.add(curr.end - prev.end);

                }else{
                    ans.add(curr.start);
                    ans.add(curr.end);
                }

                prev = curr;
            }
            System.out.println(curr.start +" " + curr.end);
        }
        System.out.println(ans);
        return ans;
    }


    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> input = new ArrayList<>();
        input.add(new ArrayList<>(Arrays.asList(1, 2)));
        input.add(new ArrayList<>(Arrays.asList(5, 6)));
        input.add(new ArrayList<>(Arrays.asList(1, 3)));
        input.add(new ArrayList<>(Arrays.asList(4, 10)));
        
        findFreeIntervals(input);
    }
}
