import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class courseSchedule {
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        for(int i=0; i<numCourses; i++){
            graph[i] = new ArrayList<>();
        }
        for(int x[]: prerequisites){
            int par = x[0];
            int nbr = x[1];
            graph[par].add(nbr);
        }
        int[] degree = new int[numCourses];
        for(int i=0 ;i<numCourses; i++){
            for(int nbr: graph[i]){
                degree[nbr]++;
            }
        }
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for(int i=0; i<numCourses; i++){
            if(degree[i]==0){
                System.out.println("hello");
                queue.add(i);
            }
        }
        int idx = 0;
        int ans[] = new int[numCourses];
        while(queue.size()>0){
            int v = queue.remove();
            ans[idx++] = v;
            for(int nbr: graph[v]){
                degree[nbr]--;
                if(degree[nbr]==0){
                    queue.add(nbr);
                }
            } 
        }
        if(idx<numCourses) return new int[numCourses];
        int l=0; 
        int r = ans.length-1;
        while(l<r){
            int temp = ans[l];
            ans[l] = ans[r];
            ans[r] = temp;
        }
        return ans;
        
    }

    public static void main(String[] args) {
        
    }
}
