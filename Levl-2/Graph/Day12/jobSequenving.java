import java.util.Arrays;

public class jobSequenving {
    // https://practice.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1

    static class Job{
        int id;
        int profit;
        int deadline;
    }
    // sort karde and then jo job jitna late execute ho sakta hai kardo
    
    static int[] JobScheduling(Job arr[], int n){
        // Your code here
        Arrays.sort(arr ,(a,b)->{
            return b.profit-a.profit;
        });
        parent = new int[101];
        for(int i=0; i<parent.length; i++){
            parent[i]=i;    
        }
        int ans=0;
        int count = 0;
        for(Job job: arr){
            int lx = find(job.deadline);
            if(lx>0){
                count++;
                ans+=job.profit;
                parent[lx] = find(lx-1); 
            }
        }
        
        int ret[] ={count, ans};
        return ret;
    }
    static int parent[];
    static int find(int x){
        if(parent[x]==x){
            return x;
        }else{
            int temp = find(parent[x]);
            parent[x] = temp;
            return temp;
        }
    }
    public static void main(String[] args) {
        
    }
}
