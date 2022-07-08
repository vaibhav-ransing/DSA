import java.util.*;

public class smallestStringWithSwap1202 {
    
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        
        parent = new int[s.length()];
        rank = new int[s.length()];
        for(int i=0; i<parent.length; i++){
            parent[i]=i;
        }
        for(List<Integer> pair: pairs){
            int lx = find(pair.get(0));
            int ly = find(pair.get(1));
            if(lx!=ly){
                union(lx, ly);
            }
        }
        HashMap<Integer, PriorityQueue<Character>> map = new HashMap<>();
        for(int i=0; i<parent.length; i++){
            if(parent[i]==i){
                map.put(i, new PriorityQueue<>());
            }
        }
        for(int i=0; i<s.length(); i++){
            int li = find(i);
            map.get(li).add(s.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0 ;i<s.length(); i++){
            int li = find(i);
            char ch = map.get(li).remove();
            sb.append(ch);
        }
        return sb.toString();
    }
    static int[] parent;
    static int[] rank;

    static int find(int x){
        if(parent[x]==x){
            return x;
        }else{
            int temp = find(parent[x]);
            parent[x] = temp;
            return temp;
        }
    }
    static void union(int x, int y){
        if(rank[x]>rank[y]){
            parent[y] = x;
        }else if(rank[x]<rank[y]){
            parent[x] = y;
        }else{
            parent[y]=x;
            rank[x]++;
        }
    }

}
