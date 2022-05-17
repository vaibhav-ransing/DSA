import java.util.Arrays;

public class russianDol {
    
    static class pair implements Comparable<pair>{
        int ht;
        int wd;
        pair(int ht, int wd){
            this.ht = ht;
            this.wd = wd;
        }
        public int compareTo(pair o){
            return this.wd - o.wd;
        }
    }
    static void solution(int len[], int wid[]){
        pair arr[] = new pair[len.length];
        for(int i=0; i<len.length; i++){
            arr[i] = new pair(len[i], wid[i]);
        }
        Arrays.sort(arr);
        int dp[] = new int[arr.length];
        dp[0]=1;
        for(int i=1; i<dp.length; i++){
            for(int j=0; j<i; j++){
                if(arr[j].ht < arr[i].ht){
                    dp[i] = Math.max(dp[i], dp[j]);
                }
                dp[i]+=1;
            }
        }
        int ans = 0;
        for(pair val: arr){
            System.out.print(val.wd +" "+ val.ht);
        }
        System.out.println();
        for(int i=0;i<arr.length;i++){
            System.out.print(dp[i]+" ");
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);
    }


    public static void main(String[] args) {
        
    }
}
