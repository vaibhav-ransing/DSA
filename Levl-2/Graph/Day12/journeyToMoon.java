import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class journeyToMoon {
    

    static int parent[];
    static int rank[];

    public static int journeyToMoon(int n, List<List<Integer>> astronaut) {
        
        parent = new int[n];
        rank = new int[n];
        for(int i=0; i<n; i++){
            parent[i]=i;
        }
        for(int i=0; i<astronaut.size(); i++){
            int lx = find(astronaut.get(i).get(0));
            int ly = find(astronaut.get(i).get(1));
            if(lx!=ly){
                union(lx, ly);
            }
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int p: parent){
            // map.put(p, map.getOrDefault(p, 0)+1);
            int l = find(p);
            map.put(l, map.getOrDefault(l, 0)+1);
        }
        int ans=1;
        int[] temp = new int[map.size()];
        int i=0;
        for(int val: map.values()){
            temp[i++]= val;
        }
        for(int m=0; m<temp.length;m++){
            for(int j=m+1; j<temp.length; j++){
                int val = temp[m]*temp[j];
                ans+=val;
            }
        }
        return ans;
    }
    
    static void union(int x, int y){
        if(rank[x] > rank[y]){
            parent[y] = x;
        }else if(rank[x] < rank[y]){
            parent[x] = y;
        }else{
            parent[y] = x;
            rank[x]++;
        }
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



    public static void main(String[] args) {
        
    }
}
