package DSU;

import java.util.Arrays;
import java.util.stream.IntStream;

public class CountNumberOfCOmpleteComp2685 {

    public static void dsuBuilder(int[][] array, int n) {

        int[] ranks = new int[n];
        int[] parent = new int[n];

        IntStream.range(0, n).forEach(i -> parent[i] = i);

        for (int[] edg : array) { // u, v
            int pu = edg[0];
            int pv = edg[1];
            System.out.println(pu +" "+pv);
            while (parent[pu] != pu) {
                pu = parent[pu];
            }
            while (parent[pv] != pv) {
                pv = parent[pv];
            }
            System.out.println(pu +" "+pv);
            System.out.println("------");
            if(ranks[pu] >= ranks[pv]){
                ranks[pu] = Math.max(ranks[pu], ranks[pv] + 1);
                parent[pv] = pu;
                for(int i=0; i<parent.length; i++){
                    if(parent[i] == pv) parent[i] = pu;
                }
                
            }else{
                ranks[pv] = Math.max(ranks[pv], ranks[pu] + 1);
                parent[pu] = pv;
                for(int i=0; i<parent.length; i++){
                    if(parent[i] == pu) parent[i] = pv;
                }
            }
        }
        System.out.println(Arrays.toString(ranks));
        System.out.println(Arrays.toString(parent));
    }

    public static void main(String[] args) {
        // int[][] array = {
        //         { 0, 1 },
        //         { 0, 2 },
        //         { 1, 2 },
        //         { 3, 4 }
        // };

        int[][] array = {
            { 1, 2 },
            { 2, 3 },
            { 4, 5 },
            { 6, 7 },
            { 5, 6 },
            // { 3, 7 }
        };

        dsuBuilder(array, 8);

    }
}
