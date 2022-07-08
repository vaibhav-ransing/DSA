import java.util.Scanner;

public class alawansPuzzle {
    // https://codeforces.com/contest/1534/problem/C
    static int M = (int)(1e9+7);
    static void solution(int arr[], int nrr[]){

        int n = arr.length+1;
        parent = new int[n];
        rank = new int[n];
        size = new int[n];
        for(int i=0; i<parent.length; i++){
            parent[i]=i;
            size[i]=1;
        }
        for(int i=0; i<arr.length; i++){
            int lx = find(arr[i]);
            int ly = find(nrr[i]);
            if(lx!=ly){
                union(lx, ly);
            }
        }
        int ans =1;
        for(int i=1; i<parent.length; i++){
            if(parent[i]==i){
                ans = ((ans%M)*(2%M))%M;

            }
        }
        System.out.println(ans);
    }
    static int[] parent;
    static int[] rank;
    static int[] size;

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
            size[x] = size[x]+size[y];
            parent[y] = x;
        }else if(rank[x]<rank[y]){
            size[y] = size[y]+size[x];
            parent[x] = y;
        }else{
            size[x]+=size[y];
            parent[y]=x;
            rank[x]++;
        }
    }
    


    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int T = scn.nextInt();

        while(T!=0){
            int len = scn.nextInt();
            int arr[] = new int[len];
            int nrr[] = new int[len];
            for(int i=0; i<len; i++){
                arr[i] = scn.nextInt();
            }
            for(int i=0; i<len; i++){
                nrr[i] = scn.nextInt();
            }
            solution(arr, nrr);
            T--;
        }
    }
}
