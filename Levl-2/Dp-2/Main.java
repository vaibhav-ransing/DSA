import java.util.HashMap;
import java.util.Scanner;
public class Main{

    // LIS
    public static int solution(int m , int[] x, int[] rev, int t) {

        int dp[] = new int[x.length];
        dp[0] = rev[0];
        for(int i=1; i<dp.length; i++){
            dp[i] = rev[i];
            for(int j=0; j<i; j++){
                int ld = x[j];
                if(ld+t <x[i]){
                    dp[i] = Math.max(dp[i], dp[j]+rev[i]);
                }
            }
        }
        int max = 0;
        for(int val: dp){
            max = Math.max(max, val);
        }
        return max;
    }

    // KnapSack
    public static int solution2(int m , int[] x, int[] rev, int t) {
        int dp[] = new int[m];
        int j=0;

        for(int i=1; i<dp.length; i++){
            if(j<x.length && x[j]==i){
                int take = rev[j];
                if(i-t-1>=0){
                    take+=dp[i-t-1];
                }
                dp[i] = Math.max(dp[i-1], take);
                j++;
            }else{
                dp[i] = dp[i-1];
            }
        }
        return dp[dp.length-1];
    }

    public static int solution3(int n , int[] BB, int[] rev, int dis) {

        int dp[] = new int[n+1];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<BB.length; i++){
            map.put(BB[i], rev[i]);
        }
        for(int i=1; i<dp.length; i++){
            if(map.containsKey(i)){
                 int take =  map.get(i);
                if(i-dis-1>=0) take+=dp[i-dis-1]; 
                dp[i] = Math.max(dp[i-1], take);
            }else{
                dp[i] = dp[i-1];
            }
        }
        return dp[dp.length-1];
    }

    
    public static void input(int []arr,Scanner scn){
        for(int i = 0;i<arr.length;i++){
            arr[i] = scn.nextInt();
        }
    }
    public static void main(String []args){
        Scanner scn = new Scanner(System.in);   
        int m = scn.nextInt();
        int n = scn.nextInt();
        
        int x[] = new int[n];
        input(x, scn);

        int revenue[] = new int[n];
        input(revenue,scn);

        int t = scn.nextInt();

        System.out.println(solution(m, x, revenue, t));
        scn.close();
    }
}