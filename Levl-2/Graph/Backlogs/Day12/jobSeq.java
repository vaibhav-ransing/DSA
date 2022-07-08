import java.util.Arrays;

public class jobSeq {
    class Job {
        int id, profit, deadline;
        Job(int x, int y, int z){
            this.id = x;
            this.deadline = y;
            this.profit = z; 
        }
    }

    static int parent[];
    static int[] JobScheduling(Job arr[], int n){

        Arrays.sort(arr, (a,b)->{
            return b.profit - a.profit;
        });
        parent = new int[101];
        for(int i=0; i<parent.length; i++){
            parent[i]=i;
        }
        int count=0;
        int profit=0;
        for(Job job: arr){
            int lx = find(job.deadline);
            if(lx>0){
                count+=1;
                profit+=job.profit;
                parent[lx] = find(lx-1);
            }
        }
        return new int[] {count,profit};
    }
    static int find(int x){
        if(parent[x]==x){
            return x;
        }else{
            int temp = find(parent[x]);
            parent[x] = temp;
            return temp;
        }
    }

}
