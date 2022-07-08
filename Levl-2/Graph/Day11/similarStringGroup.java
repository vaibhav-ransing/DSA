import java.util.HashSet;

public class similarStringGroup {

    static int rank[];
    static int parent[];

    // Input: strs = ["tars","rats","arts","star"]
    // Output: 2
    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        rank = new int[n];
        parent = new int[n];
        for(int i=0 ;i<n; i++){
            for(int j=i+1; j<n; j++){
                if(isSimilar(strs[i], strs[j])){
                    int lx = find(i);
                    int ly = find(j);
                    if(lx!=ly){
                        union(lx, ly);
                    }
                }
            }
        }
        HashSet<Integer> set = new HashSet<>();
        for(int val: parent){
            set.add(val);
        }
        return set.size();
    }

    static boolean isSimilar(String s1, String s2){
        int count=0;
        for(int i=0; i<s1.length(); i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                count++;
            }
        }
        return count>2?false:true;
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
