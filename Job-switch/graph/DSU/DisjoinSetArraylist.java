package DSU;

import java.util.ArrayList;

public class DisjoinSetArraylist {

    ArrayList<Integer> rank = new ArrayList<>();
    ArrayList<Integer> parent = new ArrayList<>();

    public DisjoinSetArraylist(int n){
        for(int i=0; i<n; i++){
            rank.add(0);
            parent.add(i);
        }
    }

    public int findParent(int x) {
        if (parent.get(x) == x) {
            return x;
        }
        int ulp = findParent(parent.get(x));
        parent.set(x, ulp);
        return parent.get(x);
    }

    public void unionByRank(int u, int v) {
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);
        if (ulp_u == ulp_v)
            return;
        if (rank.get(ulp_u) > rank.get(ulp_v)) { // rank of u is more
            parent.set(ulp_v, ulp_u);
        } else if (rank.get(ulp_u) < rank.get(ulp_v)) { // rank of v is more
            parent.set(ulp_u, ulp_v);
        } else { // rank is same so set u as parent of v and increase rank of lpu by 1
            parent.set(ulp_v, ulp_u);
            int rankU = rank.get(ulp_u);
            rank.set(ulp_u, rankU + 1);
        }
    }

}
