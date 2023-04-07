import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class MaxArea {
    

    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        PriorityQueue<Long> pqHoriz = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<=horizontalCuts.length; i++){
            if(i==0){
                pqHoriz.add((long)horizontalCuts[i]);
            }else if(i==horizontalCuts.length){
                pqHoriz.add((long)(h - horizontalCuts[i-1]));
            }else{
                pqHoriz.add((long)(horizontalCuts[i]-horizontalCuts[i-1]));
            }
        }
        
        PriorityQueue<Long> pqVert = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<=verticalCuts.length; i++){
            if(i==0){
                pqVert.add((long)(verticalCuts[i]));
            }else if(i==verticalCuts.length){
                pqVert.add((long)(w - verticalCuts[i-1]));
            }else{
                pqVert.add((long)(verticalCuts[i]-verticalCuts[i-1]));
            }
        }

        return (int)((pqHoriz.peek()*pqVert.peek())%1000000007) ;
    }
}
