import java.util.ArrayDeque;

import javax.sound.midi.Track;

public class targetSumSubset {
    

    static void Solution(int arr[], int target){
        boolean dp[][] = new boolean[arr.length+1][target+1];
        // 4,2,7,1,3
        // tgt = 10
        for(int j=0; j<dp[0].length; j++){
            for(int i=0; i<dp.length; i++){
                if(j==0){
                    dp[i][j] = true;
                }else if(i==0){
                    dp[i][j] = false;
                }else{
                    int rem = j-arr[i-1];
                    if(rem>=0){
                        dp[i][j] = dp[i-1][rem];
                    }
                    dp[i][j] = (dp[i][j] || dp[i-1][j]);
                }
            }   
        }
        for(boolean val[]: dp){
            for(boolean a: val){
                if(a)
                System.out.print("T ");
                else
                System.out.print("F ");
            }
            System.out.println();
        }
        printPath(arr, dp, target);
    }   
    static class Pair{
        int i;
        int j;
        String asf;
        Pair(int i, int j, String asf){
            this.i =i;
            this.j =j;
            this.asf = asf;
        }
    }
    static void printPath(int arr[], boolean dp[][], int target){
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(dp.length-1, dp[0].length-1, ""));
        // 4,2,7,1,3
        while(queue.size()>0){
            Pair peek = queue.pop();
            int i=peek.i;
            int j = peek.j;
            if(j==0){
                System.out.println(peek.asf);
                continue;
            }
            if(dp[i-1][j]==true){
                queue.add(new Pair(i-1, j, peek.asf));
            }
            if(j-arr[i-1]>=0 && dp[i-1][j-arr[i-1]]==true){
                queue.add(new Pair(i-1, j-arr[i-1], (i-1)+" "+peek.asf));
            }
        }
    }


    public static void main(String[] args) {
        int arr[] = {4,2,7,1,3};
        int target =10;
        Solution(arr, target);
    }
}
