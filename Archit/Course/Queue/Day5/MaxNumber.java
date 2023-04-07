import java.util.PriorityQueue;

public class MaxNumber {
    

    public String largestNumber(int[] nums) {
        PriorityQueue<String> queue = new PriorityQueue<>( (a,b) ->{
            return (b+a).compareTo(a+b);
        });
        
        for(int val: nums){
            queue.add(Integer.toString(val));
        }
        StringBuilder sb = new StringBuilder();
        while(queue.size()>0){
            sb.append(queue.remove());
        }
        
        if(sb.charAt(0)=='0') return "0";
        return sb.reverse().toString();
    }
}
