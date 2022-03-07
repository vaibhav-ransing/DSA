import java.util.ArrayDeque;
import java.util.Stack;

public class targetSumSubset {
    
    static void soln(int sum, int arr[]){
        boolean dp[][] = new boolean[arr.length+1][sum+1];
        dp[0][0]=true;
        for(int i=1; i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=dp[i-1][j];
                if(j-arr[i-1]>=0){
                    if(dp[i-1][j-arr[i-1]]==true){
                        dp[i][j]=true;
                    }
                }
            }
        }
        // display(dp);
        System.out.println(dp[dp.length-1][dp[0].length-1] );
        if(dp[dp.length-1][dp[0].length-1])
            printPath(dp, arr);
    }
    static class Pair{
        String psf;
        int i;
        int j;
        Pair(String psf, int i, int j){
            this.psf = psf;
            this.i = i;
            this.j = j;
        }
    }

    static void display(boolean dp[][]){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j] +" ");
            }
            System.out.println();
        }
    }

    static void printPath(boolean dp[][], int arr[]){
        int n = dp.length;
        int m = dp[0].length;
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair("", n-1, m-1));

        while(queue.size()>0){
            Pair peek = queue.pop();
            int r = peek.i;
            int c = peek.j;

            boolean excluded = dp[r-1][c];
            if(excluded){
                queue.add(new Pair(peek.psf, r-1, c));
            }

            boolean included=false;
            if(c - arr[r-1]>0){
                included = dp[r-1][c-arr[r-1]];
                if(included){
                    queue.add(new Pair((r-1+" ")+peek.psf, r-1, c-arr[r-1] ));
                }
            }
            if(!excluded && !included ){
                System.out.println((r-1)+" "+ peek.psf);
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {4,2,7,1,3};
        soln(10, arr);

    }
}
