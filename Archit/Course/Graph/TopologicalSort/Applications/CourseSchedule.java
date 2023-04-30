package Course.Graph.TopologicalSort.Applications;

import Course.Graph.Graph;

public class CourseSchedule{

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Graph graph = new Graph(numCourses);
        int[] incoming = new int[numCourses];
        for(int[] edge : prerequisites){
            graph.adj[edge[1]].add(edge[0]);
            incoming[edge[0]]++;
        }
    
        int[] topo = new int[numCourses];
        int pop = 0, push = 0;

        for(int i=0; i<numCourses; i++){
            if(incoming[i]==0){
                topo[push++] = i;
            }
        }
        while(pop < push){
            int src = topo[pop++];
            for(int nbr : graph.adj[src]){
                incoming[nbr]--;
                if(incoming[nbr] == 0){
                    topo[push++] = nbr;
                }
            }
        }
        //  if topoSort exists then return topo
        if(push == numCourses) return true;
        return false;
    }


    public static void main(String[] args) {
        
    }
}