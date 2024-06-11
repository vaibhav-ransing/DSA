import java.util.Arrays;
import java.util.PriorityQueue;

public class SingleThreadCPU {

    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[][] sortedTasks = new int[n][3];
        // Since the index is asked in the answer so we create a sorted array which contains start time idx
        for (int i = 0; i < n; i++) {
            sortedTasks[i][0] = tasks[i][0]; // enqueueTime
            sortedTasks[i][1] = tasks[i][1]; // processingTime
            sortedTasks[i][2] = i;           // original index
        }

        // Sort by enqueueTime, if tie by processingTime, if tie by original index
        Arrays.sort(sortedTasks, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else if (a[1] != b[1]) {
                return a[1] - b[1];
            } else {
                return a[2] - b[2];
            }
        });

        // for sortedTask = [start, execution_time, idx]
        // we sort based on minimum exection_time 
            // if exectution_time is same then sort based on idx.
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] != b[1]) {
                return a[1] - b[1];
            } else {
                return a[2] - b[2];
            }
        });

        int[] result = new int[n];
        int timePassed = 0;
        int taskIndex = 0;
        int resultIndex = 0;

        // we want to fill our result array and resultIndex runs on it 
        // So we run the loop till all the values in result array are not filled.
        while (resultIndex < n) {
            
            // everytime check if the timePassed as crosse the starting element of next task
                // if so then keep adding them in queue.
            while(taskIndex < n && sortedTasks[taskIndex][0] <= timePassed){
                pq.add(sortedTasks[taskIndex++]);
            }

            // check the size get the top element
            // result will contain the currentTask idx, add currentTask[2] to result array
            // Now currentTask takes x time to execute to total time passed  = x + timePassed.
            if(pq.size() > 0){
                int[] currTask = pq.remove();
                timePassed += currTask[1];
                result[resultIndex++] = currTask[2];
            // if pq is empty means timePassed is not enough 
            // we must go to the starting time of next task 
            }else if(taskIndex < n){
                timePassed = sortedTasks[taskIndex][0];
            }
        }
        return result;
    }

}
