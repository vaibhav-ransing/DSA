import java.util.HashSet;

public class satisfiability990{

    static int parent[];
    static int rank[];
    public static boolean equationsPossible(String[] equations) {
        
        HashSet<Integer> set = new HashSet<>();
        for(String eq: equations){
            int c1 = eq.charAt(0) - 'a';
            int c2 = eq.charAt(3) - 'a';
            set.add(c1);
            set.add(c2);
        } 

        parent = new int[set.size()];
        rank = new int[set.size()];
        for(int i=0; i<equations.length; i++){
            parent[i] = i;
            rank[i]=0;
        }
        for(String eq: equations){
            if(eq.charAt(1)=='='){
                int c1 = eq.charAt(0) - 'a';
                int c2 = eq.charAt(3) - 'a';
                int lx = find(c1);
                int ly = find(c2);
                System.out.println(eq.charAt(0)+lx+" " +" "+ eq.charAt(3)+" "+ly);
                if(lx!=ly){
                    union(lx, ly);
                }
            }
        }
        for(String eq: equations){
            if(eq.charAt(1)=='!'){
                int c1 = eq.charAt(0) - 'a';
                int c2 = eq.charAt(3) - 'a';
                int lx = find(c1);
                int ly = find(c2);
                System.out.println(eq.charAt(0)+lx+" " +" "+ eq.charAt(3)+" "+ly);
                if(lx==ly){
                    System.out.println("false "+ eq.charAt(0)+lx+" " +" "+ eq.charAt(3)+" "+ly);
                    return false;
                }
            }
        }
        return true;
    }

    static int find(int x){
        if(parent[x]==x){
            return x;
        }else{
            parent[x] = find(parent[x]);
            return parent[x];
        }
    }
    static void union(int x, int y){
        if(rank[x]>rank[y]){
            parent[y] = x;
        }else if(rank[x] < rank[y]){
            parent[x] = y;
        }else{
            parent[y] = x;
            rank[x]++;
        }
    }


    public static void main(String[] args) {
        String arr[] = {"c==c","b==d","x!=z"};
        equationsPossible(arr);
    }
}
