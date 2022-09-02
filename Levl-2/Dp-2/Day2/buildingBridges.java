package Day2;
import java.util.*;

public class buildingBridges {

    public static class pair implements Comparable<pair>{
        int np;
        int sp;
        pair(int np, int sp){
            this.np = np;
            this.sp = sp;
        }
        public int compareTo(pair o){
            return this.np - o.np;
        }
    }

    static void overlappingBridges(int arr1[], int arr2[]){
        ArrayList<pair> list = new ArrayList<>();
        for(int i=0; i<arr1.length; i++){
            pair p = new pair(arr1[i], arr2[i]);
            list.add(p);
        }
        Collections.sort(list);
        int dp[] = new int[arr1.length];
        dp[0]=1;
        for(int i=1; i<dp.length; i++){
            dp[i]=1;
            for(int j=0; j<i; j++){
                
                if(list.get(i).sp> list.get(j).sp){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }
        int max = 0;
        for(int val: dp){
            max = Math.max(max, val);
        }
        System.out.println(max);
    }

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int north[] = new int[n];
        int south[] = new int[n];
        for(int i=0;i<n;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            north[i] = x;
            south[i] = y;
        }
        overlappingBridges(north, south);
    }

}